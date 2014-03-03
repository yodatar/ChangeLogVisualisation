package sk;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:16
 */


public class GetAllUsersServlet extends HttpServlet {
   IAstRcsWcfSvc iAstRcsWcfSvc;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        iAstRcsWcfSvc = new AstRcsDatabaseFactory().getIAstRcsWcfSvc();
        JSONArray list = new JSONArray();


        /////////////////////////
        GetChangesetRequest req3 = new GetChangesetRequest();
        req3.setChangesetId(100);
        GetChangesetResponse resp3 = iAstRcsWcfSvc.getChangeset(req3);
        ChangesetDto dto = resp3.getChangeset().getValue();

        Map pairs = new LinkedHashMap();
        pairs.put("name",dto.getCommitter().getValue().getLogin().getValue());
        pairs.put("size",dto.getId());
        list.add(pairs);

        ///////////
        SearchFilesRequest req4 = new SearchFilesRequest();
        req4.setChangesetId(500);
        req4.setPageSize(10);
        SearchFilesResponse resp4 = iAstRcsWcfSvc.searchFiles(req4);
/*
        for(FileVersionDto file : resp4.getFileVersions().getValue().getFileVersionDto()) {
            pairs = new LinkedHashMap();
            pairs.put("name",file.getUrl().getValue());
            pairs.put("size", file.getUrl().getValue());
            list.add(pairs);
        }
*/
        SearchFoldersRequest req5 = new SearchFoldersRequest();
        req5.setChangesetId(500);
        req5.setPageSize(50);
        SearchFoldersResponse resp5 = iAstRcsWcfSvc.searchFolders(req5);

        for(String folder : resp5.getFolders().getValue().getString()) {
            pairs = new LinkedHashMap();
            pairs.put("<br>name",folder);
            pairs.put("size","");
            list.add(pairs);
        }

        /*
        ObjectFactory objectFactory = new ObjectFactory();
        GetFilesByGitIdentifiersRequest req2 = new GetFilesByGitIdentifiersRequest();
        ArrayOfFileGitIdentifierDto gitId = new ArrayOfFileGitIdentifierDto();
        FileGitIdentifierDto asdf = new FileGitIdentifierDto();
        asdf.setChangesetIdInRcs(dto.getIdInRcs());
        gitId.getFileGitIdentifierDto().add(asdf);
        GetFilesByGitIdentifiers identifiers = objectFactory.createGetFilesByGitIdentifiers();

        req2.setIdentifiers();

        JAXBElement<GetFilesByGitIdentifiersRequest> request1 = objectFactory.createGetFilesByGitIdentifiersRequest(req2);


        GetFilesByGitIdentifiersResponse resp2 = iAstRcsWcfSvc.getFilesByGitIdentifiers(request1.getValue());
        ArrayOfFileVersionDto listDto2 = resp2.getVersions().getValue();

        for (FileVersionDto fileVersionList : listDto2.getFileVersionDto()) {
            pairs = new LinkedHashMap();
            pairs.put("name",fileVersionList.getUrl().getValue());
            pairs.put("size",fileVersionList.getId());
            list.add(pairs);
        }
*/


        JSONObject obj = new JSONObject();
        obj.put("name", "name");
        obj.put("children", list);

        System.out.println(obj);

        //response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        out.print(obj);
    }
}