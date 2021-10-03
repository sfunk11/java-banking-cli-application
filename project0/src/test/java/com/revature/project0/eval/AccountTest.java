package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.project0.models.Account;


public class AccountTest {

	@Test
	public void TwoArgConstructorTest() {
		Account newAccount = new Account(2, 250.00);
		assertEquals(250.00, newAccount.getBalance());
	}
	
	@Test
	public void AllArgConstructorTest() {
		Account newAccount = new Account(5, 2, 250.00, true, "mthompson");
		assertEquals("mthompson", newAccount.getOwnerUsername());
	}
	
	@Test
	public void SetterTest() {
		Account newAccount = new Account(5, 2, 250.00, true, "mthompson");
		newAccount.setApproved(false);
		assertEquals(false, newAccount.isApproved());
	}
}
