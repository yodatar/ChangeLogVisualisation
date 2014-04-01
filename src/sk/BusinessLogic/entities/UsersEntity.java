package sk.BusinessLogic.entities;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 10.3.2014
 * Time: 19:54
 */


public class UsersEntity {

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
}
