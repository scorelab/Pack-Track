package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.ParcelManager;
import model.managers.UserManager;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class ParcelAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private HttpServletRequest response;
	private Map<String, Object> session;
	private String tableRows;

	@org.apache.struts2.convention.annotation.Action(value = "parcel-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveParcelAction() throws Exception {
		return SUCCESS;
	}

	@org.apache.struts2.convention.annotation.Action(value = "parcel-search", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String searchParcelAction() throws Exception {
		String param = getServletRequest().getParameter("searchText");
		ParcelManager pm = new ParcelManager();
		List<Parcel> list = pm.search(param);
		StringBuilder sb = new StringBuilder();
		for (Parcel parcels : list) {
			String temp = "<tr><td>" + parcels.getID() + "</td><td>"
					+ parcels.getStarts().getName() + "</td><td>"
					+ parcels.getDestination().getName() + "</td><td>"
					+ parcels.getSender().getNic() + "</td><td>"
					+ parcels.getReceiver().getNic() + "</td><td>"
					+ parcels.getCurrentStation().getName() + "</td><td>"
					+ parcels.isReleased() + "</td><td>" + "</td></tr>";
			sb.append(temp);
		}
		tableRows = sb.toString();
		return SUCCESS;
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

	public void setServletRequest(HttpServletRequest response) {
		this.response = response;
	}

	public HttpServletRequest getServletRequest() {
		return this.response;
	}
}
