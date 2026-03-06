package com.bank.dao;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import java.util.List;

public interface AccountDao {

	void createAccount(Account account);

	Account getAccountById(int id) throws AccountNotFoundException;

	void deposit(int id, double amount) throws AccountNotFoundException;

	void withdraw(int id, double amount) throws AccountNotFoundException;

	List<Account> getAllAccounts();
}
