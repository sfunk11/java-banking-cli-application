package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.project0.main.Account;



public class TransactionTest {

	
	
	@Test
	public void AccountConstructorTest() {
		Account newAccount = new Account(1500.00, "mthompson@email.com");
		assertEquals("mthompson@email.com", newAccount.getOwner());
	}
	
	@Test
	public void getBalanceTest() {
		Account newAccount = new Account(1500.00, "mthompson@email.com");
		assertEquals(1500.00, newAccount.getBalance());
	}
	
	@Test
	public void transactionTest() {
		Account newAccount = new Account(1500.00, "mthompson@email.com");
		newAccount.deposit(500);
		assertEquals(2000.00, newAccount.getBalance());
	}
}


