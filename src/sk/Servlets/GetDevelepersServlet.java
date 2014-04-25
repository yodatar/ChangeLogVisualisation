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

public class GetDevelepersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new Controller().getUsersPerProject();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}