package com.studytrails.patterns.java.facade;

public class AccountFacade
{

	private AccountDetailsVerifier verifier;
	private AccountGenerator generator;

	public Account createAccount(String name, String ssn)
	{
		verifier = new AccountDetailsVerifier();
		if (!verifier.isSSNValid(ssn))
			return null;
		// check if account for this person (name, ssn combination) is present
		if (verifier.isAccountPresent(name, ssn))
			return null;
		generator = new AccountGenerator();
		String account_no = generator.generateAccountNumber(name, ssn);
		Account account = generator.createAccount(name, account_no, ssn);
		return account;
	}

}