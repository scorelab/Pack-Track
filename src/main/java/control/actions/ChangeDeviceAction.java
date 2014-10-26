package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.DeviceManager;
import model.managers.UserManager;
import model.models.Device;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeDeviceAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private HttpServletRequest response;
	private Map<String, Object> session;
	private List<User> userList = new UserManager().getUserList();
	private Device temp;

	@org.apache.struts2.convention.annotation.Action(value = "change_device", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String changeUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_device()) {
			DeviceManager dm = new DeviceManager();
			String param = getServletRequest().getParameter("id");

			setTemp(dm.getDevice(Integer.parseInt(param)));

			if (getTemp() == null) {
				return "done";
			}
			session.put("change", param);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "delete_device", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "add-remove-device", type = "redirect") })
	public String deleteUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_device()) {
			DeviceManager sm = new DeviceManager();
			String param = getServletRequest().getParameter("id");
			if (sm.deleteDevice(Integer.parseInt(param), user.getUserName())) {
				session.put("message", "Device deleted successfully!");
				session.remove("change");
			}
			return "done";
		} else {
			return ERROR;
		}
	}

	public void setServletRequest(HttpServletRequest response) {
		this.response = response;
	}

	public HttpServletRequest getServletRequest() {
		return this.response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Device getTemp() {
		return temp;
	}

	public void setTemp(Device temp) {
		this.temp = temp;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
