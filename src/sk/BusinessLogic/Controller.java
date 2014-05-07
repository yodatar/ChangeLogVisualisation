package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.EventDto;
import com.gratex.perconik.astrcs.iactivitysvc.IdeCodeOperationDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BackEnd.DatabaseHandlers;
import sk.BackEnd.PerConIKDatabaseHandler;
import sk.BusinessLogic.JsonConverter.TransformToJson;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UserActivitiesEntity;
import sk.BusinessLogic.entities.UsersEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 23.4.2014
 */

/**
 * Trieda s primarnou logikou aplikacie.
 * Tvori spojenie medzi prezentacnou vrstvou Servletov,
 * a databazovou vrstvou - rozhranie DatabaseHandlers.
 * Ziskane data z webovej sluzby posiela na transformaciu
 * do JSONObject a vrati ich spat prislusnemu Servletu na odpoved.
 *
 * @see sk.BackEnd.DatabaseHandlers
 * @see TransformToJson
 */
public class Controller {
	DatabaseHandlers databaseHandlers = new PerConIKDatabaseHandler();
	TransformToJson transformToJson = new TransformToJson();

	/**
	 * Metoda dotahuje aktivity konkretneho pouzivatela
	 * z webovej sluzby UserActivity, kompletizuje ich,
	 * a zatrieduje do "pieces = 100" intervalov.
	 * Dodatocne informacie o aktualnom zobrazeni vizualizacie
	 * (casovy rozsah, zoznam vyvojarov, meno projektu) dotahuje
	 * z triedy Resources.
	 *
	 * @param user meno (login) vyvojara
	 * @return JSONObject zlozeny zo vsetkych aktivit vyvojarov
	 * @see Resources
	 * @see com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc
	 */
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

		for (UserActivitiesEntity userActivitiesEntity : Resources.getInstance().getListUsersActivities()) {
			if (userActivitiesEntity.getName().equals(user)) {
				userActivitiesEntity.setActivities(intervals);
			}
		}

		JSONObject jsonObject = transformToJson.usersCodeActivityToJson(
				Resources.getInstance().getListUsers(), Resources.getInstance().getListUsersActivities(), dateList, pieces);

		return jsonObject;
	}

	/**
	 * Metoda dotahuje z databazy AstRcs mena vyvojarov
	 * s parametrom aktualneho projektu.
	 *
	 * @return JSONObject zoznamu vyvojarov pre aktualny projektov
	 * @see Resources
	 */
	public JSONObject getUsersPerProject() {
		List<UsersEntity> userDtoList = databaseHandlers.getUsersPerProject(Resources.getInstance().getProjectId());
		Collections.sort(userDtoList);
		Resources.getInstance().setListUsers(userDtoList);

		List<UserActivitiesEntity> userActivitiesEntityList = new LinkedList<>();
		for (UsersEntity usersEntity : userDtoList) {
			userActivitiesEntityList.add(new UserActivitiesEntity(usersEntity.getId(), usersEntity.getName()));
		}
		Resources.getInstance().setListUsersActivities(userActivitiesEntityList);

		JSONObject jsonObject = transformToJson.usersToJson(Resources.getInstance().getListUsers());

		return jsonObject;
	}

	/**
	 * Metoda dotahuje z databazovej vrstvy potrebne informacie
	 * o vsetkych suboroch pre aktualnu verziu projektu,
	 * a o zmenach suborov v danom rozsahu.
	 *
	 * @return JSONObject rekurzivne vystavaneho stromu projektu
	 * @see TransformToJson
	 * @see DatabaseHandlers
	 */
	public JSONObject getProjectTree() {
		List<FileVersionDto> listFileVersionDto = databaseHandlers.searchFiles(Resources.getInstance().getChangesetToId());
		List<FileVersionExtendedDto> changedFilesList = databaseHandlers
				.getChangedFiles(Resources.getInstance().getChangesetFromId(), Resources.getInstance().getChangesetToId(),
						Resources.getInstance().getProjectId());

		JSONObject jsonObject = transformToJson.projectTreeToJson(listFileVersionDto, changedFilesList);

		return jsonObject;
	}

	/**
	 * Metoda si z databazovej vrstvy vyziada pre aktualne nastaveny projekt
	 * list vsetkych ChangesetDto. Ten sa ponuka v pouzivatelskom rozhrani ako
	 * rozsah sledovania projektu.
	 *
	 * @return JSONArray vsetkych changesetov pre projekt
	 */
	public JSONArray getChangesetList() {
		List<ChangesetDto> changesetDtoList = databaseHandlers
				.searchChangesets(null, null, Resources.getInstance().getProjectId());

		TransformToJson transformToJson = new TransformToJson();
		JSONArray jsonArray = transformToJson.changesetListToJson(changesetDtoList);

		return jsonArray;
	}

	/**
	 * Metoda dotahuje z databazy AstRcs list vsetkych zaznamenanych projektov.
	 *
	 * @return List<ProjectsEntity>
	 */
	public List<ProjectsEntity> getProjects() {
		List<ProjectsEntity> projectsEntityList = databaseHandlers.getProjects();

		return projectsEntityList;
	}

	/**
	 * Metoda pre potreby informacie o konkretnom changesete.
	 *
	 * @param changesetId konkretne id changesetu
	 * @return ChangesetDto
	 * @see sk.Servlets.IndexServlet
	 */
	public ChangesetDto getChangeset(Integer changesetId) {
		ChangesetDto changesetDto = databaseHandlers.getChangeset(changesetId);
		return changesetDto;
	}
}
