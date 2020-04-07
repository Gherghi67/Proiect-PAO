package main;

import auth.AuthService;
import card.Card;
import user.Client;
import user.User;

public class Main {

    public static void main(String[] args) {
        AuthService service = AuthService.getInstance();
        User user1 = new Client("ghergi", "12345", "123", 20, new Card());

        service.registerNewUser(user1);
        service.signOutUser();

        User user2 = new Client("ion", "421", "421", 30, new Card());
        service.registerNewUser(user2);
        service.signOutUser();

        service.signInUser("12345", "123");
        service.signOutUser();

        service.signInUser("02", "23");

    }
}
