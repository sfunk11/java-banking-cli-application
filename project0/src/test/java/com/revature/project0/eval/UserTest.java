package com.revature.project0.eval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.project0.main.User;

public class UserTest {

	
	@Test
	public void TwoArgConstructorTest() {
		User newUser = new User("Mike Thompson", "mthompson@email.com");
		assertEquals("mthompson@email.com", newUser.getEmail());
}
}