package user;

import card.Card;

public class Client extends User {

    private boolean isMarried;
    private boolean isRetired;


    public Client(String name, String cnp, String password, int age, int cardId) {
        super(name, cnp, password, age, cardId);
    }


    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public boolean isRetired() {
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

}
