package database;

import credit.Credit;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDatabaseService implements DatabaseService {

    private static final String TAG = "ListDatabaseService";

    private static ListDatabaseService singleInstance = null;

    private List<User> users;

    private Map<User, Credit> userCreditMap;


    private ListDatabaseService() {
        users = new ArrayList<>();
        userCreditMap = new HashMap<>();
    }


    public static ListDatabaseService getInstance() {
        if(singleInstance == null) {
            singleInstance = new ListDatabaseService();
        }
        return singleInstance;
    }


    @Override
    public void addUserToDatabase(User user) {
        users.add(user);

        System.out.println(TAG + ": User added to database with name: " + user.getName() + "and CNP: " + user.getCnp());
    }


    @Override
    public void deleteUserFromDatabase(String cnp) {
        users.removeIf(user -> user.getCnp().equals(cnp));

        System.out.println(TAG + ": User deleted from database with CNP: " + cnp);
    }


    @Override
    public User queryUserFromDatabase(String cnp) {
        for(User user : users) {
            if(user.getCnp().equals(cnp)) {
                System.out.println(TAG + ": User with CNP: " + cnp + "was found");
                return user;
            }
        }
        System.out.println(TAG + ": User with CNP: " + cnp + "was not found");
        return null;
    }


    @Override
    public void addCreditToUser(User user, Credit credit) {
        userCreditMap.put(user, credit);

        System.out.println(TAG + ": Credit added to user with CNP: " + user.getCnp());
    }


    @Override
    public void deleteCreditFromUser(User user) {
        if(userCreditMap.remove(user) == null) {
            System.out.println(TAG + ": Cannot find user");
        }
        else {
            System.out.println(TAG + ": Credit was removed from user with CNP: " + user.getCnp());
        }
    }


    @Override
    public Credit queryCredit(User user) {
        return userCreditMap.get(user);
    }
}
