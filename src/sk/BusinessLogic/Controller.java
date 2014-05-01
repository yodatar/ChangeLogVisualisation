package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.EventDto;
import com.gratex.perconik.astrcs.iactivitysvc.IdeCodeOperationDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.JsonConverter.TransformToJson;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UserActivities;
import sk.BusinessLogic.entities.UsersEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * User: pipo
 * Date: 23.4.2014
 * Time: 15:42
 */


public class Controller {
	DatabaseHandlers databaseHandlers = new PerConIKDatabaseHandler();
	TransformToJson transformToJson = new TransformToJson();

	public JSONObject getUsersCodeActivities(String user) {

		final int pieces = 100;
		String eventName = "IdeCodeOperation";

		XMLGregorianCalendar calendarFrom = Resources.getInstance().getChangesetFrom().getTimeStamp();
		XMLGregorianCalendar calendarTo = Resources.getInstance().getChangesetTo().getTimeStamp();

		long timeFrom = calendarFrom.toGregorianCalendar().getTime().getTime();
		long timeTo = calendarTo.toGregorianCalendar().getTime().getTime();
		final long interval = (timeTo - timeFrom) / (pieces - 1);
		Integer[] intervals = new Integer[pieces];
		Date[] dateList = new Date[pieces];
		for (int i = 0; i < pieces; i++) {
			dateList[i] = new Date(timeFrom + i * interval);
			intervals[i] = 0;
		}

		List<ActivityDto> activityDtoList = databaseHandlers.getActivities(user, calendarFrom, calendarTo, eventName);

		for (ActivityDto activityDto : activityDtoList) {
			for (EventDto eventDto : activityDto.getEvents().getOneNoteNavigateDtoOrOneNoteViewChangeDtoOrLyncStatusChangeDto()) {
				if (IdeCodeOperationDto.class.isInstance(eventDto)) {

					IdeCodeOperationDto dto = (IdeCodeOperationDto) eventDto;
					try {
						if (!dto.getCode().equals("null")) {

							if (dto.getDocument().getPathType().value().equals("SHORT_NAME") ||
									dto.getDocument().getPathType().value().equals("RELATIVE_LOCAL") ||
									dto.getDocument().getPath().contains(Resources.getInstance().getProjectDto().getName())) {
								long delay = dto.getTime().toGregorianCalendar().getTime().getTime() - timeFrom;
								try {
									intervals[(int) (delay / interval)] += dto.getCode().length();
								} catch (ArrayIndexOutOfBoundsException exception) {
									intervals[0] += 0;
								}
							}

						}
					} catch (java.lang.NullPointerException e) {
						e.getMessage();
					}
				}
			}
		}

		for (UserActivities userActivities : Resources.getInstance().getListUsersActivities()) {
			if (userActivities.getName().equals(user)) {
				userActivities.setActivities(intervals);
			}
		}

		JSONObject jsonObject = transformToJson.usersCodeActivityToJson(
				Resources.getInstance().getListUsers(), Resources.getInstance().getListUsersActivities(), dateList, pieces);

		return jsonObject;
	}

	public JSONObject getUsersPerProject() {

		List<UsersEntity> userDtoList = databaseHandlers.getUsersPerProject();
		Collections.sort(userDtoList);
		Resources.getInstance().setListUsers(userDtoList);

		List<UserActivities> userActivitiesList = new LinkedList<>();
		for (UsersEntity usersEntity : userDtoList) {
			userActivitiesList.add(new UserActivities(usersEntity.getId(), usersEntity.getName()));
		}
		Resources.getInstance().setListUsersActivities(userActivitiesList);

		JSONObject jsonObject = transformToJson.usersToJson(Resources.getInstance().getListUsers());

		return jsonObject;
	}

	public JSONObject getProjectTree() {

		List<FileVersionDto> listFileVersionDto = databaseHandlers.searchFiles();
		List<FileVersionExtendedDto> changedFilesList = databaseHandlers.getChangedFiles();

		JSONObject jsonObject = transformToJson.projectTreeToJson(listFileVersionDto, changedFilesList);

		return jsonObject;
	}


	public JSONArray getChangesetList() {
		List<ChangesetDto> changesetDtoList = databaseHandlers.searchChangesets(null, null);

		TransformToJson transformToJson = new TransformToJson();
		JSONArray jsonArray = transformToJson.changesetListToJson(changesetDtoList);

		return jsonArray;
	}

	public List<ProjectsEntity> getProjects() {
		List<ProjectsEntity> projectsEntityList = databaseHandlers.getProjects();

		return projectsEntityList;
	}

	public ChangesetDto getChangeset(Integer changesetId) {
		ChangesetDto changesetDto = databaseHandlers.getChangeset(changesetId);
		return changesetDto;
	}
}
