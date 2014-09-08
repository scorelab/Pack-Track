package model.models;
import static org.junit.Assert.*;
import model.models.Train;

import org.junit.Test;


public class TrainTest {
	
	Train trainDefault=new Train();
	Train trainParameter=new Train(1, "Podi_Manike", "Rand", 1, 10);

	@Test
	public void getIDTest() {
		assertEquals(1, trainParameter.getID());
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Podi_Manike", trainParameter.getName());
	}
	
	@Test
	public void getStartTest() {
		assertEquals(1, trainParameter.getStart());
	}
	
	@Test
	public void getFinishTest() {
		assertEquals(10, trainParameter.getFinish());
	}
	
	@Test
	public void getAddByTest() {
		assertEquals("Rand", trainParameter.getAddBy());
	}
	
	@Test
	public void setIDTest() {
		trainDefault.setID(2);
		assertEquals(2, trainDefault.getID());
	}
	
	@Test
	public void setNameTest() {
		trainDefault.setName("Udarata_Manike");;
		assertEquals("Udarata_Manike", trainDefault.getName());
	}
	
	@Test
	public void setStartTest() {
		trainDefault.setStart(5);;
		assertEquals(5, trainDefault.getStart());
	}
	
	@Test
	public void setFinishTest() {
		trainDefault.setFinish(20);;
		assertEquals(20, trainDefault.getFinish());
	}
	
	@Test
	public void setAddByTest() {
		trainDefault.setAddBy("Prabodha");;
		assertEquals("Prabodha", trainDefault.getAddBy());
	}

}
