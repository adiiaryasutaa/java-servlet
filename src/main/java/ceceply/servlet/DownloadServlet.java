package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String file = req.getParameter("file");
		String force = req.getParameter("force");

		Path path = Path.of("media/uploads/" + file);

		if ("true".equals(force)) {
			resp.setHeader("Content-Disposition", "attachment; filename\"" + path.getFileName() + "\"");
		}

		resp.getOutputStream().write(Files.readAllBytes(path));
	}
}
