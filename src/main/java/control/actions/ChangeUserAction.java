package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.StationManager;
import model.managers.UserManager;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class ChangeUserAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private HttpServletRequest response;
	private Map<String, Object> session;
	List<Station> stationList = new StationManager().getStationList();
	private User temp;

	public void setsId(int sId) {
		sId = sId;
	}

	public HttpServletRequest getResponse() {
		return response;
	}

	public void setResponse(HttpServletRequest response) {
		this.response = response;
	}

	public User getTemp() {
		return temp;
	}

	public void setTemp(User temp) {
		this.temp = temp;
	}

	@org.apache.struts2.convention.annotation.Action(value = "change_user", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String changeUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_user()) {
			UserManager um = new UserManager();
			String param = getServletRequest().getParameter("userName");
			temp = um.getUser(param);
			if (temp == null) {
				return "done";
			}
			session.put("change", temp.getPassword());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "delete_user", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String deleteUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_user()) {
			UserManager um = new UserManager();
			String param = getServletRequest().getParameter("id");
			if (um.deleteUser(param, user.getUserName())) {
				session.put("message", param
						+ " deleted successfully!");
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

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

}
