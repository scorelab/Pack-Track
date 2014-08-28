package model.models;

/**
 * Entity class for device object
 * 
 * @author Dilanka1
 * 
 */
public class Device {

	int ID;
	String IMEI;
	String Assigned;
	String addBy;

	public Device() {

	}

	public Device(int id, String imei, String name, String addby) {
		ID = id;
		IMEI = imei;
		Assigned = name;

		addBy = addby;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public String getAssigned() {
		return Assigned;
	}

	public void setAssigned(String assigned) {
		Assigned = assigned;
	}

	public String getAddBy() {
		return addBy;
	}

	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}

}
