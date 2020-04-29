package user;

import card.Card;

public class User implements Comparable<User> {

    private String name;
    private String cnp;
    private String password;

    private int age;

    private int cardId;

    public User() {

    }

    public User(String name, String cnp, String password, int age, int cardId) {
        this.name = name;
        this.cnp = cnp;
        this.password = password;
        this.age = age;
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public int compareTo(User user) {
        return this.cnp.compareTo(user.cnp);
    }
}
