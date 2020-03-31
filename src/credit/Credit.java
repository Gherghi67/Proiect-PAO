package credit;

public class Credit {

    private int monthlyInstallment;
    private int interestRate;

    public Credit() {

    }

    public Credit(int monthlyInstallment, int interestRate) {
        this.monthlyInstallment = monthlyInstallment;
        this.interestRate = interestRate;
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

    @Override
    public String toString() {
        return "Credit{" +
                "monthlyInstallment=" + monthlyInstallment +
                ", interestRate=" + interestRate +
                '}';
    }
}
