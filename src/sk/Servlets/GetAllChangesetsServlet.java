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
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:16
 */


public class GetAllChangesetsServlet extends HttpServlet {

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