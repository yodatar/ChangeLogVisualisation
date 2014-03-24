package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.RcsProjectDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse;
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


public class DatabaseRequestHandlers {
    IAstRcsWcfSvc iAstRcsWcfSvc = new AstRcsDatabaseFactory().getIAstRcsWcfSvc();

    public List<String> getAllUsers(HttpSession httpSession) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        List<ChangesetDto> changesetDtoList = this.getChangesetList(Resources.getInstance().getProjectId());
        for(ChangesetDto changesetDto : changesetDtoList)
        {
            list.add(changesetDto.getCommitter().getValue().getLogin().getValue());
        }

        // simple distinct
        set.addAll(list);
        list.clear();
        list.addAll(set);

        return list;
    }

    public List<ChangesetDto> getChangesetList(Integer projectId) {
        List<ChangesetDto> changesetDtoList = new LinkedList<>();

        // Search Changesets
        SearchChangesetsRequest changesetsRequest = new SearchChangesetsRequest();
        changesetsRequest.setRcsProjectId(Resources.getInstance().getProjectId());
        changesetsRequest.setPageSize(100);
        SearchChangesetsResponse searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);
        int pageCount = searchChangesetsResponse.getPageCount();

        // iterate over all changesets to get all committers
        if(pageCount > 1) {
            for(int i=0;i <= pageCount;i++)
            {
                changesetsRequest.setPageIndex(i);
                searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);

                changesetDtoList.addAll(searchChangesetsResponse.getChangesets().getValue().getChangesetDto());
            }
        } else {
            changesetDtoList.addAll(searchChangesetsResponse.getChangesets().getValue().getChangesetDto());
        }

        return changesetDtoList;
    }

    public List<FileVersionDto> getProjectTree(HttpSession httpSession){
        List<FileVersionDto> listFileVersionDto = new LinkedList<>();

        // set last Changeset as default
        List<ChangesetDto> changesetDtoList = this.getChangesetList(Resources.getInstance().getProjectId());
        Resources.getInstance().setChangesetId(changesetDtoList.get(changesetDtoList.size()-1).getId());

        // SearchFiles
        SearchFilesRequest searchFilesRequest = new SearchFilesRequest();
        searchFilesRequest.setChangesetId(Resources.getInstance().getChangesetId());
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


    public List<ProjectsEntity> getProjects(HttpSession httpSession){
        List<RcsProjectDto> rcsProjectDtos;
        List<ProjectsEntity> projectsEntityList = new LinkedList<>();

        // Search Projects
        SearchRcsProjectsRequest projectsRequest = new SearchRcsProjectsRequest();
        projectsRequest.setPageSize(50);
        SearchRcsProjectsResponse searchRcsProjectsResponse = iAstRcsWcfSvc.searchRcsProjects(projectsRequest);
        rcsProjectDtos = searchRcsProjectsResponse.getRcsProjects().getValue().getRcsProjectDto();

        for(RcsProjectDto rcsProjectDto : rcsProjectDtos)
        {
            projectsEntityList.add(new ProjectsEntity(rcsProjectDto.getId(),rcsProjectDto.getUrl().getValue()));
        }

        return projectsEntityList;
    }
}
