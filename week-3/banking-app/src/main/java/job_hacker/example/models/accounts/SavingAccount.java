package job_hacker.example.models.accounts;

public class SavingAccount extends Account{
    private static final double SUPER_ACCOUNT_MIN_BALANCE = 10000;
    private double interestRate;
    public SavingAccount(String holderName, double balance) {
        super(holderName, balance);
        this.interestRate = calulateInterestRate();
    }
    public double getInterestRate() {
        return interestRate;
    }
    private double calulateInterestRate() {
        if (this.balance > SUPER_ACCOUNT_MIN_BALANCE)
            return 0.20;
        return 0.15;
    }

    @Override
    public double deposit(double deposit) {
        return super.deposit(deposit + deposit * interestRate);
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "accountNumber=" + accountNumber +
                ", interestRate=" + interestRate +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
