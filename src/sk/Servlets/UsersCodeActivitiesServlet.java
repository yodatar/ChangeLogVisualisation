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
 * Servlet pre Ajaxove volanie "ajaxUsersCodeActivities"
 */
public class UsersCodeActivitiesServlet extends HttpServlet {
	/**
	 * @see Controller#getUsersCodeActivities(String)
	 * @param request user = username
	 * @param response JSONObject
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Controller controller = new Controller();
		JSONObject jsonObject = controller.getUsersCodeActivities(request.getParameter("user"));

		response.setContentType("application/json");
		PrintWriter output = response.getWriter();
		output.print(jsonObject);
	}
}