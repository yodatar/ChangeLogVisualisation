package sk.Servlets;

import org.json.simple.JSONArray;
import sk.BusinessLogic.Controller;
import sk.BusinessLogic.Resources;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Date: 7.12.2013
 */

/**
 * Servlet pre Ajaxove volanie "ajaxGetAllChangesets"
 */
public class GetAllChangesetsServlet extends HttpServlet {

	/**
	 * @see sk.BusinessLogic.Controller#getChangesetList()
	 * @param request obsahuje parameter "data" = projectId
	 * @param response JSONObject
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getParameter("data") != null && !request.getParameter("data").equals(""))
			Resources.getInstance().setProjectId(Integer.parseInt(request.getParameter("data")));

		Controller controller = new Controller();
		JSONArray changesetList = controller.getChangesetList();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(changesetList);
	}
}