package transaction;

import credit.Credit;
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

        Credit credit = service.queryCredit(user);
        if(credit != null) {
            if(user.getCard().getBalance() < money) {
                System.out.println(TAG + ": Insufficient founds");
            }
            else {
                user.getCard().setBalance(user.getCard().getBalance() - money);
                System.out.println(TAG + ": Money left on card: " + user.getCard().getBalance());

                credit.setRemainingMoneyToPay(credit.getRemainingMoneyToPay() - money);
                System.out.println(TAG + ": Remaining money to pay: " + credit.getRemainingMoneyToPay());

                service.addCreditToUser(user, credit);
            }
        }
    }
}
