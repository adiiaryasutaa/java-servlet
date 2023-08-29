package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Method : " + req.getMethod());
		resp.getWriter().println("Query string : " + req.getQueryString());
		resp.getWriter().println("Context path : " + req.getContextPath());
		resp.getWriter().println("Servlet path : " + req.getServletPath());
		resp.getWriter().println("Request URI : " + req.getRequestURI());
	}
}
