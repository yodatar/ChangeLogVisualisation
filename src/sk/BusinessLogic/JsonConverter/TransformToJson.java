package sk.BusinessLogic.JsonConverter;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.entities.FileVersionExtendedDto;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 16:30
 */


public class TransformToJson {

	public JSONObject projectTreeToJson(List<FileVersionDto> fileVersionDtoList, List<FileVersionExtendedDto> changedFilesList) {

		Collections.sort(fileVersionDtoList, FileVersionDto.Comparators.URL);

		JSONObject jsonObject = new JSONObject();
		PathTreeCreator pathTreeCreator = new PathTreeCreator(jsonObject);

		for (FileVersionDto fileVersionDto : fileVersionDtoList) { // all files
			pathTreeCreator.addPath(fileVersionDto.getUrl().getValue());
		}

		for (FileVersionDto fileVersionDto : changedFilesList) { // changed files names
			pathTreeCreator.addChangedFilesName(fileVersionDto.getUrl().getValue());
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

}

