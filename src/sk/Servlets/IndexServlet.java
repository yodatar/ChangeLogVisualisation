package sk.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 10.3.2014
 *
 * Servlet domovskej stranky preposiela obsah do template.jsp
 */
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("from", "home");
		getServletContext().getRequestDispatcher("/template.jsp").forward(req, resp);
	}
}
