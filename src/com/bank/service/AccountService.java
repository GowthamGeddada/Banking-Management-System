package com.bank.service;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import java.util.List;

public interface AccountService {

    void openAccount(Account account);

    Account fetchAccount(int accountId) throws AccountNotFoundException;

    void creditAmount(int accountId, double amount) throws AccountNotFoundException;

    void debitAmount(int accountId, double amount) throws AccountNotFoundException;

    List<Account> viewAllAccounts();
}
