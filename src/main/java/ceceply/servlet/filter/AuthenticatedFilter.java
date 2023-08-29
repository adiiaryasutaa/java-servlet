package ceceply.servlet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthenticatedFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request.getRequestURI().equals("/login")) {
			chain.doFilter(request, response);
		}

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			chain.doFilter(request, response);
		} else {
			response.setStatus(401);
			response.getWriter().println("[401 Unauthorized] You need to login first");
		}
	}
}
