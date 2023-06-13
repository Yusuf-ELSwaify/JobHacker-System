package job_hacker.example.services;

import job_hacker.example.models.accounts.Account;
import job_hacker.example.repositories.BankRepository;

import java.util.Optional;
import java.util.Scanner;

public class BankService {
	private final BankRepository bankRepository = BankRepository.getBankInstance();
	private final Scanner scanner;

	public BankService() {
		this.scanner = new Scanner(System.in);
	}
	public BankService(Scanner scanner) {
		this.scanner = scanner;
	}

	public void displayAllAccountsDetails() {
		bankRepository.displayAllAccountsDetails();
	}
	public void displayAccountDetails() {
		System.out.println("Enter your account number:");
		int accountNumber = scanner.nextInt();

		Optional<Account> optionalAccount = bankRepository.getAccount(accountNumber);

		if (optionalAccount.isEmpty()) {
			System.out.println("This account is not exist");
			return;
		}
		Account account = optionalAccount.get();
		System.out.println("your account details = " + account);

		while (true) {
			System.out.println("""
						choose from next list:
							1 - Deposit money
							2 - Withdraw money
							3 - Back to previous window
						""");
			int choose = scanner.nextInt();
			switch (choose) {
				case 1 -> {
					deposit(account);
					System.out.println("your account details = " + account);
				}
				case 2 -> {
					withdraw(account);
					System.out.println("your account details = " + account);
				}
				case 3 -> {
					return;
				}
				default -> System.out.println("wrong entry, try again");
			}
		}
	}

	public double deposit(Account account) {
		System.out.println("Enter the amount of deposit:");

		int deposit = scanner.nextInt();
		try {
			return bankRepository.deposit(account, deposit);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return deposit(account);
		}
	}
	public double withdraw(Account account) {
		System.out.println("Enter the amount of money to withdraw: ");

		int money = scanner.nextInt();
		try {
			return bankRepository.withdraw(account, money);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return withdraw(account);
		}
	}

	public void openNewAccount() {
		System.out.println("""
						choose from next list:
							1 - New account
							2 - New saving account
							3 - Back to previous window
						""");
		int choose = scanner.nextInt();

		switch (choose) {
			case 1, 2 ->
					openNewAccount(choose);
			case 3 -> {
				return;
			}
			default -> {
				System.out.println("wrong entry, try again");
				openNewAccount();
			}
		}
	}

	private void openNewAccount(int choose) {
		System.out.println("Enter holder name: ");
		scanner.nextLine();
		String holderName = scanner.nextLine();
		System.out.println("Enter balance ");
		int balance = scanner.nextInt();
		Account account;
		if (choose == 1)
			account = bankRepository.addNewAccount(holderName, balance);
		else
			account = bankRepository.addNewSavingAccount(holderName, balance);

		System.out.println("your account details = " + account);
	}

}
