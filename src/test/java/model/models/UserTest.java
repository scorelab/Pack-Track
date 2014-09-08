package model.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
	
	UserPrivilege upParameter=new UserPrivilege();
	UserDetail udParameter=new UserDetail();
	UserPrivilege upDefault=new UserPrivilege();
	UserDetail udDefault=new UserDetail();
	
	User userDefault=new User(); //default constructor
	User userParameter=new User("Lahiru", "pass@123", "Station_Master", 
			"sm", "station", "travel", "911672375V", upParameter, "Rand", udParameter);
	
	@Test
	public void getUserNameTest() {
		assertEquals("Lahiru", userParameter.getUserName());
	}
	
	@Test
	public void getPasswordTest() {
		assertEquals("pass@123", userParameter.getPassword());
	}
	

	@Test
	public void getDesignationTest() {
		assertEquals("Station_Master", userParameter.getDesignation());
	}

	@Test
	public void getRoleTest() {
		assertEquals("sm", userParameter.getRole());
	}
	
	@Test
	public void getShedTest() {
		assertEquals("station", userParameter.getShed());
	}
	
	@Test
	public void getSubDeptTest() {
		assertEquals("travel", userParameter.getSubDept());
	}
	
	@Test
	public void getNicNumberTest() {
		assertEquals("911672375V", userParameter.getNicNumber());
	}
	
	@Test
	public void getUserPrivilegeTest() {
		assertEquals(upParameter, userParameter.getUserPrivilege());
	}
	
	@Test
	public void getAddByTest() {
		assertEquals("Rand", userParameter.getAddBy());
	}
	
	@Test
	public void getUserDetailTest() {
		assertEquals( udParameter, userParameter.getUserDetail());
	}
	
	@Test
	public void setUserNameTest() {
		userDefault.setUserName("Maneesha");
		assertEquals("Maneesha", userDefault.getUserName());
	}
	
	@Test
	public void setPasswordTest() {
		userDefault.setPassword("pass");
		assertEquals("pass", userDefault.getPassword());
	}
	

	@Test
	public void setDesignationTest() {
		userDefault.setDesignation("Data_Manager");
		assertEquals("Data_Manager", userDefault.getDesignation());
	}

	@Test
	public void setRoleTest() {
		userDefault.setRole("dm");
		assertEquals("dm", userDefault.getRole());
	}
	
	@Test
	public void setShedTest() {
		userDefault.setShed("train");
		assertEquals("train", userDefault.getShed());
	}
	
	@Test
	public void setSubDeptTest() {
		userDefault.setSubDept("parcel");
		assertEquals("parcel", userDefault.getSubDept());
	}
	
	@Test
	public void setNicNumberTest() {
		userDefault.setNicNumber("921672375V");
		assertEquals("921672375V", userDefault.getNicNumber());
	}
	
	@Test
	public void setUserPrivilegeTest() {
		userDefault.setUserPrivilege(upDefault);
		assertEquals( upDefault, userDefault.getUserPrivilege());
		assertEquals( userDefault, userDefault.getUserPrivilege().getUser());
	}
	
	@Test
	public void setAddByTest() {
		userDefault.setAddBy("Dilanka");
		assertEquals("Dilanka", userDefault.getAddBy());
	}
	
	@Test
	public void setUserDetailTest() {
		userDefault.setUserDetail(udDefault);
		assertEquals( udDefault, userDefault.getUserDetail());
		assertEquals( userDefault, userDefault.getUserDetail().getUser());
	}
	

}
