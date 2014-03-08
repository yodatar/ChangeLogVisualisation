package sk.AjaxRequestServlet;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONObject;
import sk.BusinessLogic.BusinessLogic;
import sk.JsonConverter.TransformToJson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 16:48
 */


public class GetProjectTreeServlet extends HttpServlet {

    JSONObject jsonObject = new JSONObject();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BusinessLogic businessLogic = new BusinessLogic();
        List<FileVersionDto> fileVersionDtos = businessLogic.getProjectTree(request.getSession());

        TransformToJson transformToJson = new TransformToJson();
        jsonObject = transformToJson.projectTreeToJson(fileVersionDtos);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
    }
}
