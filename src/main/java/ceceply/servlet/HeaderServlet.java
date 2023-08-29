package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> headerNames = req.getHeaderNames();

		String name;
		while ((name = headerNames.nextElement()) != null) {
			String value = req.getHeader(name);

			resp.getWriter().println(name + ": " + value);
		}
	}
}
