package model.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeviceTest {
	
	User user1=new User();
	User user2=new User();
	
	Device deviceDefault=new Device(); //default constructor
	Device deviceParameter=new Device(1,"100100", user1 ,"Rand");

	@Test
	public void getIDTest() {
		assertEquals(1,deviceParameter.getID());
	}
	
	@Test
	public void getIMEITest() {
		assertEquals("100100",deviceParameter.getIMEI());
	}
	
	@Test
	public void getAssignedTest() {
		assertEquals(user1 ,deviceParameter.getAssigned());
	}
	
	@Test
	public void getAddByTest() {
		assertEquals("Rand",deviceParameter.getAddBy());
	}
	
	@Test
	public void setIDTest() {
		deviceDefault.setID(2);
		assertEquals(2,deviceDefault.getID());
	}
	
	@Test
	public void setIMEITest() {
		deviceDefault.setIMEI("200200");;
		assertEquals("200200",deviceDefault.getIMEI());
	}
	
	@Test
	public void setAssignedTest() {
		deviceDefault.setAssigned(user2);;
		assertEquals(user2,deviceDefault.getAssigned());
	}
	
	@Test
	public void setAddByTest() {
		deviceDefault.setAddBy("Kotiya");;
		assertEquals("Kotiya",deviceDefault.getAddBy());
	}

}
