package model.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserDetailTest {

	User user = new User();

	UserDetail userDetailDefault = new UserDetail();

	@Test
	public void setUserNameTest() {
		userDetailDefault.setUserName("Thamali");
		assertEquals("Thamali", userDetailDefault.getUserName());
	}

	@Test
	public void setUserTest() {
		userDetailDefault.setUser(user);
		assertEquals(user, userDetailDefault.getUser());
	}

	@Test
	public void setNameTest() {
		userDetailDefault.setName("Thamali Epa");
		assertEquals("Thamali Epa", userDetailDefault.getName());
	}

	@Test
	public void setEmailTest() {
		userDetailDefault.setEmail("thamali@gmail.com");
		assertEquals("thamali@gmail.com", userDetailDefault.getEmail());
	}

	// @Test
	// public void setStationTest() {
	// userDetailDefault.setStation(10);
	// assertEquals(10, userDetailDefault.getStation());
	// }

	@Test
	public void setPhoneTest() {
		userDetailDefault.setPhone("0112054468");
		assertEquals("0112054468", userDetailDefault.getPhone());
	}

}
