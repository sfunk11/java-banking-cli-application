package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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
	private Account testAccount = new Account(5, 1, 250.00, true, "mthompson");
	

	
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		uServ = new UserService(uDao);
		aServ = new AccountService(aDao);
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
		assertEquals(testuser,  uServ.logIn("mthompson", "password"));
	}
	
	@Test
	public void LoginFailTest() {
		
		assertThrows(IllegalArgumentException.class, () -> uServ.logIn("mthompson", "something"));
	}
}


