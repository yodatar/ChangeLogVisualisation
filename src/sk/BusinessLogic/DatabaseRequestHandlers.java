package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.ActivityFilter;
import com.gratex.perconik.astrcs.iactivitysvc.GetActivitiesResponse;
import com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.RcsProjectDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse;
import org.json.simple.JSONObject;
import sk.BackEnd.DatabaseFactory;
import sk.BusinessLogic.JsonConverter.TransformToJson;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UsersEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 19:33
 */


public class DatabaseRequestHandlers {
	IAstRcsWcfSvc iAstRcsWcfSvc = new DatabaseFactory().getIAstRcsWcfSvc();
	IActivitySvc iActivitySvc = new DatabaseFactory().getIActivitySvc();

	public List<UsersEntity> getAllUsers() {
		ArrayList<UsersEntity> list = new ArrayList<>();
		HashSet<UsersEntity> set = new HashSet<>();

		List<ChangesetDto> changesetDtoList = this.getChangesetList(null, null);
		for (ChangesetDto changesetDto : changesetDtoList) {
			UsersEntity usersEntity = new UsersEntity(changesetDto.getCommitter().getValue().getId(), changesetDto.getCommitter().getValue().getLogin().getValue());
			set.add(usersEntity);
		}

		// simple distinct
		//set.addAll(list);
		//list.clear();
		list.addAll(set);

		return list;
	}

	public List<ChangesetDto> getChangesetList(Integer from, Integer to) {
		List<ChangesetDto> changesetDtoList = new LinkedList<>();

		// Search Changesets
		SearchChangesetsRequest changesetsRequest = new SearchChangesetsRequest();
		changesetsRequest.setRcsProjectId(Resources.getInstance().getProjectId());
		changesetsRequest.setPageSize(100);
		SearchChangesetsResponse searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);
		int pageCount = searchChangesetsResponse.getPageCount();

		// iterate over all changesets to get all committers
		if (pageCount > 1) {
			for (int i = 0; i <= pageCount; i++) {
				changesetsRequest.setPageIndex(i);
				searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);

				changesetDtoList.addAll(searchChangesetsResponse.getChangesets().getValue().getChangesetDto());
			}
		} else {
			changesetDtoList.addAll(searchChangesetsResponse.getChangesets().getValue().getChangesetDto());
		}

		List<ChangesetDto> changesetDtoListResult = new LinkedList<>();
		changesetDtoListResult.addAll(changesetDtoList);

		if (to != null || from != null) {
			for (ChangesetDto changesetDto : changesetDtoList) {

				if (to != null)
					if (changesetDto.getId() > to)
						changesetDtoListResult.remove(changesetDto);
				if (from != null) {
					if (changesetDto.getId() < from)
						changesetDtoListResult.remove(changesetDto);
				}

			}
		}

		return changesetDtoListResult;
	}

	public ChangesetDto getChangeset() {
		GetChangesetRequest changesetRequest = new GetChangesetRequest();
		changesetRequest.setChangesetId(Resources.getInstance().getChangesetToId());
		GetChangesetResponse changesetResponse = iAstRcsWcfSvc.getChangeset(changesetRequest);

		return changesetResponse.getChangeset().getValue();
	}

	public List<FileVersionExtendedDto> getChangedFiles() {
		List<FileVersionExtendedDto> fileVersionExtendedList = new LinkedList<>();
		Set<FileVersionExtendedDto> fileVersionExtendedSet = new HashSet<>();

		List<ChangesetDto> changesetDtoList = this.getChangesetList(
				Resources.getInstance().getChangesetFromId(), Resources.getInstance().getChangesetToId());

		for (ChangesetDto changesetDto : changesetDtoList) {
			GetChangedFilesRequest changedFilesRequest = new GetChangedFilesRequest();
			changedFilesRequest.setChangesetId(changesetDto.getId());
			changedFilesRequest.isIncludeDeletedFiles();

			GetChangedFilesResponse changedFilesResponse = iAstRcsWcfSvc.getChangedFiles(changedFilesRequest);

			for (FileVersionDto fileVersionDto : changedFilesResponse.getFileVersions().getValue().getFileVersionDto()) {
				fileVersionExtendedSet.add(new FileVersionExtendedDto(changesetDto.getCommitter().getValue(), fileVersionDto));
			}
		}

		fileVersionExtendedList.addAll(fileVersionExtendedSet);

		return fileVersionExtendedList;
	}

	public JSONObject getProjectTree() {
		List<FileVersionDto> listFileVersionDto = new LinkedList<>();

		// SearchFiles
		SearchFilesRequest searchFilesRequest = new SearchFilesRequest();
		searchFilesRequest.setChangesetId(Resources.getInstance().getChangesetToId());
		searchFilesRequest.setPageSize(100);

		SearchFilesResponse searchFilesResponse = iAstRcsWcfSvc.searchFiles(searchFilesRequest);
		int pageCount = searchFilesResponse.getPageCount();

		if (pageCount > 1) {
			for (int i = 0; i < pageCount; i++) {
				searchFilesRequest.setPageIndex(i);
				searchFilesResponse = iAstRcsWcfSvc.searchFiles(searchFilesRequest);

				listFileVersionDto.addAll(searchFilesResponse.getFileVersions().getValue().getFileVersionDto());

			}
		} else {
			listFileVersionDto = searchFilesResponse.getFileVersions().getValue().getFileVersionDto();
		}

		List<FileVersionExtendedDto> changedFilesList = this.getChangedFiles();

		TransformToJson transformToJson = new TransformToJson();
		JSONObject jsonObject = transformToJson.projectTreeToJson(listFileVersionDto, changedFilesList);

		return jsonObject;
	}


	public List<ProjectsEntity> getProjects() {
		List<RcsProjectDto> rcsProjectDtos;
		List<ProjectsEntity> projectsEntityList = new LinkedList<>();

		// Search Projects
		SearchRcsProjectsRequest projectsRequest = new SearchRcsProjectsRequest();
		projectsRequest.setPageSize(100);
		SearchRcsProjectsResponse searchRcsProjectsResponse = iAstRcsWcfSvc.searchRcsProjects(projectsRequest);
		rcsProjectDtos = searchRcsProjectsResponse.getRcsProjects().getValue().getRcsProjectDto();

		for (RcsProjectDto rcsProjectDto : rcsProjectDtos) {
			projectsEntityList.add(new ProjectsEntity(rcsProjectDto.getId(), rcsProjectDto.getUrl().getValue()));
		}

		return projectsEntityList;
	}


	public List<ActivityDto> getActivity() {
		List<ActivityDto> activityDtoList;
		ActivityFilter activityFilter = new ActivityFilter();
		XMLGregorianCalendar xmlGregorianCalendar;

		List<ChangesetDto> changesetDtoList = this.getChangesetList(null, null);
		ChangesetDto changesetDto1 = changesetDtoList.get(changesetDtoList.size() - 2);
		ChangesetDto changesetDto2 = changesetDtoList.get(changesetDtoList.size() - 1);

		xmlGregorianCalendar = changesetDto1.getTimeStamp();

		xmlGregorianCalendar.setDay(24);
		System.out.println(xmlGregorianCalendar);
		//System.out.println(changesetDto1.getTimeStamp());

		activityFilter.setStartTimeFrom(xmlGregorianCalendar);
		//xmlGregorianCalendar.setDay(24);
		//System.out.println(xmlGregorianCalendar);
		System.out.println(changesetDto2.getTimeStamp());
		activityFilter.setStartTimeTo(changesetDto2.getTimeStamp());

		activityFilter.setUser("STELTECIA\\mkonopka");
		//GetActivities getActivities = new GetActivities();
		//getActivities.setFilter(activityFilter);
		GetActivitiesResponse getActivitiesResponse = new GetActivitiesResponse();
		getActivitiesResponse.setGetActivitiesResult(iActivitySvc.getActivities(activityFilter));
		activityDtoList = getActivitiesResponse.getGetActivitiesResult().getActivityDto();

		return activityDtoList;
	}

}
