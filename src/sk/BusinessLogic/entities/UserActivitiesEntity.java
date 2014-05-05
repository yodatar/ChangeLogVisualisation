package sk.BusinessLogic.entities;

/**
 * Date: 28.3.2014
 */

/**
 * Trieda sa vyuziva pri kompletizacii informacii o jednom vyvojarovi,
 * a jeho aktivitach ziskanych z webovej sluzby UserActivity.
 *
 * @see com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc
 */
public class UserActivitiesEntity {
	private Integer id;
	private String name;
	private Integer[] activities;

	public UserActivitiesEntity(Integer id, String name) {
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
