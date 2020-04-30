package audit;

import database.ReadWriteService;

import java.sql.Timestamp;

public class AuditService {

    private static final String TAG = "AuditService";

    private static AuditService singleInstance = null;

    private ReadWriteService service;

    private AuditService() {
        service = ReadWriteService.getInstance();
    }


    public static AuditService getInstance() {
        if(singleInstance == null) {
            singleInstance = new AuditService();
        }
        return singleInstance;
    }


    public void writeAction(String actionName, Timestamp timestamp) throws Exception {
        Audit audit = new Audit(actionName, timestamp);

        service.write(audit, "data/audit.csv");
    }
}
