package sk.Servlets;

import org.json.simple.JSONObject;
import sk.BusinessLogic.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:16
 */


public class UsersCodeActivitiesServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println(request.getParameter("user"));

		Controller controller = new Controller();
		JSONObject jsonObject = controller.getUsersCodeActivities(request.getParameter("user"));

		response.setContentType("application/json");
		PrintWriter output = response.getWriter();
		output.print(jsonObject);
	}
}