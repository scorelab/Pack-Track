package control.actions;

import java.util.Map;

import model.managers.UserManager;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	@org.apache.struts2.convention.annotation.Action(value = "home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String execute() throws Exception {

		UserManager uManager = new UserManager();

		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password"))) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
