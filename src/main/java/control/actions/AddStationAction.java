//package control.actions;
//
//import java.util.Map;
//import java.util.Random;
//
//import model.db.SHACheckSum;
//import model.managers.StationManager;
//import model.managers.UserManager;
//import model.models.Station;
//import model.models.User;
//import model.models.UserDetail;
//import model.models.UserPrivilege;
//
//import org.apache.struts2.convention.annotation.InterceptorRef;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
//import com.opensymphony.xwork2.validator.annotations.ValidatorType;
//
//import control.message.Email;
//
//@InterceptorRef(value = "secureStack")
//public class AddStationAction extends ActionSupport implements SessionAware {
//
//	private Map<String, Object> session;
//	private String name;
//	private String contactNum;
//
//	@org.apache.struts2.convention.annotation.Action(value = "add_station", results = {
//			@Result(name = "error", location = "login", type = "redirect"),
//			@Result(name = "done", location = "home", type = "redirect") })
//	public String createUser() throws Exception {
//
//		StationManager sm = new StationManager();
//		User user = (User) session.get("user");
//		if (user != null
//				&& (user.getUserPrivilege().isAdd_station() || user
//						.getUserPrivilege().isRemove_station())) {
//
//			String change = (String) session.get("change");
//
//			Station temp = new Station();
//			temp.setName(name);
//			temp.setContactNum(contactNum);
//			temp.setAddBy(user.getUserName());
//
//			if (change == null) {
//
//				if (sm.addStation(temp)) {
//
//					session.put("message", "Station " + temp.getName()
//							+ " added successfully!");
//					return "done";
//				}
//			} else {
//				
//				temp.setID(Integer.parseInt(change));
//				if (sm.updateStation(temp)) {
//					session.put("message", "Station " + temp.getName()
//							+ " updated successfully!");
//					session.remove("change");
//					return "done";
//				}
//			}
//			return SUCCESS;
//		} else {
//			return ERROR;
//		}
//	}
//
//	@org.apache.struts2.convention.annotation.Action(value = "add-station-input", results = { @Result(name = "error", location = "login", type = "redirect") })
//	public String input() throws Exception {
//
//		UserManager uManager = new UserManager();
//		User user = (User) session.get("user");
//		if (user != null
//				&& (user.getUserPrivilege().isAdd_station() || user
//						.getUserPrivilege().isRemove_station())) {
//
//			return "add_station";
//		} else {
//			return ERROR;
//		}
//
//	}
//
//	@Override
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Name cannot be empty")
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getContactNum() {
//		return contactNum;
//	}
//
//	public void setContactNum(String contactNum) {
//		this.contactNum = contactNum;
//	}
//
// }
