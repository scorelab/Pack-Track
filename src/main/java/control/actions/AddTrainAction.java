//package control.actions;
//
//import java.util.List;
//import java.util.Map;
//
//import model.managers.DeviceManager;
//import model.managers.StationManager;
//import model.managers.TrainManager;
//import model.managers.UserManager;
//import model.models.Device;
//import model.models.Station;
//import model.models.Train;
//import model.models.User;
//
//import org.apache.struts2.convention.annotation.InterceptorRef;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
//import com.opensymphony.xwork2.validator.annotations.ValidatorType;
//
//@InterceptorRef(value = "secureStack")
//public class AddTrainAction extends ActionSupport implements SessionAware{
//
//	private Map<String, Object> session;
//	List<Station> stationList = new StationManager().getStationList();
//	private String name;
//	private int start;
//	private int end;
//
//	@org.apache.struts2.convention.annotation.Action(value = "add_train", results = {
//			@Result(name = "error", location = "login", type = "redirect"),
//			@Result(name = "done", location = "home", type = "redirect") })
//	public String createUser() throws Exception {
//
//		TrainManager tm = new TrainManager();
//		User user = (User) session.get("user");
//		if (user != null
//				&& (user.getUserPrivilege().isAdd_train() || user
//						.getUserPrivilege().isRemove_train())) {
//
//			String change = (String) session.get("change");
//
//			Train temp = new Train();
//			temp.setName(name);
//			
//			for (Station st : stationList) {
//				if (st.getID() == start) {
//					temp.setStart(st);
//					break;
//				}
//			}
//			
//			for (Station st : stationList) {
//				if (st.getID() == end) {
//					temp.setFinish(st);
//					break;
//				}
//			}
//			temp.setAddBy(user.getUserName());
//
//			if (change == null) {
//
//				if (tm.addTrain(temp)) {
//
//					session.put("message", "Train "+temp.getName()+" added successfully!");
//					return "done";
//				}
//			} else {
//				
//				temp.setID(Integer.parseInt(change));
//				if (tm.updateTrain(temp)) {
//					session.put("message", "Train "+temp.getName()+" updated successfully!");
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
//	@org.apache.struts2.convention.annotation.Action(value = "add-train-input", results = { @Result(name = "error", location = "login", type = "redirect") })
//	public String input() throws Exception {
//
//		UserManager uManager = new UserManager();
//		User user = (User) session.get("user");
//		if (user != null
//				&& (user.getUserPrivilege().isAdd_train() || user
//						.getUserPrivilege().isRemove_train())) {
//
//			return "add_train";
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
//	public List<Station> getStationList() {
//		return stationList;
//	}
//
//	public void setStationList(List<Station> stationList) {
//		this.stationList = stationList;
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
//	public int getStart() {
//		return start;
//	}
//
//	public void setStart(int start) {
//		this.start = start;
//	}
//
//	public int getEnd() {
//		return end;
//	}
//
//	public void setEnd(int end) {
//		this.end = end;
//	}
//}
