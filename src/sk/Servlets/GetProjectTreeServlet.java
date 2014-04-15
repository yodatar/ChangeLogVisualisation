package sk.Servlets;

import org.json.simple.JSONObject;
import sk.BusinessLogic.DatabaseRequestHandlers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 16:48
 */


public class GetProjectTreeServlet extends HttpServlet {

	JSONObject jsonObject = new JSONObject();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DatabaseRequestHandlers databaseRequestHandlers = new DatabaseRequestHandlers();
		jsonObject = databaseRequestHandlers.getProjectTree();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}
