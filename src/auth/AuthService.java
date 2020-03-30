package auth;

import user.User;

public class AuthService {

    private static final String TAG = "AuthService";

    private static AuthService singleInstance;

    private static final String globalPassword = "12345";

    private static User currentUser = null;

    private AuthService() {

    }

    // method that returns the singleton instance
    public static AuthService getInstance() {
        if(singleInstance == null) {
            singleInstance = new AuthService();
        }
        return singleInstance;
    }

    public void registerNewUser(User user) {
        currentUser = user;

        System.out.println("New user registered with name : " + currentUser.getName() + "and CNP: " + currentUser.getCnp());
    }

    public void signInUser(User user) {
        if(user.getPassword().equals(globalPassword)) {
            currentUser = user;

            System.out.println("User signed in with name: " + currentUser.getName() + "and CNP: " + currentUser.getCnp());
        }
        else {
            System.out.println("Invalid password!");
        }
    }

    public void signOutUser() {
        currentUser = null;

        System.out.println("Current user signed out");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
