package com.studytrails.patterns.java.facade;

public class AccountClient
{
	private static AccountDetailsVerifier verifier;
	private static AccountGenerator generator;

	public static void main(String[] args)
	{
		String name = args[0];
		String ssn = args[1];

		verifier = new AccountDetailsVerifier();
		if (!verifier.isSSNValid(ssn)) {
			System.out.println("Account Creation Failed");
			return;
		}
		// check if account for this person (name, ssn combination) is present
		if (verifier.isAccountPresent(name, ssn)) {
			System.out.println("Account Creation Failed");
			return;
		}

		generator = new AccountGenerator();
		String account_no = generator.generateAccountNumber(name, ssn);
		Account account = generator.createAccount(name, account_no, ssn);

	}
	
	
}
