package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.project0.models.Account;


public class AccountTest {

	@Test
	public void TwoArgConstructorTest() {
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(3);
		Account newAccount = new Account(250.00, idList);
		assertEquals(250.00, newAccount.getBalance());
	}
	
	@Test
	public void AllArgConstructorTest() {
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(3);
		List<String> nameList = new ArrayList<>();
		nameList.add("mthompson");
		Account newAccount = new Account(5, 250.00, true, nameList,idList);
		assertEquals("mthompson", newAccount.getOwnerUsernames().get(0));
	}
	
	@Test
	public void SetterTest() {
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(3);
		List<String> nameList = new ArrayList<>();
		nameList.add("mthompson");
		Account newAccount = new Account(5, 250.00, true, nameList,idList);
		newAccount.setApproved(false);
		assertEquals(false, newAccount.isApproved());
	}
}
