package model.models;

/**
 * Entity class for station object
 * 
 * @author Dilanka1
 * 
 */

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
