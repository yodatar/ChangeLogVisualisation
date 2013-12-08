package sk;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:16
 */


public class GetAllUsersServlet extends HttpServlet {
    IAstRcsWcfSvc iAstRcsWcfSvc;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AstRcsDatabase astRcsDatabase = new AstRcsDatabase();
        iAstRcsWcfSvc = astRcsDatabase.getIAstRcsWcfSvc();

        SearchUsersResponse resp = iAstRcsWcfSvc.searchUsers(new SearchUsersRequest());
        List<UserDto> listUsersDto = resp.getUsers().getValue().getUserDto();

        JSONArray list = new JSONArray();
        for (UserDto usersDto : listUsersDto) {
            Map pairs = new LinkedHashMap();
            pairs.put("name",usersDto.getLogin().getValue());
            pairs.put("size",usersDto.getId());
            list.add(pairs);
        }

        JSONObject obj = new JSONObject();
        obj.put("name", "Pali");
        obj.put("children", list);

        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        out.print(obj);
    }
}