package job_hacker.example;

import job_hacker.example.repositories.BankRepository;
import job_hacker.example.models.accounts.Account;

public class BankApplication {
    public static void main(String[] args) {
        BankRepository bankRepository = BankRepository.getBankInstance();

        Account yusufAccount = bankRepository.addNewAccount("yusuf",100);
        System.out.println(bankRepository.deposit(yusufAccount,1000));
        System.out.println(bankRepository.withdraw(yusufAccount,100));
        bankRepository.displayAccountDetails(yusufAccount);
        System.out.println("_____________");
        Account yusufSavingAccount = bankRepository.addNewSavingAccount("yusuf saving",500);
        System.out.println(bankRepository.deposit(yusufSavingAccount,301));
        bankRepository.displayAccountDetails(yusufSavingAccount);
        System.out.println("______________");
        Account yusufSuperSavingAccount = bankRepository.addNewSavingAccount("yusuf super saving",50000);
        System.out.println(bankRepository.deposit(yusufSuperSavingAccount,301));
        bankRepository.displayAccountDetails(yusufSuperSavingAccount);
    }
}