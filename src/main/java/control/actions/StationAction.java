//package control.actions;
//
//import java.util.List;
//import java.util.Map;
//
//import model.managers.StationManager;
//import model.managers.UserManager;
//import model.models.Station;
//import model.models.User;
//
//import org.apache.struts2.convention.annotation.InterceptorRef;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//@InterceptorRef(value="secureStack")
//public class StationAction extends ActionSupport implements SessionAware {
//
//	private Map<String, Object> session;
//	private String tableRows;
//
//	@org.apache.struts2.convention.annotation.Action(value = "add-station-home", results = { @Result(name = "error", location = "login", type = "redirect") })
//	public String AddStation() throws Exception {
//
//		User user = (User) session.get("user");
//		if (user != null && user.getUserPrivilege().isAdd_station()) {
//
//			StationManager sm = new StationManager();
//			List<Station> list = sm.getStationList();
//			StringBuilder sb = new StringBuilder();
//			for (Station stations : list) {
//				String temp = "<tr><td>"
//						+ stations.getName()
//						+ "</td><td>"
//						+ stations.getContactNum()
//						+ "</td></tr>";
//				sb.append(temp);
//			}
//			tableRows = sb.toString();
//			return SUCCESS;
//		} else {
//			return ERROR;
//		}
//
//	}
//	
//	@org.apache.struts2.convention.annotation.Action(value = "add-remove-station", results = { @Result(name = "error", location = "login", type = "redirect") })
//	public String addRemoveStation() throws Exception {
//
//		User user = (User) session.get("user");
//		if (user != null && user.getUserPrivilege().isRemove_station()) {
//
//			StationManager sm = new StationManager();
//			List<Station> list = sm.getStationList();
//			StringBuilder sb = new StringBuilder();
//			for (Station stations : list) {
//				String temp = "<tr><td>"
//						+ stations.getName()
//						+ "</td><td>"
//						+ stations.getContactNum()
//						+ "</td><td><button type='button' class='btn btn-default btn-s change_st' name='"+stations.getID()+"'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-s deletes_st' name='"+stations.getID()+"'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
//				sb.append(temp);
//			}
//			tableRows = sb.toString();
//			return SUCCESS;
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
//	public String getTableRows() {
//		return tableRows;
//	}
//
//	public void setTableRows(String tableRows) {
//		this.tableRows = tableRows;
//	}
//
//}
