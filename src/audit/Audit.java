package audit;

import java.sql.Timestamp;

public class Audit {

    private String actionName;
    private Timestamp timestamp;

    public Audit(String actionName, Timestamp timestamp) {
        this.actionName = actionName;
        this.timestamp = timestamp;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
