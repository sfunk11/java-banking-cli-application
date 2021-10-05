package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.project0.data.AccountDaoImpl;
import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;



public class TransactionTest {

	@Mock 
	private UserDaoImpl uDao;
	@Mock 
	private AccountDaoImpl aDao;
	
	private UserService uServ;
	private AccountService aServ;
	private User testuser = new User(1, "Mike", "Thompson", "mthompson", "password", false, false, "mthompson@rmail.com");
	List<Integer> idList = new ArrayList<>();
	List<String> nameList = new ArrayList<>();
	
	Account testAccount = new Account(5, 250.00, true, nameList,idList);
	
	

	
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		uServ = new UserService(uDao);
		aServ = new AccountService(aDao, uDao);
		idList.add(1);
		idList.add(3);
		nameList.add("mthompson");
		when(aDao.getAccountbyID(5)).thenReturn(testAccount);
		when(uDao.getByUsername("mthompson")).thenReturn(testuser);
	}
	
	@Test
	public void DisplaySingleAccountTest() {
		Account test = aServ.displaySingleAccount(5);
		assertEquals(250.0, test.getBalance());
	}
	
	@Test
	public void LoginTest() {
		User user =  uServ.logIn("mthompson", "password");
		Assert.assertNotNull(user);;
	}
	
	@Test
	public void LoginFailTest() {
		User user = uServ.logIn("mthompson", "something");
		
		Assert.assertNull(user);
		
	}
	
	@Test
	public void OverdraftTest() {
		double amount = 300;
		aServ.withdraw(testAccount, amount);
		assertEquals(250.0, testAccount.getBalance());
		
	}
}



