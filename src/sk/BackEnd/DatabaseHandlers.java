package sk.BackEnd;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ChangesetDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import sk.BusinessLogic.entities.FileVersionExtendedDto;
import sk.BusinessLogic.entities.ProjectsEntity;
import sk.BusinessLogic.entities.UsersEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

/**
 * Date: 1.4.2014
 */

/**
 * Rozhranie DatabaseHandlers poskytuje definiciu potrebnych
 * metod vyzadovanych vizualizaciou.
 *
 * @author Pavol Michalek
 * @see PerConIKDatabaseHandler
 */
public interface DatabaseHandlers {
	List<UsersEntity> getUsersPerProject(Integer projectId);

	List<ChangesetDto> searchChangesets(Integer from, Integer to, Integer projectId);

	ChangesetDto getChangeset(Integer changesetId);

	List<ProjectsEntity> getProjects();

	List<ActivityDto> getActivities(String user, XMLGregorianCalendar from, XMLGregorianCalendar to, String string);

	List<FileVersionExtendedDto> getChangedFiles(Integer changesetIdFrom, Integer changesetIdTo, Integer projectId);

	List<FileVersionDto> searchFiles(Integer changesetIdTo);
}
