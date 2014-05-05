package sk.Servlets;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import sk.BusinessLogic.Controller;
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
 * Date: 10.3.2014
 *
 * Servlet volany pri znovunacitani vizualizacie.
 * Preposiela atributy do template.jsp
 */
public class VisualisationServlet extends HttpServlet {
	private static final Pattern PATH_SEPARATOR = Pattern.compile("/");

	/**
	 * @see sk.BusinessLogic.Controller#getProjects()
	 * @see Controller#getChangeset(Integer)
	 *
	 * @param req dopyt obsahuje parametre:
	 *            - projectSelect = projectId
	 *            - changesetFrom = changesetFromId
	 *            - changesetTo = changesetToId
	 *
	 * @param resp forward
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("projectSelect") != null && !req.getParameter("projectSelect").equals(""))
			Resources.getInstance().setProjectId(Integer.parseInt(req.getParameter("projectSelect")));
		if (req.getParameter("changesetFrom") != null && !req.getParameter("changesetFrom").equals(""))
			Resources.getInstance().setChangesetFromId(Integer.parseInt(req.getParameter("changesetFrom")));
		if (req.getParameter("changesetTo") != null && !req.getParameter("changesetTo").equals(""))
			Resources.getInstance().setChangesetToId(Integer.parseInt(req.getParameter("changesetTo")));

		Controller controller = new Controller();
		List<ProjectsEntity> projectsEntityList = controller.getProjects();
		ChangesetDto changesetFrom = controller.getChangeset(Resources.getInstance().getChangesetFromId());
		ChangesetDto changesetTo = controller.getChangeset(Resources.getInstance().getChangesetToId());

		for (ProjectsEntity projectsEntity : projectsEntityList) {
			String[] pieces = PATH_SEPARATOR.split(projectsEntity.getName());
			projectsEntity.setName(pieces[pieces.length - 1]);
		}

		Resources.getInstance().setChangesetFrom(changesetFrom);
		Resources.getInstance().setChangesetTo(changesetTo);
		Resources.getInstance().setProjectDto(projectsEntityList.get(Resources.getInstance().getProjectId() - 1));

		req.setAttribute("changesetFromId", Resources.getInstance().getChangesetFromId());
		req.setAttribute("changesetToId", Resources.getInstance().getChangesetToId());
		req.setAttribute("projectSelect", Resources.getInstance().getProjectId());
		req.setAttribute("allProjects", projectsEntityList);

		req.setAttribute("from", "vis");
		getServletContext().getRequestDispatcher("/template.jsp").forward(req, resp);
	}
}
