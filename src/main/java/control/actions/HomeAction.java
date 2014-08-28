package control.actions;

import java.util.Map;

import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String tabs;

	@org.apache.struts2.convention.annotation.Action(value = "home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String execute() throws Exception {

		UserManager uManager = new UserManager();
		User user=(User) session.get("user");
		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password")) && user!=null) {

			StringBuilder sbTab=new StringBuilder();
			if(user.getUserPrivilege().isAdd_user()){
				sbTab.append("<li><a href=\"#home\" data-url=\"add-user-home\">User</a></li>");
				
			}else if(user.getUserPrivilege().isRemove_User()){
				
			}
			int index=sbTab.indexOf("i");
			sbTab.insert(index+1, " class=\"active\"");
			setTabs(sbTab.toString());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getTabs() {
		return tabs;
	}

	public void setTabs(String tabs) {
		this.tabs = tabs;
	}

}
