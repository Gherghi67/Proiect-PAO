package database;

import card.Card;
import credit.Credit;
import user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDatabaseService implements DatabaseService {

    private static final String TAG = "ListDatabaseService";

    private static ListDatabaseService singleInstance = null;

    private List<User> users;
    private List<Card> cards;
    private List<Credit> credits;

    private Map<User, Credit> userCreditMap;

    private ReadWriteService service;

    private ListDatabaseService() throws Exception {
        service = ReadWriteService.getInstance();

        users = service.read("data/users.csv", User.class);
        cards = service.read("data/cards.csv", Card.class);
        credits = service.read("data/credits.csv", Credit.class);

        userCreditMap = new HashMap<>();
    }


    public static ListDatabaseService getInstance() throws Exception {
        if(singleInstance == null) {
            singleInstance = new ListDatabaseService();
        }
        return singleInstance;
    }


    @Override
    public void addUserToDatabase(User user) throws Exception {
        users.add(user);

        service.write(user, "data/users.csv");

        System.out.println(TAG + ": User added to database with name: " + user.getName() + " and CNP: " + user.getCnp());
    }


    @Override
    public void deleteUserFromDatabase(String cnp) throws Exception {
        users.removeIf(user -> user.getCnp().equals(cnp));

        service.write(users, "data/user.csv");

        System.out.println(TAG + ": User deleted from database with CNP: " + cnp);
    }


    @Override
    public User queryUserFromDatabase(String cnp) {
        for(User user : users) {
            if(user.getCnp().equals(cnp)) {
                System.out.println(TAG + ": User with CNP: " + cnp + " was found");
                return user;
            }
        }
        System.out.println(TAG + ": User with CNP: " + cnp + " was not found");
        return null;
    }


    @Override
    public void addCreditToUser(User user, Credit credit) throws Exception {
        for(User userr : users) {
            if(userr.getCnp().equals(user.getCnp())) {
                userr.setCreditId(credit.getCreditId());
            }
        }

        service.write(users, "data/users.csv");
        service.write(credit, "data/credits.csv");

        System.out.println(TAG + ": Credit added to user with CNP: " + user.getCnp());
    }


    @Override
    public void deleteCreditFromUser(User user) throws Exception {
        int creditId = 0;

        for(User userr : users) {
            if(userr.getCnp().equals(user.getCnp())) {
                creditId = userr.getCreditId();
                userr.setCreditId(0);
            }
        }

        service.write(users, "data/users.csv");

        int finalCreditId = creditId;
        credits.removeIf(credit -> credit.getCreditId() == finalCreditId);

        service.write(credits, "data/credits.csv");
    }


    @Override
    public Credit queryCredit(User user) {
        int creditId = 0;

        for(User userr : users) {
            if(userr.getCnp().equals(user.getCnp())) {
                creditId = user.getCreditId();
            }
        }

        for(Credit credit : credits) {
            if(credit.getCreditId() == creditId) {
                return credit;
            }
        }
        return null;
    }


    @Override
    public void modifyCardBalance(User user, int money) throws Exception {
        int cardId = 0;

        for(User userr : users) {
            if(userr.getCnp().equals(user.getCnp())) {
                cardId = userr.getCardId();
            }
        }

        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                card.setBalance(card.getBalance() - money);
            }
        }

        service.write(cards, "data/cards.csv");
    }


    @Override
    public Card queryCard(User user) {
        int cardId = 0;

        for(User userr : users) {
            if(userr.getCnp().equals(user.getCnp())) {
                cardId = userr.getCardId();
            }
        }

        for(Card card : cards) {
            if(card.getCardId() == cardId) {
                return card;
            }
        }
        return null;
    }
}
