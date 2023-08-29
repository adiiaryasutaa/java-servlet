package ceceply.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/todo")
public class TodoListServlet extends HttpServlet {
	// I know this is unsafe
	// But this just for example :D
	private ArrayList<String> todos = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(todos);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String todo = req.getParameter("todo");

		if (todo != null) {
			todos.add(todo);
			resp.getWriter().println("Add todo : " + todo);
		} else {
			resp.getWriter().println("Todo parameter must exists");
		}
	}
}
