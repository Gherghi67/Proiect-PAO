package credit;

import audit.AuditService;
import database.ListDatabaseService;
import transaction.TransactionService;
import user.User;

import java.sql.Timestamp;


public class CreditService {

    private static final String TAG = "CreditService";

    private static final int STANDARD_INTEREST_RATE = 25;

    private static final int MARRIED_INTEREST_RATE = 15;

    private static final int RETIRED_INTEREST_RATE = 20;

    private static CreditService singleInstance = null;

    private ListDatabaseService database;

    private TransactionService transactionService;

    private AuditService auditService;

    private CreditService() throws Exception {
        database = ListDatabaseService.getInstance();

        transactionService = TransactionService.getInstance();

        auditService = AuditService.getInstance();
    }


    public static CreditService getInstance() throws Exception {
        if(singleInstance == null) {
            singleInstance = new CreditService();
        }
        return singleInstance;
    }


    public void askForACredit(User client, int money, int period) throws Exception {


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

        auditService.writeAction("add_credit_to_user", new Timestamp(System.currentTimeMillis()));
        System.out.println(TAG + ": Credit created for client with CNP: " + client.getCnp());
    }


    public void askForInterestRate(User client) throws Exception {
        if(client.isRetired()) {
            System.out.println(TAG + ": Interest rate is: " + RETIRED_INTEREST_RATE);
        }
        else if(client.isMarried()) {
            System.out.println(TAG + ": Interest rate is: " + MARRIED_INTEREST_RATE);
        }
        else {
            System.out.println(TAG + ": Interest rate is: " + STANDARD_INTEREST_RATE);
        }

        auditService.writeAction("ask_for_interest_rate", new Timestamp(System.currentTimeMillis()));
    }


    public void payInstallment(User client, int money) throws Exception {
        transactionService.makeTransaction(client, money);

        auditService.writeAction("pay_installment", new Timestamp(System.currentTimeMillis()));
    }


    public void askDetailsAboutYourCredit(User client) throws Exception {
        Credit credit = database.queryCredit(client);
        if(credit != null) {
            System.out.println(TAG + ": " + credit.toString());
        }
        else {
            System.out.println(TAG + ": Credit was not found");
        }

        auditService.writeAction("ask_details_about_your_credit", new Timestamp(System.currentTimeMillis()));
    }


    public void askForDelay(int numberOfMonths) throws Exception {
        System.out.println(TAG + ": Number of months was extended with: " + numberOfMonths);
        auditService.writeAction("ask_for_delay", new Timestamp(System.currentTimeMillis()));
    }


    public void askForHelp() throws Exception {
        System.out.println(TAG + ": 1. To ask for a credit, call askForCredit() method");
        System.out.println("2. To ask for interest rate, call askForInterestRate() method");
        System.out.println("3. To pay the installment, call payInstallment() method");
        System.out.println("4. To ask details about your credit, call askDetailsAboutYourCredit() method");
        System.out.println("5. To ask for a delay, call askForDelay() method");
        
        auditService.writeAction("ask_for_help", new Timestamp(System.currentTimeMillis()));
    }
}
