package com.training.bank;

public class SavingAccount extends Account{
	private double roi;
	private double minBalance;
	
	// Constructor
	public SavingAccount(int accountNumber, String accountHolderName, double amount, double roi, double minBalance) {
		super(accountNumber, accountHolderName, amount);
		this.roi = roi;
		this.minBalance = minBalance;
	}
	
	// Calculate method
	public double getRoi() {
		return this.roi;
	}
	
	public double getMinBalance() {
		return this.minBalance;
	}
	
	
	// Setters
	public void setRoi(double roi) {
		this.roi = roi;
	}
	
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public String display() {
		return super.display() + ", roi = " + this.getRoi() + ", Minimum Balance = " + this.getMinBalance();
	}
	
}
