package sk.Servlets;

import org.json.simple.JSONObject;
import sk.BusinessLogic.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Date: 7.12.2013
 *
 * Servlet pre Ajaxove volanie "ajaxGetDevelepers"
 */
public class GetDevelepersServlet extends HttpServlet {
	/**
	 * @see sk.BusinessLogic.Controller#getUsersPerProject()
	 * @param request bez vstupnych parametrov
	 * @param response JSONObject
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new Controller().getUsersPerProject();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}