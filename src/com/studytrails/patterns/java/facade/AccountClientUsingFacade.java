package com.studytrails.patterns.java.facade;

public class AccountClientUsingFacade
{

	static AccountFacade facade;

	public static void main(String[] args)
	{
		facade = new AccountFacade();
		String name = args[0];
		String ssn = args[1];

		Account account = facade.createAccount(name, ssn);
		if (account == null)
			System.out.println("account creation failed");
	}
}
