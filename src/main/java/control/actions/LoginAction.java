package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action that manages login page
 * 
 */
public class LoginAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	private String userName;
	private String password;
	private Map<String, Object> session;
	private HttpServletRequest request;

	/**
	 * Method to log in the user in to the system by checking credentials.
	 * 
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "login", results = {
			@Result(name = "done", location = "home", type = "redirect"),
			@Result(name = "error", location = "login", type = "redirect") })
	public String login() throws Exception {

		if (userName != null) {
			UserManager uManager = new UserManager();
			User user;
			if ((user = uManager.login(userName, password)) != null) {
				session.put("userName", user.getUserName());
				session.put("password", user.getPassword());
				session.put("user", user);
				return "done";
			} else {
				session.put("status", false);
				return ERROR;
			}
		}

		if (session.get("status") != null) {
			addFieldError("userName", "UserName or password is incorrect");
			session.clear();
		}

		return SUCCESS;
	}

	/**
	 * Method to log out the user from system.
	 * 
	 * @return redirect state
	 */
	@org.apache.struts2.convention.annotation.Action(value = "logout", results = { @Result(name = "success", location = "index", type = "redirect") })
	public String logout() {

		session.clear();
		request.getSession().invalidate();
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

	@Override
	public void setServletRequest(HttpServletRequest reuqest) {
		this.request = reuqest;

	}

}
