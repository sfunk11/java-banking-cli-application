package com.revature.project0.eval;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.project0.models.User;



public class UserTest {

	
	@Test
	public void FourArgConstructorTest() {
		User newUser = new User("Mike", "Thompson", "mthompson", "password");
		assertEquals("mthompson", newUser.getUsername());
	}
	
	@Test
	public void AllArgConstructorTest() {
		User newUser = new User(1, "Mike", "Thompson", "mthompson", "password", false, false, "mthompson@rmail.com");
		assertEquals(1, newUser.getUserid());
	}
	
	@Test
	public void SetterTest() {
		User user = new User("Mike", "Thompson", "mthompson", "password");
		user.setEmail("mthompson@email.com");
		assertEquals("mthompson@email.com", user.getEmail());
	}
}