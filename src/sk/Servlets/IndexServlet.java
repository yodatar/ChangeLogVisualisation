package sk.Servlets;

import sk.BusinessLogic.DatabaseHandlers;
import sk.BusinessLogic.Resources;
import sk.BusinessLogic.entities.ProjectsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 10.3.2014
 * Time: 18:54
 */


public class IndexServlet extends HttpServlet {
	private static final Pattern PATH_SEPARATOR = Pattern.compile("/");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("projectSelect") != null && !req.getParameter("projectSelect").equals(""))
			Resources.getInstance().setProjectId(Integer.parseInt(req.getParameter("projectSelect")));
		if (req.getParameter("changesetFrom") != null && !req.getParameter("changesetFrom").equals(""))
			Resources.getInstance().setChangesetFromId(Integer.parseInt(req.getParameter("changesetFrom")));
		if (req.getParameter("changesetTo") != null && !req.getParameter("changesetTo").equals(""))
			Resources.getInstance().setChangesetToId(Integer.parseInt(req.getParameter("changesetTo")));

		DatabaseHandlers databaseHandlers = new DatabaseHandlers();
		List<ProjectsEntity> rcsProjectDtoList = databaseHandlers.getProjects();

		//
		for (ProjectsEntity projectsEntity : rcsProjectDtoList) {
			String[] pieces = PATH_SEPARATOR.split(projectsEntity.getName());
			projectsEntity.setName(pieces[pieces.length - 1]);
		}

		Resources.getInstance().setChangesetFrom(databaseHandlers.getChangeset(Resources.getInstance().getChangesetFromId()));
		Resources.getInstance().setChangesetTo(databaseHandlers.getChangeset(Resources.getInstance().getChangesetToId()));
		Resources.getInstance().setProjectDto(rcsProjectDtoList.get(Resources.getInstance().getProjectId() - 1));

		req.setAttribute("changesetFromId", Resources.getInstance().getChangesetFromId());
		req.setAttribute("changesetToId", Resources.getInstance().getChangesetToId());
		req.setAttribute("projectSelect", Resources.getInstance().getProjectId());
		req.setAttribute("allProjects", rcsProjectDtoList);
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
