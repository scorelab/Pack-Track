package control.actions;

import java.util.Map;

import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String userName;
	private String password;
	private Map<String, Object> session;

	@Override
	@org.apache.struts2.convention.annotation.Action(value = "login", results = {
			@Result(name = "done", location = "home", type = "redirect"),
			@Result(name = "error", location = "login", type = "redirect") })
	public String execute() throws Exception {
		
		if (userName != null) {
			UserManager uManager = new UserManager();
			User user;
			if ((user = uManager.login(userName, password)) != null) {
				System.out.println(user.getUserName());
				session.put("userName", user.getUserName());
				session.put("password", user.getPassword());
				session.put("authLevel", user.getAuthLevel());
				session.put("privilegeLevel", user.getPrivilegeLevel());
				return "done";
			} else {
				session.put("status", false);
				return ERROR;
			}
		}
		
		if (session.get("status") != null) {
			System.out.println("fail");
			addFieldError("userName", "UserName or password is incorrect");
			session.clear();
		}
		
		return SUCCESS;
	}

	@org.apache.struts2.convention.annotation.Action(value = "logout", results = { @Result(name = "success", location = "index", type = "redirect") })
	public String logout() {
		
		session.clear();
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
