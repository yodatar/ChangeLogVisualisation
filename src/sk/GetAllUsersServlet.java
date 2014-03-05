package sk;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.CodeEntityVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.RcsProjectDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        iAstRcsWcfSvc = new AstRcsDatabaseFactory().getIAstRcsWcfSvc();
        JSONArray list = new JSONArray();
        Map pairs;

        SearchRcsProjectsRequest projectsRequest = new SearchRcsProjectsRequest();
        projectsRequest.setPageSize(100);
        SearchRcsProjectsResponse projectsResponse = iAstRcsWcfSvc.searchRcsProjects(projectsRequest);
        List<RcsProjectDto> listRcsProjectDto = projectsResponse.getRcsProjects().getValue().getRcsProjectDto();
        for(RcsProjectDto rcsProjectDto : listRcsProjectDto) {
            pairs = new LinkedHashMap();
            pairs.put("<br>name", rcsProjectDto.getUrl().getValue());
            pairs.put("size",rcsProjectDto.getId());
            //list.add(pairs);
        }

        SearchChangesetsRequest changesetsRequest = new SearchChangesetsRequest();
        changesetsRequest.setRcsProjectId(1);
        changesetsRequest.setPageSize(100);
        changesetsRequest.setPageIndex(2);
        for(ChangesetDto changesetDto : iAstRcsWcfSvc.searchChangesets(changesetsRequest).getChangesets().getValue().getChangesetDto())
        {
            pairs = new LinkedHashMap();
            pairs.put("<br>id",changesetDto.getId());
            pairs.put("time",changesetDto.getTimeStamp().toGregorianCalendar().getTime());
           // list.add(pairs);
        }

        /////////////////////////
        GetChangesetRequest req3 = new GetChangesetRequest();
        req3.setChangesetId(2203);
        GetChangesetResponse resp3 = iAstRcsWcfSvc.getChangeset(req3);
        ChangesetDto dto = resp3.getChangeset().getValue();

        pairs = new LinkedHashMap();
        pairs.put("commiter",dto.getCommitter().getValue().getLogin().getValue());
        pairs.put("id",dto.getId());
        //list.add(pairs);

        // SearchFiles
        SearchFilesRequest req4 = new SearchFilesRequest();
        req4.setChangesetId(2203);
        req4.setPageSize(5);
        List<FileVersionDto> listFileVersionDto = iAstRcsWcfSvc.searchFiles(req4).getFileVersions().getValue().getFileVersionDto();

        for(FileVersionDto file : listFileVersionDto ) {
            pairs = new LinkedHashMap();
            pairs.put("<br>FileName",file.getUrl().getValue());
            pairs.put("change",file.getId());
            list.add(pairs);
        }

        // SearchFolders
        SearchFoldersRequest req5 = new SearchFoldersRequest();
        req5.setChangesetId(2203);
        req5.setPageSize(10);
        SearchFoldersResponse resp5 = iAstRcsWcfSvc.searchFolders(req5);

        for(String folder : resp5.getFolders().getValue().getString()) {
            pairs = new LinkedHashMap();
            pairs.put("<br>Folder",folder);
            pairs.put("size","");
            list.add(pairs);
        }

        // SearchCodeEntities
        MyObjectFactory myObjectFactory = new MyObjectFactory();
        org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ObjectFactory gratexObjFact = new org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ObjectFactory();
        SearchCodeEntitiesRequest searchCodeEntitiesRequest = gratexObjFact.createSearchCodeEntitiesRequest();
        searchCodeEntitiesRequest.setFileVersionId(myObjectFactory.createFileVersionIdInteger(2203));

        SearchCodeEntitiesResponse searchCodeEntitiesResponse = iAstRcsWcfSvc.searchCodeEntities(searchCodeEntitiesRequest);
        List<CodeEntityVersionDto> listCodeEntityVersionDto = searchCodeEntitiesResponse.getCodeEntityVersions().getValue().getCodeEntityVersionDto();
        for(CodeEntityVersionDto codeEntityVersionDto : listCodeEntityVersionDto ){
            pairs = new LinkedHashMap();
            pairs.put("<br>EntityType",codeEntityVersionDto.getDeclaration().getValue().getModifier().getValue());
            pairs.put("id",codeEntityVersionDto.getDeclaration().getValue().getName().getValue());
            list.add(pairs);
        }



        // GetCodeEntities
        GetCodeEntityRequest getCodeEntityRequest = gratexObjFact.createGetCodeEntityRequest();
        getCodeEntityRequest.setVersionId(25416);
        GetCodeEntityResponse getCodeEntityResponse = iAstRcsWcfSvc.getCodeEntity(getCodeEntityRequest);
        pairs = new LinkedHashMap();
        pairs.put("<br>ENTITAtype",getCodeEntityResponse.getVersion().getValue().getEntityType().value());
        pairs.put("ENTITA",getCodeEntityResponse.getVersion().getValue().getDeclaration().getValue().getName().getValue());
        list.add(pairs);

        // GetCodeEntities
        GetCodeEntityContentRequest getCodeEntityContentRequest = gratexObjFact.createGetCodeEntityContentRequest();
        getCodeEntityContentRequest.setVersionId(25416);
        GetCodeEntityContentResponse getCodeEntityContentResponse = iAstRcsWcfSvc.getCodeEntityContent(getCodeEntityContentRequest);
        pairs = new LinkedHashMap();
        pairs.put("<br>ENTITAtypeCONTENT",getCodeEntityContentResponse.getContent().getValue());
        pairs.put("ENTITA_CONTENT",getCodeEntityContentResponse.getContent().getName().toString());
        list.add(pairs);



        JSONObject obj = new JSONObject();
        obj.put("name", "name");
        obj.put("children", list);

        System.out.println(obj);

        //response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        out.print(obj);
    }
}