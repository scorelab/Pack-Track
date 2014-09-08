package model.models;

/**
 * Entity class for device object
 * 
 * @author Dilanka1
 * 
 */
public class Device {

	private int ID;
	private String IMEI;
	private User assigned;
	private String addBy;

	public Device() {

	}

	public Device(int id, String imei, User name, String addby) {
		this.ID = id;
		this.IMEI = imei;
		this.assigned = name;
		this.addBy = addby;
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

	public User getAssigned() {
		return assigned;
	}

	public void setAssigned(User assigned) {
		this.assigned = assigned;
	}

	public String getAddBy() {
		return addBy;
	}

	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}

}
