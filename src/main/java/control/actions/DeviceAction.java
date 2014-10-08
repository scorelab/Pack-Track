package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.DeviceManager;
import model.managers.UserManager;
import model.models.Device;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value="secureStack")
public class DeviceAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String tableRows;
	private String message;

	@org.apache.struts2.convention.annotation.Action(value = "add-device-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addDevice() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_device()) {
			
			if(session.get("message")!=null){
				setMessage((String)session.get("message"));
				session.remove("message");
			}

			DeviceManager dm = new DeviceManager();
			List<Device> list = dm.getDeviceList();
			StringBuilder sb = new StringBuilder();
			for (Device device : list) {
				String temp = "<tr><td>" + device.getIMEI()
						+ "</td><td>" + device.getAssigned().getUserName()
						+ "</td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	
	@org.apache.struts2.convention.annotation.Action(value = "add-remove-device", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveDevice() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_device()) {
			
			if(session.get("message")!=null){
				setMessage((String)session.get("message"));
				session.remove("message");
			}

			DeviceManager dm = new DeviceManager();
			List<Device> list = dm.getDeviceList();
			StringBuilder sb = new StringBuilder();
			for (Device device : list) {
				String temp = "<tr><td>" + device.getIMEI()
						+ "</td><td>" + device.getAssigned().getUserName()
						+ "</td><td><button type='button' class='btn btn-default btn-s change_di' name='"+device.getID()+"'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-s deletes_di' name='"+device.getID()+"'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getTableRows() {
		return tableRows;
	}

	public void setTableRows(String tableRows) {
		this.tableRows = tableRows;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
