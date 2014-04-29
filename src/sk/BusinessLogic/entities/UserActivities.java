package sk.BusinessLogic.entities;

/**
 * User: pipo
 * Date: 28.4.2014
 * Time: 21:53
 */


public class UserActivities {
	private Integer id;
	private String name;
	private Integer[] activities;

	public UserActivities(Integer id, String name) {
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

	public Integer[] getActivities() {
		return activities;
	}

	public void setActivities(Integer[] activities) {
		this.activities = activities;
	}
}
