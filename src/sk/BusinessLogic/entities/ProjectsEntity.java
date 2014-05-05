package sk.BusinessLogic.entities;

/**
 * Date: 10.3.2014
 */

/**
 * Trieda ProjectsEntity extrahuje jedine potrebne atributy
 * "id" a "name" z triedy RcsProjectDto, pre potreby zoradovania.
 * @see org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.RcsProjectDto
 */
public class ProjectsEntity {

	private Integer id;
	private String name;

	public ProjectsEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
