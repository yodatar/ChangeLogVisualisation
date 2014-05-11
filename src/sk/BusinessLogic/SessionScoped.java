package sk.BusinessLogic;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UserActivitiesEntity;
import sk.BusinessLogic.entities.UsersEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pipo
 * Date: 11.5.2014
 * Time: 0:52
 */


public @interface SessionScoped {

	Integer projectId = 3;
	Integer changesetFromId = 298;
	Integer changesetToId = 307;
	long totalTime = 0;

	ProjectsEntity projectDto = null;
	ChangesetDto changesetFrom = null;
	ChangesetDto changesetTo = null;

	List<UserActivitiesEntity> listUsersActivities = new LinkedList<UserActivitiesEntity>();
	List listUsers = new LinkedList<UsersEntity>();

}
