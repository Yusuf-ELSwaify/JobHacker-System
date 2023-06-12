package job_hacker.example.repositories;

import job_hacker.example.models.accounts.Account;
import job_hacker.example.models.accounts.SavingAccount;

import java.util.LinkedList;
import java.util.Optional;

public class BankRepository {
    LinkedList<Account> accounts = new LinkedList<>();
    private static BankRepository instance = new BankRepository();
    private BankRepository(){}

    public static BankRepository getBankInstance(){
        return instance;
    }
    public Account addNewAccount(String holderName, double balance){
        Account newAccount = new Account(holderName,balance);
        accounts.add(newAccount);
        return newAccount;
    }
    public Account addNewSavingAccount(String holderName, double balance){
        Account newAccount = new SavingAccount(holderName,balance);
        accounts.add(newAccount);
        return newAccount;
    }
    public double deposit(Account account, double deposit) {
        return account.deposit(deposit);
    }
    public double withdraw(Account account, double money) {
        return account.withdraw(money);
    }
    @Deprecated
    public void displayAccountDetails(Account account) {
        System.out.println(account);
    }
    public void displayAllAccountsDetails() {
        System.out.println(accounts);
    }
    public Optional<Account> getAccount(int accountNumber){
        return accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst();
    }
}
