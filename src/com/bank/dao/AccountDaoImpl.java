package com.bank.dao;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void createAccount(Account account) {
		String sqlQuery = "insert into account(account_id, holder_name, account_type, balance) values (?,?,?,?)";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuery)) {

			ps.setInt(1, account.getAccountId());
			ps.setString(2, account.getHolderName());
			ps.setString(3, account.getAccountType());
			ps.setDouble(4, account.getBalance());
			ps.executeUpdate();

			System.out.println("account created: " + account);
			System.out.println("Account Creation Successfull");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account getAccountById(int id) throws AccountNotFoundException {
		String sqlQuery = "select * from account where account_id=?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuery)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			} else {
				throw new AccountNotFoundException("account with id " + id + " not found");
			}

		} catch (SQLException e) {
			throw new AccountNotFoundException("database error: " + e.getMessage());
		}
	}

	@Override
	public void deposit(int id, double amount) throws AccountNotFoundException {
		// check account exists
		getAccountById(id);

		String sqlQuery = "update account set balance = balance + ? where account_id=?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuery)) {

			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("amount deposited: " + amount);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int id, double amount) throws AccountNotFoundException {
		// check account exists
		getAccountById(id);

		String sqlQuery = "update account set balance = balance - ? where account_id=?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuery)) {

			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("amount withdrawn: " + amount);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> list = new ArrayList<>();
		String sqlQuery = "select * from account";

		try (Connection con = ConnectionFactory.getConnection(); Statement st = con.createStatement()) {

			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}