package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse;
import sk.AstRcs.AstRcsDatabaseFactory;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 19:33
 */


public class BusinessLogic {
    IAstRcsWcfSvc iAstRcsWcfSvc;

    public List<String> getAllUsers(HttpSession httpSession) {
        iAstRcsWcfSvc = new AstRcsDatabaseFactory().getIAstRcsWcfSvc();
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        // Search Changesets
        SearchChangesetsRequest changesetsRequest = new SearchChangesetsRequest();
        changesetsRequest.setRcsProjectId(2);
        changesetsRequest.setPageSize(100);
        SearchChangesetsResponse searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);
        int pageCount = searchChangesetsResponse.getPageCount();

        // iterate over all changesets to get all committers
        for(int i=0;i <= pageCount;i++)
        {
            changesetsRequest.setPageIndex(i);
            searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);

            for(ChangesetDto changesetDto : searchChangesetsResponse.getChangesets().getValue().getChangesetDto())
            {
                list.add(changesetDto.getCommitter().getValue().getLogin().getValue());
            }
        }

        // simple distinct
        set.addAll(list);
        list.clear();
        list.addAll(set);

        return list;
    }

    public List<FileVersionDto> getProjectTree(HttpSession httpSession){
        iAstRcsWcfSvc = new AstRcsDatabaseFactory().getIAstRcsWcfSvc();
        List<FileVersionDto> listFileVersionDto = new LinkedList<>();




        // SearchFiles
        SearchFilesRequest searchFilesRequest = new SearchFilesRequest();
        searchFilesRequest.setChangesetId(2203);
        searchFilesRequest.setPageSize(100);
        SearchFilesResponse searchFilesResponse = iAstRcsWcfSvc.searchFiles(searchFilesRequest);
        int pageCount = searchFilesResponse.getPageCount();

        if(pageCount > 1) {
            for(int i=0;i<pageCount;i++) {
                searchFilesRequest.setPageIndex(i);
                searchFilesResponse = iAstRcsWcfSvc.searchFiles(searchFilesRequest);

                listFileVersionDto.addAll(searchFilesResponse.getFileVersions().getValue().getFileVersionDto());
            }
        } else {
            listFileVersionDto = searchFilesResponse.getFileVersions().getValue().getFileVersionDto();
        }

        return listFileVersionDto;
    }
}
