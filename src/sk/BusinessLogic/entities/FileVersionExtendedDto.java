package sk.BusinessLogic.entities;

import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.FileVersionDto;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.UserDto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 31.3.2014
 * Time: 22:05
 */

/**
 * FileVersionExtendedDto zabaluje triedu FileVersionDto,
 * aby sucasne poskytla triedu UserDto zodpovedneho vyvojara.
 * Obsahuje aj rozbitu cestu k suboru v strome projektu do List<String>.
 * @see FileVersionDto
 * @see UserDto
 */
public class FileVersionExtendedDto {
	private UserDto commiter;
	private FileVersionDto fileVersionDto;
	private List<String> pathNames;

	public FileVersionExtendedDto(UserDto commiter, FileVersionDto fileVersionDto) {
		this.commiter = commiter;
		this.fileVersionDto = fileVersionDto;
	}

	public UserDto getCommiter() {
		return commiter;
	}

	public FileVersionDto getFileVersionDto() {
		return fileVersionDto;
	}

	public void setPathNames(List<String> pathNames) {
		this.pathNames = pathNames;
	}
}
