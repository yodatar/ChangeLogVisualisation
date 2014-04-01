package sk.AjaxRequestServlet;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import sk.BusinessLogic.DatabaseRequestHandlers;
import sk.BusinessLogic.Resources;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 10.3.2014
 * Time: 18:54
 */


public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("projectSelect") != null && req.getParameter("projectSelect") != "")
			Resources.getInstance().setProjectId(Integer.parseInt(req.getParameter("projectSelect")));
		if (req.getParameter("changesetFrom") != null && req.getParameter("changesetFrom") != "")
			Resources.getInstance().setChangesetFromId(Integer.parseInt(req.getParameter("changesetFrom")));
		if (req.getParameter("changesetTo") != null && req.getParameter("changesetTo") != "")
			Resources.getInstance().setChangesetToId(Integer.parseInt(req.getParameter("changesetTo")));

		DatabaseRequestHandlers databaseRequestHandlers = new DatabaseRequestHandlers();
		List<ProjectsEntity> rcsProjectDtoList = databaseRequestHandlers.getProjects();
		List<UsersEntity> userDtoList = databaseRequestHandlers.getAllUsers();
		ChangesetDto changesetDto = databaseRequestHandlers.getChangeset();

		req.setAttribute("commiterId", changesetDto.getCommitter().getValue().getId());
		req.setAttribute("changesetFromId", Resources.getInstance().getChangesetFromId());
		req.setAttribute("changesetToId", Resources.getInstance().getChangesetToId());
		req.setAttribute("projectSelect", req.getParameter("projectSelect"));
		req.setAttribute("allProjects", rcsProjectDtoList);
		req.setAttribute("allUsers", userDtoList);
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}