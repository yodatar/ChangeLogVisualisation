package sk.AjaxRequestServlet;

import sk.BusinessLogic.Resources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 8.3.2014
 * Time: 17:36
 */

// TODO: to delete

public class SetResourcesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer projectId = Integer.parseInt(request.getParameter("projectId"));
		//Integer changesetId = Integer.parseInt(request.getParameter("changesetId"));
		Resources.getInstance().setProjectId(projectId);
		//Resources.getInstance().setChangesetFromId(changesetId);

		PrintWriter out = response.getWriter();
		out.print("true");
	}
}

