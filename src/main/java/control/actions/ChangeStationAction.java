//package control.actions;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import model.managers.StationManager;
//import model.managers.UserManager;
//import model.models.Station;
//import model.models.User;
//
//import org.apache.struts2.convention.annotation.InterceptorRef;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.interceptor.ServletRequestAware;
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//@InterceptorRef(value = "secureStack")
//public class ChangeStationAction extends ActionSupport implements SessionAware,
//ServletRequestAware{
//	
//	private HttpServletRequest response;
//	private Map<String, Object> session;
//	private Station temp;
//	
//	@org.apache.struts2.convention.annotation.Action(value = "change_station", results = {
//			@Result(name = "error", location = "login", type = "redirect"),
//			@Result(name = "done", location = "home", type = "redirect") })
//	public String changeUser() throws Exception {
//		User user = (User) session.get("user");
//		if (user != null && user.getUserPrivilege().isRemove_station()) {
//			StationManager sm = new StationManager();
//			String param = getServletRequest().getParameter("id");
//			System.out.println(param);
//			setTemp(sm.getStation(Integer.parseInt(param)));
//			System.out.println(getTemp().getName());
//			if (getTemp() == null) {
//				return "done";
//			}
//			session.put("change", param);
//			return SUCCESS;
//		} else {
//			return ERROR;
//		}
//	}
//	
//	@org.apache.struts2.convention.annotation.Action(value = "delete_station", results = {
//			@Result(name = "error", location = "login", type = "redirect"),
//			@Result(name = "done", location = "home", type = "redirect") })
//	public String deleteUser() throws Exception {
//		User user = (User) session.get("user");
//		if (user != null && user.getUserPrivilege().isRemove_station()) {
//			StationManager sm = new StationManager();
//			String param = getServletRequest().getParameter("id");
//			if (sm.deleteStation(Integer.parseInt(param), user.getUserName())) {
//				session.put("message", "Station deleted successfully!");
//				session.remove("change");
//			}
//			return "done";
//		} else {
//			return ERROR;
//		}
//	}
//	
//	public void setServletRequest(HttpServletRequest response) {
//		this.response = response;
//	}
//
//	public HttpServletRequest getServletRequest() {
//		return this.response;
//	}
//
//	@Override
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//
//	}
//
//	public Station getTemp() {
//		return temp;
//	}
//
//	public void setTemp(Station temp) {
//		this.temp = temp;
//	}
//
//}
