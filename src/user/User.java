package user;

import card.Card;

public class User {

    private String name;
    private String cnp;
    private String password;

    private int age;

    private Card card;

    public User() {

    }

    public User(String name, String cnp, String password, int age, Card card) {
        this.name = name;
        this.cnp = cnp;
        this.password = password;
        this.age = age;
        this.card = card;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
