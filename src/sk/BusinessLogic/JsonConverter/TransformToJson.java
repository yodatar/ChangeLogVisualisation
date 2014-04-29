package sk.BusinessLogic.JsonConverter;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.UserActivities;
import sk.BusinessLogic.entities.UsersEntity;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 16:30
 */


public class TransformToJson {

	public JSONObject projectTreeToJson(List<FileVersionDto> fileVersionDtoList, List<FileVersionExtendedDto> changedFilesList) {

		Collections.sort(fileVersionDtoList, FileVersionDto.Comparators.URL);

		PathTreeCreator pathTreeCreator = new PathTreeCreator();

		for (FileVersionDto fileVersionDto : fileVersionDtoList) { // all files
			pathTreeCreator.addPath(fileVersionDto.getUrl().getValue());
		}

		pathTreeCreator.addChangedFiles(changedFilesList); // changed files

		pathTreeCreator.buildJsonTree();

		return pathTreeCreator.getJsonObject();
	}

	public JSONArray changesetListToJson(List<ChangesetDto> changesetDtoList) {
		JSONArray jsonArray = new JSONArray();

		for (ChangesetDto changesetDto : changesetDtoList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", changesetDto.getId());
			jsonObject.put("date", new SimpleDateFormat("dd.MM.yyyy HH:mm").format(changesetDto.getTimeStamp().toGregorianCalendar().getTime()));
			jsonArray.add(jsonObject);
		}

		return jsonArray;
	}

	public JSONObject usersCodeActivityToJson(List<UsersEntity> listUsers, List<UserActivities> listUsersActivities, Date[] dateList, int pieces) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArrayCommiters = new JSONArray();

		Collections.sort(listUsers);

		for (UsersEntity usersEntity : listUsers) {
			JSONObject commiterObject = new JSONObject();
			commiterObject.put("id", usersEntity.getId());
			commiterObject.put("name", usersEntity.getName());
			jsonArrayCommiters.add(commiterObject);
		}
		jsonObject.put("commiters", jsonArrayCommiters);

		JSONArray jsonArrayIntervals = new JSONArray();
		for (int i = 0; i < pieces; i++) {
			Map intervalObject = new TreeMap();
			String date = new SimpleDateFormat("MMMMM d, yyyy HH:mm:ss", Locale.US).format(dateList[i]);
			intervalObject.put(0, Character.toUpperCase(date.charAt(0)) + date.substring(1));

			for (UserActivities userActivities : listUsersActivities) {
				if (userActivities.getActivities() != null) {
					intervalObject.put(userActivities.getId(), userActivities.getActivities()[i]);
				} else {
					intervalObject.put(userActivities.getId(), 0);
				}
			}
			//System.out.println(intervalObject);
			jsonArrayIntervals.add(intervalObject);
		}
		jsonObject.put("intervals", jsonArrayIntervals);

		return jsonObject;
	}


	public JSONObject usersToJson(List<UsersEntity> userDtoList) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArrayCommiters = new JSONArray();

		Collections.sort(userDtoList);

		for (UsersEntity usersEntity : userDtoList) {
			JSONObject commiterObject = new JSONObject();
			commiterObject.put("id", usersEntity.getId());
			commiterObject.put("name", usersEntity.getName());
			jsonArrayCommiters.add(commiterObject);
		}
		jsonObject.put("commiters", jsonArrayCommiters);

		JSONArray jsonArrayIntervals = new JSONArray();
		Map intervalObject = new TreeMap();
		String date = "2014";
		intervalObject.put(0, date);

		for (UsersEntity usersEntity : userDtoList) {
			intervalObject.put(usersEntity.getId(), 0);
		}

		jsonArrayIntervals.add(intervalObject);

		jsonObject.put("intervals", jsonArrayIntervals);

		return jsonObject;
	}
}
