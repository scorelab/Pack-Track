package model.models;
import static org.junit.Assert.*;
import model.models.Train;

import org.junit.Test;


public class TrainTest {
	
	Station station1=new Station();
	Station station2=new Station();
	
	Train train=new Train();
	//Train trainParameter=new Train(1, "Podi_Manike", "Rand", station1, station2);
	
	@Test
	public String getTrain_num() {
		return train_num;
	}
	public void setTrain_num(String train_num) {
		this.train_num = train_num;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getStart_station() {
		return start_station;
	}
	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTrain_type() {
		return train_type;
	}
	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}
	public String getTrain_run() {
		return train_run;
	}
	public void setTrain_run(String train_run) {
		this.train_run = train_run;
	}
	public String getTrain_direction() {
		return train_direction;
	}
	public void setTrain_direction(String train_direction) {
		this.train_direction = train_direction;
	}

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
		trainDefault.setName("Udarata_Manike");;
		assertEquals("Udarata_Manike", trainDefault.getName());
	}
	
	@Test
	public void setStartTest() {
		trainDefault.setStart(station2);;
		assertEquals(station2, trainDefault.getStart());
	}
	
	@Test
	public void setFinishTest() {
		trainDefault.setFinish(station1);;
		assertEquals(station1, trainDefault.getFinish());
	}
	
	@Test
	public void setAddByTest() {
		trainDefault.setAddBy("Prabodha");;
		assertEquals("Prabodha", trainDefault.getAddBy());
	}

}
