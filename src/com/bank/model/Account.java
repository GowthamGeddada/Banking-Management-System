package com.bank.model;

public class Account {
	private int accountId;
	private String holderName;
	private String accountType;
	private double balance;

	public Account() {
		super();
	}

	public Account(int accountId, String holderName, String accountType, double balance) {
		this.accountId = accountId;
		this.holderName = holderName;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", holderName=" + holderName + ", accountType=" + accountType
				+ ", balance=" + balance + "]";
	}
	
	
}
