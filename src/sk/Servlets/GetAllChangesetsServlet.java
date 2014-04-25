package sk.Servlets;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.json.simple.JSONArray;
import sk.BusinessLogic.DatabaseHandlers;
import sk.BusinessLogic.JsonConverter.TransformToJson;
import sk.BusinessLogic.Resources;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


		DatabaseHandlers databaseHandlers = new DatabaseHandlers();
		List<ChangesetDto> changesetDtoList = databaseHandlers.getChangesetList(null, null);

		TransformToJson transformToJson = new TransformToJson();
		JSONArray jsonArray = transformToJson.changesetListToJson(changesetDtoList);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
	}
}