package main;

import auth.AuthService;
import card.Card;
import credit.CreditService;
import user.Client;


public class Main {

    public static void main(String[] args) {
        AuthService authService = AuthService.getInstance();

        CreditService creditService = CreditService.getInstance();

        // register user
        Client client = new Client("gherghi", "1990717280019", "12345", 20,
                new Card("1234", "567", 200000));
        client.setMarried(false);
        client.setRetired(false);
        authService.registerNewUser(client);

        // ask for help
        creditService.askForHelp();

        // ask for interest rate
        creditService.askForInterestRate((Client) authService.getCurrentUser());

        // ask for a credit
        creditService.askForACredit(client, 200000, 12);

        // sign out user
        authService.signOutUser();

        // sign in user
        authService.signInUser("1990717280019", "12345");

        // ask details about your credit
        creditService.askDetailsAboutYourCredit((Client) authService.getCurrentUser());

        // pay installment
        creditService.payInstallment((Client) authService.getCurrentUser(), 2000);

        // check bank balance
        System.out.println("Bank balance: " + authService.getCurrentUser().getCard().getBalance());

        // ask for a delay
        creditService.askForDelay(1);

        // sign out user
        authService.signOutUser();
    }
}
