package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.CategoryManager;
import model.managers.ParcelManager;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value="secureStack")
public class ReleaseParcelAction extends ActionSupport implements SessionAware,ServletRequestAware{
	private HttpServletRequest reuest;
	private Map<String, Object> session;
	private String tableRows;
	private String message;

	@org.apache.struts2.convention.annotation.Action(value = "release-search", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String searchParcelAction() throws Exception {
		String param=getServletRequest().getParameter("searchText");
		User user = (User) session.get("user");
		ParcelManager pm=new ParcelManager();
		List<Parcel> list = pm.searchRealease(param, user.getUserDetail().getStation().getID());
		StringBuilder sb = new StringBuilder();
		for (Parcel parcels : list) {
			String temp = "<tr><td>" + parcels.getID()+ "</td><td>"
					+ parcels.getStarts().getName() + "</td><td>"
					+ parcels.getSender().getNic()  + "</td><td>"
					+ parcels.getSender().getName() + "</td><td>"
					+ parcels.getReceiver().getNic() + "</td><td>"
					+ parcels.getReceiver().getName() + "</td><td>"
					+ "<td><button type='button' class='btn btn-default btn-s release' name='"+parcels.getID()+"'><span class='glyphicon glyphicon-ok'></span> Release</button></td></tr>";
			sb.append(temp);
		}
		
		if(list.size()==0){
			String temp = "<tr><td>null</td><td>"
					+"null</td><td>"
					+"null</td><td>"
					+"null</td><td>"
					+"null</td><td>"
					+"null</td><td>"
					+"</td></tr>";
			sb.append(temp);
		}
		tableRows = sb.toString();
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value = "release", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "release-parcel", type = "redirect") })
	public String release() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRelease_parcel()) {
			ParcelManager pm=new ParcelManager();
			String param = getServletRequest().getParameter("id");
			System.out.println(param);
			if (pm.releaseParcel(Long.parseLong(param), user.getUserName())) {
				session.put("message", "Parcel released successfully!");
			}
			return "done";
		} else {
			return ERROR;
		}
	}
	
	@org.apache.struts2.convention.annotation.Action(value = "release-parcel", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveParcelAction() throws Exception {
		User user = (User) session.get("user");
		if (user != null
				&& (user.getUserPrivilege().isRelease_parcel())) {
			
			if(session.get("message")!=null){
				setMessage((String)session.get("message"));
				session.remove("message");
			}

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

	public void setServletRequest(HttpServletRequest reuest) {
		this.reuest = reuest;
	}

	public HttpServletRequest getServletRequest() {
		return this.reuest;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
