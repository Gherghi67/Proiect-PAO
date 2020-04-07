package transaction;

import database.ListDatabaseService;
import user.User;

public class TransactionService {

    private static final String TAG = "TransactionService";

    private static TransactionService singleInstance;


    private TransactionService() {

    }


    public static TransactionService getInstance() {
        if(singleInstance == null) {
            singleInstance = new TransactionService();
        }
        return singleInstance;
    }


    public void makeTransaction(User user, int money) {
        ListDatabaseService service = ListDatabaseService.getInstance();

        if()
    }
}
