package sk.BusinessLogic;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UsersEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

/**
 * User: pipo
 * Date: 1.5.2014
 * Time: 21:38
 */


public interface DatabaseHandlers {
	List<UsersEntity> getUsersPerProject();

	List<ChangesetDto> searchChangesets(Integer from, Integer to);

	ChangesetDto getChangeset(Integer changesetId);

	List<FileVersionExtendedDto> getChangedFiles();

	List<FileVersionDto> searchFiles();

	List<ProjectsEntity> getProjects();

	List<ActivityDto> getActivities(String user, XMLGregorianCalendar calendar1, XMLGregorianCalendar calendar2, String string);
}
