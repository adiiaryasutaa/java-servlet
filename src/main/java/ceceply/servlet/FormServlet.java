package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path = null;
		try {
			path = Path.of(FormServlet.class.getResource("/html/form.html").toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		String response = Files.readString(path);

		resp.getWriter().println(response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");

		String response = "Hello " + firstname + " " + lastname;

		resp.getWriter().println(response);
	}
}
