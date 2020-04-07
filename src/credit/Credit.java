package credit;

public class Credit {

    private int monthlyInstallment;
    private int interestRate;
    private int remainingMoneyToPay;

    public Credit() {

    }

    public Credit(int monthlyInstallment, int interestRate, int remainingMoneyToPay) {
        this.monthlyInstallment = monthlyInstallment;
        this.interestRate = interestRate;
        this.remainingMoneyToPay = remainingMoneyToPay;
    }

    public int getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(int monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getRemainingMoneyToPay() {
        return remainingMoneyToPay;
    }

    public void setRemainingMoneyToPay(int remainingMoneyToPay) {
        this.remainingMoneyToPay = remainingMoneyToPay;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "monthlyInstallment=" + monthlyInstallment +
                ", interestRate=" + interestRate +
                ", remainingMoneyToPay=" + remainingMoneyToPay +
                '}';
    }
}
