package control.actions;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import model.managers.StationManager;
import model.managers.UserManager;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value="secureStack")
public class UserAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String tableRows;

	@org.apache.struts2.convention.annotation.Action(value = "add-user-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addUser() throws Exception {

		User user = (User) session.get("user");
		if (user!=null && user.getUserPrivilege().isAdd_user()) {

			UserManager um = new UserManager();
			List<User> list = um.getUserList();
			StringBuilder sb = new StringBuilder();
			for (User users : list) {
				String temp = "<tr><td>" + users.getUserDetail().getName()
						+ "</td><td>" + users.getUserName() + "</td><td>"
						+ users.getUserDetail().getEmail() + "</td><td>"
						+ users.getRole() + "</td><td>" + user.getNicNumber()
						+ "</td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@org.apache.struts2.convention.annotation.Action(value = "add-remove-user", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveUser() throws Exception {

		User user = (User) session.get("user");
		if (user!=null && user.getUserPrivilege().isRemove_user()) {

			UserManager um = new UserManager();
			List<User> list = um.getUserList();
			StringBuilder sb = new StringBuilder();
			for (User users : list) {
				String temp = "<tr><td>"
						+ users.getUserDetail().getName()
						+ "</td><td>"
						+ users.getUserName()
						+ "</td><td>"
						+ users.getUserDetail().getEmail()
						+ "</td><td>"
						+ users.getRole()
						+ "</td><td>"
						+ users.getNicNumber()
						+ "</td><td><button type='button' class='btn btn-default btn-lg change' name='"+users.getUserName()+"'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-lg deletes' name='"+users.getUserName()+"'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
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
