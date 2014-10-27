package model.models;
import static org.junit.Assert.*;

import org.junit.Test;


public class StationTest {

	Station stationDefault=new Station();
	
	
	
	@Test
	public void getIDTest() {
		stationDefault.setID(3);
		assertEquals(3, stationDefault.getID());
	}
	
	@Test
	public void getNameTest() {
		stationDefault.setName("Colombo Fort");
		assertEquals("Colombo Fort",stationDefault.getName());
	}
	
	
	@Test
	public void setIDTest() {
		stationDefault.setID(2);
		assertEquals(2, stationDefault.getID());
	}
	
	@Test
	public void setNameTest() {
		stationDefault.setName("Gampaha");
		assertEquals("Gampaha",stationDefault.getName());
	}
	
	public void getCodeTest() {
		stationDefault.setName("110");
		assertEquals("110",stationDefault.getName());
	}

	public void setCodeTest(String code) {
		stationDefault.setName("115");
		assertEquals("115",stationDefault.getName());
	}

}
