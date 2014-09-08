package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.StationManager;
import model.managers.TrainManager;
import model.models.Station;
import model.models.Train;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeTrainAction extends ActionSupport implements SessionAware,ServletRequestAware{
	
	private HttpServletRequest response;
	private Map<String, Object> session;
	private List<Station> stationList = new StationManager().getStationList();
	private Train temp;
	
	@org.apache.struts2.convention.annotation.Action(value = "change_train", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String changeUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_train()) {
			TrainManager sm = new TrainManager();
			String param = getServletRequest().getParameter("id");
			System.out.println(param);
			setTemp(sm.getTrain(Integer.parseInt(param)));
			System.out.println(getTemp().getName());
			if (getTemp() == null) {
				return "done";
			}
			session.put("change", param);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	@org.apache.struts2.convention.annotation.Action(value = "delete_train", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String deleteUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_train()) {
			TrainManager sm = new TrainManager();
			String param = getServletRequest().getParameter("id");
			if (sm.deleteTrain(Integer.parseInt(param), user.getUserName())) {
				session.put("message", "Train deleted successfully!");
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

	public Train getTemp() {
		return temp;
	}

	public void setTemp(Train temp) {
		this.temp = temp;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

}
