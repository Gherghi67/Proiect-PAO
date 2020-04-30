package database;

import card.Card;
import credit.Credit;
import user.User;

public interface DatabaseService {

    void addUserToDatabase(User user) throws Exception;
    void deleteUserFromDatabase(String cnp) throws Exception;
    User queryUserFromDatabase(String cnp);
    void addCreditToUser(User user, Credit credit) throws Exception;
    void deleteCreditFromUser(User user) throws Exception;
    Credit queryCredit(User user);
    void modifyCardBalance(User user, int money) throws Exception;
    Card queryCard(User user);
}
