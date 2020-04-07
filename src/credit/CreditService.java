package credit;

import database.ListDatabaseService;
import user.Client;
import user.User;

public class CreditService {

    private static final String TAG = "CreditService";

    private static final int STANDARD_INTEREST_RATE = 25;

    private static final int MARRIED_INTEREST_RATE = 15;

    private static final int RETIRED_INTEREST_RATE = 20;

    private static CreditService singleInstance = null;


    private CreditService() {

    }


    public static CreditService getInstance() {
        if(singleInstance == null) {
            singleInstance = new CreditService();
        }
        return singleInstance;
    }


    public void askForACredit(Client client, int money, int period) {
        ListDatabaseService service = ListDatabaseService.getInstance();

        Credit credit = new Credit();

        if(client.isRetired()) {
            credit.setInterestRate(RETIRED_INTEREST_RATE);
        }
        else if(client.isMarried()) {
            credit.setInterestRate(MARRIED_INTEREST_RATE);
        }
        else {
            credit.setInterestRate(STANDARD_INTEREST_RATE);
        }

        credit.setMonthlyInstallment((credit.getInterestRate() * money) / period);
        credit.setRemainingMoneyToPay(money);

        service.addCreditToUser(client, credit);

        System.out.println(TAG + ": Credit created for client with CNP: " + client.getCnp());
    }


    public void askForInterestRate(Client client) {
        if(client.isRetired()) {
            System.out.println(TAG + ": Interest rate is: " + RETIRED_INTEREST_RATE);
        }
        else if(client.isMarried()) {
            System.out.println(TAG + ": Interest rate is: " + MARRIED_INTEREST_RATE);
        }
        else {
            System.out.println(TAG + ": Interest rate is: " + STANDARD_INTEREST_RATE);
        }
    }


    public void payInstallment(Client client, int money) {

    }
}
