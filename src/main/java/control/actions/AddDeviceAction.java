package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.DeviceManager;
import model.managers.StationManager;
import model.managers.UserManager;
import model.models.Device;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value = "secureStack")
public class AddDeviceAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private List<User> userList = new UserManager().getUserList();
	private String IMEI;
	private String assigned;
	private String message;

	@org.apache.struts2.convention.annotation.Action(value = "add_device", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "add-device-input", type = "redirect"),
			@Result(name = "change", location = "add-remove-device", type = "redirect") })
	public String createUser() throws Exception {

		DeviceManager dm = new DeviceManager();
		User user = (User) session.get("user");
		if (user != null
				&& (user.getUserPrivilege().isAdd_device() || user
						.getUserPrivilege().isRemove_device())) {

			String change = (String) session.get("change");

			Device temp = new Device();
			if(IMEI.equals("")){
				addFieldError("IMEI", "IMEI cannot be null");
				return SUCCESS;
			}
			temp.setIMEI(IMEI);
			for (User u : userList) {
				if (u.getUserName().equals(assigned)) {
					temp.setAssigned(u);
					break;
				}
			}
			temp.setAddBy(user.getUserName());

			if (change == null) {

				if (dm.addDevice(temp)) {

					session.put("message", "Device added successfully!");
					return "done";
				}
			} else {
				
				temp.setID(Integer.parseInt(change));
				if (dm.updateDevice(temp)) {
					session.put("message", "Device updated successfully!");
					session.remove("change");
					return "change";
				}
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "add-device-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		if (user != null
				&& (user.getUserPrivilege().isAdd_device() || user
						.getUserPrivilege().isRemove_device())) {
			
			if(session.get("message")!=null){
				setMessage((String)session.get("message"));
				session.remove("message");
			}

			return "add_device";
		} else {
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String IMEI) {
		this.IMEI = IMEI;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
