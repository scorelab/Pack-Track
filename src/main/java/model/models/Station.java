package model.models;

/**
 * Entity class for station object
 * 
 * @author Dilanka1
 * 
 */

public class Station {
	String ID;
	String name;
	String contactNum;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
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

}
