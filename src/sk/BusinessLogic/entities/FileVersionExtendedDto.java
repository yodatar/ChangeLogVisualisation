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

	public void setCommiter(UserDto commiter) {
		this.commiter = commiter;
	}

	public FileVersionDto getFileVersionDto() {
		return fileVersionDto;
	}

	public void setFileVersionDto(FileVersionDto fileVersionDto) {
		this.fileVersionDto = fileVersionDto;
	}


	public List<String> getPathNames() {
		return pathNames;
	}

	public void setPathNames(List<String> pathNames) {
		this.pathNames = pathNames;
	}
}
