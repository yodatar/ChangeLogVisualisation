package sk.Servlets;

import org.json.simple.JSONObject;
import sk.BusinessLogic.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Date: 5.3.2014
 *
 * Servlet pre Ajaxove volanie "ajaxGetProjectTree"
 */
public class GetProjectTreeServlet extends HttpServlet {
	/**
	 * @see sk.BusinessLogic.Controller#getProjectTree()
	 * @param request bez parametrov
	 * @param response JSONObject
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Controller controller = new Controller();
		JSONObject jsonObject = controller.getProjectTree();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}
