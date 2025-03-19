package com.training.bank;

public class Account {
	private int accountNumber;
	private String accountHolderName;
	private double amount;
	
	// Constructor
	public Account(int accountNumber, String accountHolderName, double amount) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.amount = amount;
	}
	
	
	
	// Getters
		public int getAccountNumber() {
			return this.accountNumber;
		}
		public String getAccountHolderName() {
			return this.accountHolderName;
		}
		public double getAmount() {
			return this.amount;
		}
		
		// Setters
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		
		// Method "display"
		public String display() {
			return "SavingAccount: Account Number= " + accountNumber + ", Account Holder Name= " + accountHolderName + ", amount = " + amount;
		}
		
		// Method "deposit"
		public void deposit(double value) {
			this.amount = this.amount + value;
		}
		
		// Method "withdraw"
		public void withdraw(double value) {
			if (this.amount < value) {
				System.out.println("Unavailable Funds");
			} else {
				this.amount = this.amount - value;
			}
		}
		
		// Method "check"
		public void check() {
			System.out.println("Balance: " + getAmount());
		}
}
