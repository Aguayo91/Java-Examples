package com.studytrails.patterns.java.facade;

public class AccountGenerator
{

	public Account createAccount(String name, String account_Number, String ssn)
	{
		Account account = new Account();
		account.name = name;
		account.account_number = account_Number;
		account.ssn = ssn;
		return account;
	}

	public String generateAccountNumber(String name, String ssn)
	{
		return ssn + "" + name.length();
	}
}
