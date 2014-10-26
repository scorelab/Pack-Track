package model.models;

import static org.junit.Assert.*;
import model.models.Train;

import org.junit.Test;

public class TrainTest {

	Station station1 = new Station();
	Station station2 = new Station();

	Train trainDefault = new Train();
	Train trainParameter = new Train(1, "Podi_Manike", "Rand", station1,
			station2);

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
		assertEquals(station1, trainParameter.getStart());
	}

	@Test
	public void getFinishTest() {
		assertEquals(station2, trainParameter.getFinish());
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
		trainDefault.setName("Udarata_Manike");
		;
		assertEquals("Udarata_Manike", trainDefault.getName());
	}

	@Test
	public void setStartTest() {
		trainDefault.setStart(station2);
		;
		assertEquals(station2, trainDefault.getStart());
	}

	@Test
	public void setFinishTest() {
		trainDefault.setFinish(station1);
		;
		assertEquals(station1, trainDefault.getFinish());
	}

	@Test
	public void setAddByTest() {
		trainDefault.setAddBy("Prabodha");
		;
		assertEquals("Prabodha", trainDefault.getAddBy());
	}

}
