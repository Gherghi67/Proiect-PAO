package database;

import credit.Credit;
import user.User;

public interface DatabaseService {

    void addUserToDatabase(User user);
    void deleteUserFromDatabase(String cnp);
    User queryUserFromDatabase(String cnp);
    void addCreditToUser(User user, Credit credit);
    void deleteCreditFromUser(User user);
    Credit queryCredit(User user);
}
