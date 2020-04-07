package credit;

import database.ListDatabaseService;
import transaction.TransactionService;
import user.Client;
import user.User;

public class CreditService {

    private static final String TAG = "CreditService";

    private static final int STANDARD_INTEREST_RATE = 25;

    private static final int MARRIED_INTEREST_RATE = 15;

    private static final int RETIRED_INTEREST_RATE = 20;

    private static CreditService singleInstance = null;

    private ListDatabaseService database;

    private TransactionService transactionService;

    private CreditService() {
        database = ListDatabaseService.getInstance();

        transactionService = TransactionService.getInstance();
    }


    public static CreditService getInstance() {
        if(singleInstance == null) {
            singleInstance = new CreditService();
        }
        return singleInstance;
    }


    public void askForACredit(Client client, int money, int period) {


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

        database.addCreditToUser(client, credit);

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
        transactionService.makeTransaction(client, money);
    }


    public void askDetailsAboutYourCredit(Client client) {
        Credit credit = database.queryCredit(client);
        if(credit != null) {
            System.out.println(TAG + ": " + credit.toString());
        }
        else {
            System.out.println(TAG + ": Credit was not found");
        }
    }


    public void askForDelay(int numberOfMonths) {
        System.out.println(TAG + ": Number of months was extended with: " + numberOfMonths);
    }


    public void askForHelp() {
        System.out.println(TAG + ": 1. To ask for a credit, call askForCredit() method");
        System.out.println("2. To ask for interest rate, call askForInterestRate() method");
        System.out.println("3. To pay the installment, call payInstallment() method");
        System.out.println("4. To ask details about your credit, call askDetailsAboutYourCredit() method");
        System.out.println("5. To ask for a delay, call askForDelay() method");
    }
}
