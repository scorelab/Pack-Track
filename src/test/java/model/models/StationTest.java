package model.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class StationTest {

	Station stationDefault = new Station();
	Station stationParameter = new Station(1, "Colombo_Fort", "0112054468",
			"Rand");

	public class Station {
		int ID;
		String name;
		String contactNum;
		String addBy;

		public Station() {

		}

		public Station(int id, String Name, String contactnum, String addby) {
			ID = id;
			name = Name;
			contactNum = contactnum;
			addBy = addby;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContactNum() {
			return contactNum;
		}

		public void setContactNum(String contactNum) {
			this.contactNum = contactNum;
		}

		public String getAddBy() {
			return addBy;
		}

		public void setAddBy(String addBy) {
			this.addBy = addBy;
		}

	}

	@Test
	public void getIDTest() {
		assertEquals(1, stationParameter.getID());
	}

	@Test
	public void getNameTest() {
		assertEquals("Colombo_Fort", stationParameter.getName());
	}

	@Test
	public void getContactNumTest() {
		assertEquals("0112054468", stationParameter.getContactNum());
	}

	@Test
	public void getAddByTest() {
		assertEquals("Rand", stationParameter.getAddBy());
	}

	@Test
	public void setIDTest() {
		stationDefault.setID(2);
		assertEquals(2, stationDefault.getID());
	}

	@Test
	public void setNameTest() {
		stationDefault.setName("Gampaha");
		assertEquals("Gampaha", stationDefault.getName());
	}

	@Test
	public void setContactNumTest() {
		stationDefault.setContactNum("0112789789");
		assertEquals("0112789789", stationDefault.getContactNum());
	}

	@Test
	public void setAddByTest() {
		stationDefault.setAddBy("Lahiru");
		;
		assertEquals("Lahiru", stationDefault.getAddBy());
	}

}
