package sk.BusinessLogic.JsonConverter;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.UsersEntity;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

		for (FileVersionExtendedDto fileVersionDto : changedFilesList) { // changed files names
			pathTreeCreator.addChangedFilesName(fileVersionDto.getFileVersionDto().getUrl().getValue());
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

	public JSONObject UsersToJson(List<UsersEntity> userDtoList) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArrayCommiters = new JSONArray();

		for(UsersEntity usersEntity : userDtoList) {
			JSONObject commiterObject = new JSONObject();
			commiterObject.put("id",usersEntity.getId());
			commiterObject.put("name",usersEntity.getName());
			jsonArrayCommiters.add(commiterObject);
		}
		jsonObject.put("commiters",jsonArrayCommiters);

		JSONArray jsonArrayIntervals = new JSONArray();
		for(int i=0;i<10;i++) {
			Random random = new Random();
			JSONObject intervalObject = new JSONObject();
			intervalObject.put("Date",i+1);

			for(UsersEntity usersEntity : userDtoList) {
				intervalObject.put(usersEntity.getId(),random.nextInt(11));
			}
			jsonArrayIntervals.add(intervalObject);
		}
		jsonObject.put("intervals",jsonArrayIntervals);

		return jsonObject;
	}
}
