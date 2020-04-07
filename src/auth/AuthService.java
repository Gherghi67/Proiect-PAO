package auth;

import database.ListDatabaseService;
import user.User;

public class AuthService {

    private static final String TAG = "AuthService";

    private static AuthService singleInstance = null;

    private static final String globalPassword = "12345";

    private static User currentUser = null;

    private ListDatabaseService service;

    private AuthService() {
        service = ListDatabaseService.getInstance();
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

        // adding user to database after registering
        service.addUserToDatabase(user);

        System.out.println(TAG + ": New user registered with name : " + currentUser.getName() + " and CNP: " + currentUser.getCnp());
    }


    public void signInUser(String cnp, String password) {
        // querring the database
        User user = service.queryUserFromDatabase(cnp);

        if(user == null) {
            return;
        }

        if(user.getPassword().equals(password)) {
            currentUser = user;

            System.out.println(TAG + ": User signed in with name: " + currentUser.getName() + " and CNP: " + currentUser.getCnp());
        }
        else {
            System.out.println(TAG + ": Invalid password!");
        }
    }


    public void signOutUser() {
        currentUser = null;

        System.out.println(TAG + ": Current user signed out");
    }


    public User getCurrentUser() {
        return currentUser;
    }
}
