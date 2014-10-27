package model.models;
import static org.junit.Assert.*;
import model.models.Train;

import org.junit.Test;


public class TrainTest {
	
	//Station station1=new Station();
	//Station station2=new Station();
	
	Train train=new Train();
	
	@Test
	public void setTrain_numTest() {
		train.setTrain_num("1");
		assertEquals("1", train.getTrain_num());
	}
	
	@Test
	public void getTrain_numTest() {
		train.setTrain_num("2");
		assertEquals("2", train.getTrain_num());
	}
	
	@Test
	public void setTrain_nameTest() {
		train.setTrain_name("Podi Manike");
		assertEquals("Podi Manike", train.getTrain_name());
	}
	
	@Test
	public void getTrain_nameTest() {
		train.setTrain_name("Podi Manike");
		assertEquals("Podi Manike", train.getTrain_name());
	}
	
	@Test
	public void setStart_stationTest() {
		train.setStart_station("Kandy");
		assertEquals("Kandy", train.getStart_station());
	}
	
	@Test
	public void getStart_stationTest() {
		train.setStart_station("Kandy");
		assertEquals("Kandy", train.getStart_station());
	}
	
	@Test
	public void setDestinationTest() {
		train.setDestination("Colombo");
		assertEquals("Colombo", train.getDestination());
	}
	
	@Test
	public void getDestinationTest() {
		train.setDestination("Colombo");
		assertEquals("Colombo", train.getDestination());
	}
	
	@Test
	public void setTrain_typeTest() {
		train.setTrain_type("Express");
		assertEquals("Express", train.getTrain_type());
	}
	
	@Test
	public void getTrain_typeTest() {
		train.setTrain_type("Express");
		assertEquals("Express", train.getTrain_type());
	}
	
	@Test
	public void setTrain_runTest() {
		train.setTrain_run("High");
		assertEquals("High", train.getTrain_run());
	}
	
	@Test
	public void getTrain_runTest() {
		train.setTrain_run("High");
		assertEquals("High", train.getTrain_run());
	}
	
	@Test
	public void setTrain_directionTest() {
		train.setTrain_direction("Hill Country");
		assertEquals("Hill Country", train.getTrain_direction());
	}
	
	@Test
	public void getTrain_directionTest() {
		train.setTrain_direction("Hill Country");
		assertEquals("Hill Country", train.getTrain_direction());
	}
	

}
