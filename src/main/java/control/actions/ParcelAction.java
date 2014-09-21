package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.ParcelManager;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class ParcelAction extends ActionSupport implements SessionAware,ServletRequestAware {

	private HttpServletRequest response;
	private Map<String, Object> session;
	private String tableRows;
	private String options;

	@org.apache.struts2.convention.annotation.Action(value = "parcel-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveParcelAction() throws Exception {

		User user = (User) session.get("user");
		StringBuilder sb = new StringBuilder();
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {
			sb.append("<a href='add-station-input' class='btn btn-default btn-s' style='margin-right: 10px;'><span class='glyphicon glyphicon-plus-sign'></span> Add Parcel </a>");
		}
		if (user != null && user.getUserPrivilege().isSelect_train()) {
			sb.append("<a href='add-station-input' class='btn btn-default btn-s'><span class='glyphicon glyphicon-tag'></span> Assign Train </a>");
		}
		if (user == null
				&& (user.getUserPrivilege().isSelect_train() || user
						.getUserPrivilege().isAdd_parcel())) {
			return ERROR;
		}
		options = sb.toString();
		return SUCCESS;
	}

	@org.apache.struts2.convention.annotation.Action(value = "parcel-search", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String searchParcelAction() throws Exception {
		System.out.println(getServletRequest().getParameter("name"));
		
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	public void setServletRequest(HttpServletRequest response) {
		this.response = response;
	}

	public HttpServletRequest getServletRequest() {
		return this.response;
	}
}
