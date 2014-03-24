package sk.BusinessLogic;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 10.3.2014
 * Time: 21:15
 */


public class Resources {
    private static Resources _instance;
    private Integer projectId;
    private Integer changesetId;

    private Resources() {}

    public static Resources getInstance() {
        if (_instance == null) _instance = new Resources();
        return _instance;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getChangesetId() {
        return changesetId;
    }

    public void setChangesetId(Integer changesetId) {
        this.changesetId = changesetId;
    }
}
