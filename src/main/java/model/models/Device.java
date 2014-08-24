package model.models;

/**
 * Entity class for device object
 * 
 * @author Dilanka1
 * 
 */
public class Device {

	String IMEI;
	User Assigned;

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public User getAssigned() {
		return Assigned;
	}

	public void setAssigned(User assigned) {
		Assigned = assigned;
	}

}
