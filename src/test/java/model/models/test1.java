package model.models;
import static org.junit.Assert.*;
import model.models.Station;

import org.junit.Test;


public class test1 {//example test class
	
	Station s=new Station(1,"Colombo","0112054468","Rand"); //create object

	@Test
	public void getIDTest() {
		Station s=new Station(1,"Colombo","0112054468","Rand");
		
		//call the methods and check the result
		assertEquals(1,s.getID()); //assertEquals(exceptResult, acctualResult)
		
	}
	
	@Test
	public void setIDTest(){
		s.setID(2);
		assertEquals(2,s.getID());
		
	}
	

}
