package job_hacker.example.models.accounts;

public class Account {
    protected static int staticAccountNumber = 1;
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String holderName, double balance) {
        this.accountNumber = staticAccountNumber;
        this.holderName = holderName;
        if (balance > 0)
            this.balance = balance;

        ++staticAccountNumber;
    }

    public double deposit(double deposit) {
        if (deposit < 0)
            throw new ArithmeticException("Can't deposit a negative number");
        balance += deposit;
        return balance;
    }
    public double withdraw(double money) {
        if (money < 0)
            throw new ArithmeticException("Can't withdraw a negative number");
        if (money > balance)
            throw new ArithmeticException("Your current balance is: " + balance
                    + " can't withdraw: " + money);

        balance -= money;
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
