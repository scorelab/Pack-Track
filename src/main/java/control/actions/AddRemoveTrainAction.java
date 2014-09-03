package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddRemoveTrainAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String tableRows;

	@org.apache.struts2.convention.annotation.Action(value = "add-remove-train", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String execute() throws Exception {

		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password"))
				&& user != null
				&& user.getUserPrivilege().isRemove_train()) {

			UserManager um = new UserManager();
			List<User> list = um.getUserList();
			StringBuilder sb = new StringBuilder();
			for (User users : list) {
				String temp = "<tr><td>"
						+ user.getUserDetail().getName()
						+ "</td><td>"
						+ user.getUserName()
						+ "</td><td>"
						+ user.getUserDetail().getEmail()
						+ "</td><td>"
						+ user.getRole()
						+ "</td><td>"
						+ user.getNicNumber()
						+ "</td><td><button type='button' class='btn btn-default btn-lg'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-lg'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
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

}
