package card;

public class Card {

    private String cardNumber;
    private String ccv;

    private int balance;

    public Card() {

    }

    public Card(String cardNumber, String ccv, int balance) {
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", ccv='" + ccv + '\'' +
                ", balance=" + balance +
                '}';
    }
}
