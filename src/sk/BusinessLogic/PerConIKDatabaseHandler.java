package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.ActivityFilter;
import com.gratex.perconik.astrcs.iactivitysvc.ArrayOfString;
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
import sk.BackEnd.DatabaseFactory;
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


public class PerConIKDatabaseHandler implements DatabaseHandlers {
	IAstRcsWcfSvc iAstRcsWcfSvc = DatabaseFactory.getInstance().getIAstRcsWcfSvc();
	IActivitySvc iActivitySvc = DatabaseFactory.getInstance().getIActivitySvc();

	@Override
	public List<UsersEntity> getUsersPerProject() {
		List<UsersEntity> list = new ArrayList<>();
		Set<UsersEntity> set = new HashSet<>();

		List<ChangesetDto> changesetDtoList = this.searchChangesets(null, null);
		for (ChangesetDto changesetDto : changesetDtoList) {
			UsersEntity usersEntity = new UsersEntity(changesetDto.getCommitter().getValue().getId(), changesetDto.getCommitter().getValue().getLogin().getValue());
			set.add(usersEntity);
		}

		//distinct
		list.addAll(set);

		return list;

	}

	@Override
	public List<ChangesetDto> searchChangesets(Integer from, Integer to) {
		List<ChangesetDto> changesetDtoList = new LinkedList<>();

		// Search Changesets
		SearchChangesetsRequest changesetsRequest = new SearchChangesetsRequest();
		changesetsRequest.setRcsProjectId(Resources.getInstance().getProjectId());
		changesetsRequest.setPageSize(100);
		SearchChangesetsResponse searchChangesetsResponse = iAstRcsWcfSvc.searchChangesets(changesetsRequest);
		int pageCount = searchChangesetsResponse.getPageCount();

		// iterate over all paged changesets
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

	@Override
	public ChangesetDto getChangeset(Integer changesetId) {
		GetChangesetRequest changesetRequest = new GetChangesetRequest();
		changesetRequest.setChangesetId(changesetId);
		GetChangesetResponse changesetResponse = iAstRcsWcfSvc.getChangeset(changesetRequest);

		return changesetResponse.getChangeset().getValue();
	}

	@Override
	public List<FileVersionExtendedDto> getChangedFiles() {
		List<FileVersionExtendedDto> fileVersionExtendedList = new LinkedList<>();
		Set<FileVersionExtendedDto> fileVersionExtendedSet = new HashSet<>();

		List<ChangesetDto> changesetDtoList = this.searchChangesets(
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

	@Override
	public List<FileVersionDto> searchFiles() {
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

		return listFileVersionDto;
	}


	@Override
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

	@Override
	public List<ActivityDto> getActivities(String user, XMLGregorianCalendar calendar1, XMLGregorianCalendar calendar2, String string) {
		List<ActivityDto> activityDtoList;
		ArrayOfString arrayOfString = new ArrayOfString();
		arrayOfString.getString().add(string);

		ActivityFilter activityFilter = new ActivityFilter();

		activityFilter.setStartTimeFrom(calendar1);
		activityFilter.setEndTimeTo(calendar2);
		activityFilter.setUser(user);
		activityFilter.setPageSize(500);
		activityFilter.setEventShortTypeNames(arrayOfString);

		long start = System.currentTimeMillis();
		GetActivitiesResponse getActivitiesResponse = new GetActivitiesResponse();
		getActivitiesResponse.setGetActivitiesResult(iActivitySvc.getActivities(activityFilter));
		activityDtoList = getActivitiesResponse.getGetActivitiesResult().getActivityDto();
		long end = System.currentTimeMillis();
		System.out.println("========= " + user + " - getActivities took : " + ((end - start) / 1000) + " sec.");

		Resources.getInstance().totalTime += ((end - start));

		return activityDtoList;
	}
}
