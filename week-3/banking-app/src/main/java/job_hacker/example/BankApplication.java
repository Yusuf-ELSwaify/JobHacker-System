package job_hacker.example;

import job_hacker.example.repositories.BankRepository;
import job_hacker.example.models.accounts.Account;
import job_hacker.example.services.BankService;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(scanner);
        while (true) {
            System.out.println("""
                    choose from next list:
                        1 - View all accounts
                        2 - view an account(view, deposit, withdraw)
                        3 - Add new account(normal, saving)
                        4 - Exit
                    """);
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> bankService.displayAllAccountsDetails();
                case 2 -> bankService.displayAccountDetails();
                case 3 -> bankService.openNewAccount();
                case 4 -> {
                    return;
                }
                default -> System.out.println("wrong entry, try again");
            }

        }
    }
}