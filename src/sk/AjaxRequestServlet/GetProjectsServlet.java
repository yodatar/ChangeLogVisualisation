package sk.AjaxRequestServlet;

import sk.BusinessLogic.DatabaseRequestHandlers;
import sk.BusinessLogic.ProjectsEntity;

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


public class GetProjectsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DatabaseRequestHandlers databaseRequestHandlers = new DatabaseRequestHandlers();
        List<ProjectsEntity> rcsProjectDtoList = databaseRequestHandlers.getProjects(req.getSession());

        req.setAttribute("allProjects", rcsProjectDtoList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
