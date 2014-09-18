package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.ParcelManager;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class ParcelAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String tableRows;
	private String options;
	
	
	@org.apache.struts2.convention.annotation.Action(value = "parcel-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveParcelAction() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_train()) {

			ParcelManager tm = new ParcelManager();
			List<Parcel> list = tm.getParcelList();
			StringBuilder sb = new StringBuilder();
			for (Parcel train : list) {
				String temp = "<tr><td>" 
						+ train.getID() 
						+ "</td><td>"
						+ train.getSender().getName()
						+ "</td><td>"
						+ train.getDestination().getName()
						+ "</td><td><button type='button' class='btn btn-default btn-s change_tr' name='"+train.getID()+"'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-s deletes_tr' name='"+train.getID()+"'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
}
