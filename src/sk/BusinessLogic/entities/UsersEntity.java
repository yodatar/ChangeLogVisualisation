package sk.BusinessLogic.entities;

/**
 * Date: 10.3.2014
 */

/**
 * Trieda UsersEntity extrahuje jedine potrebne atributy
 * "id" a "name" z triedy UserDto, pre potreby zoradovania.
 * Implementuje metodu compareTo(UsersEntity d),
 * prekonava metody equals() a hashCode() z java.lang.Object.
 *
 * @see org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.UserDto
 */
public class UsersEntity implements Comparable<UsersEntity> {

	private Integer id;
	private String name;

	public UsersEntity(Integer id, String name) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UsersEntity)) return false;

		UsersEntity that = (UsersEntity) o;

		if (!id.equals(that.id)) return false;
		if (!name.equals(that.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}

	@Override
	public int compareTo(UsersEntity d) {
		return (this.id).compareTo(d.id);
	}

}
