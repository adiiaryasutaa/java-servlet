package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig
public class UploadFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path;
		try {
			path = Path.of(UploadFormServlet.class.getResource("/html/upload.html").toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		String response = Files.readString(path);

		resp.getWriter().println(response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Part uploadedFile = req.getPart("upload");

		Path saveLocation = Path.of("media/uploads/" + UUID.randomUUID() + "-uploaded-by-" + name + "-" + uploadedFile.getSubmittedFileName());
		Files.copy(uploadedFile.getInputStream(), saveLocation);

		Path path;
		try {
			path = Path.of(UploadFormServlet.class.getResource("/html/after-upload.html").toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		String response = Files.readString(path)
			.replace("{name}", name)
			.replace("{filename}", saveLocation.getFileName().toString())
			.replace("{filesrc}", "/download?file=" + saveLocation.getFileName().toString());

		resp.getWriter().println(response);
	}
}
