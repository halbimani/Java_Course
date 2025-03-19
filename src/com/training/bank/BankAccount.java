package com.training.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) {
		
		List<SavingAccount> accounts = new ArrayList<>();
		
		accounts.add(new SavingAccount(12345, "Harith Al Bimani", 1000, 0.06, 200));
		accounts.add(new SavingAccount(67890, "Ali Al Riyami", 2000, 0.05, 200));
		accounts.add(new SavingAccount(11223, "Sara Al Amri", 1500, 0.07, 200));
		accounts.add(new SavingAccount(44556, "Fatima Al Busaidi", 2500, 0.04, 200));
		
		
		System.out.println(accounts.get(2).display());
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while (true) {
			System.out.println("Press the number corresponding to your option:\n"
					+ "1. Create an Account\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Balance\n"
					+ "5. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
		
			switch (choice) {
				case 1:
					Scanner s1 = new Scanner(System.in);
					System.out.println("Enter Account Number: ");
					int accountNumber = s1.nextInt();
					s1.nextLine();
					System.out.println("Enter Name: ");
					String accountName = s1.nextLine();
					System.out.println("Enter Balance: ");
					double amount = s1.nextDouble();
					System.out.println("Enter Rate of Interest: ");
					double roi = s1.nextDouble();
					System.out.println("Enter Minimum Balance: ");
					double minBalance = s1.nextDouble();
					accounts.add(new SavingAccount(accountNumber, accountName, amount, roi, minBalance));
					break;
				case 2:
					Scanner s2 = new Scanner(System.in);
					System.out.println("Enter Account Number: ");
					int account2 = s2.nextInt();
					SavingAccount chosenAccount2 = accounts.get(0);
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getAccountNumber() == account2) {
							chosenAccount2 = accounts.get(i);
						}
					}
					System.out.println("Enter Deposit Amount: ");
					double value2 = s2.nextDouble();
					chosenAccount2.deposit(value2);
					break;
				case 3:
					Scanner s3 = new Scanner(System.in);
					System.out.println("Enter Account Number: ");
					int account3 = s3.nextInt();
					SavingAccount chosenAccount3 = accounts.get(0);
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getAccountNumber() == account3) {
							chosenAccount3 = accounts.get(i);
						}
					}
					System.out.println("Enter Withdraw Amount: ");
					double value3 = s3.nextDouble();
					if (value3 > chosenAccount3.getAmount()) {
						System.out.println("Invalid Amount");
					} else {
						chosenAccount3.withdraw(value3);
					}
					break;
				case 4:
					Scanner s4 = new Scanner(System.in);
					System.out.println("Enter Account Number: ");
					int account4 = s4.nextInt();
					SavingAccount chosenAccount4 = accounts.get(0);
					for (int i =0; i < accounts.size(); i++) {
						if (accounts.get(i).getAccountNumber() == account4) {
							chosenAccount4 = accounts.get(i);
						}
					}
					chosenAccount4.check();
					break;
				case 5:
					System.out.println("Exiting Program. Thank You!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input! Please Enter a Valid Option.");
			}
		}
	}
}