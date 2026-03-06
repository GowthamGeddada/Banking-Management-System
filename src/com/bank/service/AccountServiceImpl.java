package com.bank.service;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoImpl;
import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService {

	private AccountDao dao = new AccountDaoImpl();

	@Override
	public void openAccount(Account account) {
		dao.createAccount(account);
	}

	@Override
	public Account fetchAccount(int accountId) throws AccountNotFoundException {
		return dao.getAccountById(accountId);
	}

	@Override
	public void creditAmount(int accountId, double amount) throws AccountNotFoundException {
		dao.deposit(accountId, amount);
	}

	@Override
	public void debitAmount(int accountId, double amount) throws AccountNotFoundException {
		dao.withdraw(accountId, amount);
	}

	@Override
	public List<Account> viewAllAccounts() {
		return dao.getAllAccounts();
	}
}
