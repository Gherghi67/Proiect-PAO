package database;

import credit.Credit;
import user.User;

import java.util.List;
import java.util.Map;

public class DatabaseService {

    private static final String TAG = "DatabaseService";

    private static DatabaseService singleInstance = null;

    private List<User> users;

    private Map<User, Credit> userCreditMap;

    private DatabaseService() {

    }

    public static DatabaseService getInstance() {
        if(singleInstance == null) {
            singleInstance = new DatabaseService();
        }
        return singleInstance;
    }
}
