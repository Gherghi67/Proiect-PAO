package main;

import auth.AuthService;
import credit.CreditService;
import user.User;


public class Main {

    public static void main(String[] args) throws Exception {
        AuthService authService = AuthService.getInstance();

        CreditService creditService = CreditService.getInstance();

        authService.signInUser("20000", "1234");

        User client = authService.getCurrentUser();

        creditService.askForACredit(client, 20000, 10);
    }
}
