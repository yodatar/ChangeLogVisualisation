package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.ArrayOfString;
import com.gratex.perconik.astrcs.iactivitysvc.EventDto;
import com.gratex.perconik.astrcs.iactivitysvc.IdeCodeOperationDto;
import org.json.simple.JSONObject;
import sk.BusinessLogic.JsonConverter.TransformToJson;
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
	DatabaseHandlers databaseHandlers = new DatabaseHandlers();

	public JSONObject getUsersCodeActivities(String user) {
		final int pieces = 100;
		ArrayOfString arrayOfString = new ArrayOfString();
		arrayOfString.getString().add("IdeCodeOperation");

		XMLGregorianCalendar calendarFrom = Resources.getInstance().getChangesetFrom().getTimeStamp();
		XMLGregorianCalendar calendarTo = Resources.getInstance().getChangesetTo().getTimeStamp();

		//List<UsersEntity> userDtoList = databaseHandlers.getUsersPerProject();
		long timeFrom = calendarFrom.toGregorianCalendar().getTime().getTime();
		long timeTo = calendarTo.toGregorianCalendar().getTime().getTime();
		final long interval = (timeTo - timeFrom) / (pieces - 1);
		Integer[] intervals = new Integer[pieces];
		Date[] dateList = new Date[pieces];
		for (int i = 0; i < pieces; i++) {
			dateList[i] = new Date(timeFrom + i * interval);
			intervals[i] = 0;
		}

		List<ActivityDto> activityDtoList = databaseHandlers.getActivities(user, calendarFrom, calendarTo, arrayOfString);

		for (ActivityDto activityDto : activityDtoList) {
			for (EventDto eventDto : activityDto.getEvents().getOneNoteNavigateDtoOrOneNoteViewChangeDtoOrLyncStatusChangeDto()) {
				if (IdeCodeOperationDto.class.isInstance(eventDto)) {

					IdeCodeOperationDto dto = (IdeCodeOperationDto) eventDto;
					try {
						if (!dto.getCode().equals("null")) {
							if (dto.getDocument().getPath().contains(Resources.getInstance().getProjectDto().getName())) {
								long delay = dto.getTime().toGregorianCalendar().getTime().getTime() - timeFrom;
								intervals[(int) (delay / interval)] += dto.getCode().length();
							}

						}
					} catch (java.lang.NullPointerException e) {
						e.getMessage();
					}
				}
			}
		}

		Resources.getInstance().getListUsersActivities().add(intervals);

		TransformToJson transformToJson = new TransformToJson();
		JSONObject jsonObject = transformToJson.usersCodeActivityToJson(
				Resources.getInstance().getListUsers(), Resources.getInstance().getListUsersActivities(), dateList, pieces);

		return jsonObject;
	}

	public JSONObject getUsersPerProject() {

		List<UsersEntity> userDtoList = databaseHandlers.getUsersPerProject();
		Collections.sort(userDtoList);
		Resources.getInstance().setListUsers(userDtoList);
		Resources.getInstance().setListUsersActivities(new LinkedList<Integer[]>());

		TransformToJson transformToJson = new TransformToJson();
		JSONObject jsonObject = transformToJson.usersToJson(Resources.getInstance().getListUsers());

		return jsonObject;
	}
}
