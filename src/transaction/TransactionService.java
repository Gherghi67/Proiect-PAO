package transaction;

import card.Card;
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


    public void makeTransaction(User user, int money) throws Exception {
        ListDatabaseService service = ListDatabaseService.getInstance();

        Credit credit = service.queryCredit(user);
        Card card = service.queryCard(user);
        if(credit != null) {
            if(card.getBalance() < money) {
                System.out.println(TAG + ": Insufficient founds");
            }
            else {
                service.modifyCardBalance(user, money);
                System.out.println(TAG + ": Money left on card: " + (card.getBalance() - money));

                credit.setRemainingMoneyToPay(credit.getRemainingMoneyToPay() - money);
                System.out.println(TAG + ": Remaining money to pay: " + credit.getRemainingMoneyToPay());

                service.addCreditToUser(user, credit);
            }
        }
    }
}
