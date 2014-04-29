package sk.BusinessLogic;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UserActivities;
import sk.BusinessLogic.entities.UsersEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 10.3.2014
 * Time: 21:15
 */


public class Resources {
	private static Resources _instance;

	private Integer projectId;
	private Integer changesetFromId;
	private Integer changesetToId;

	private ProjectsEntity projectDto;
	private ChangesetDto changesetFrom;
	private ChangesetDto changesetTo;

	private List<UserActivities> listUsersActivities = new LinkedList<UserActivities>();
	private List listUsers = new LinkedList<UsersEntity>();

	public ProjectsEntity getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectsEntity projectDto) {
		this.projectDto = projectDto;
	}

	public ChangesetDto getChangesetFrom() {
		return changesetFrom;
	}

	public void setChangesetFrom(ChangesetDto changesetFrom) {
		this.changesetFrom = changesetFrom;
	}

	public ChangesetDto getChangesetTo() {
		return changesetTo;
	}

	public void setChangesetTo(ChangesetDto changesetTo) {
		this.changesetTo = changesetTo;
	}


	private Resources() {
	}

	public static Resources getInstance() {
		if (_instance == null) _instance = new Resources();
		return _instance;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getChangesetFromId() {
		return changesetFromId;
	}

	public void setChangesetFromId(Integer changesetFromId) {
		this.changesetFromId = changesetFromId;
	}

	public Integer getChangesetToId() {
		return changesetToId;
	}

	public void setChangesetToId(Integer changesetToId) {
		this.changesetToId = changesetToId;
	}

	public List<UserActivities> getListUsersActivities() {
		return listUsersActivities;
	}

	public void setListUsersActivities(List listUsersActivities) {
		this.listUsersActivities = listUsersActivities;
	}

	public List getListUsers() {
		return listUsers;
	}

	public void setListUsers(List listUsers) {
		this.listUsers = listUsers;
	}
}
