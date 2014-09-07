package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action to manage user home screen
 *
 */
@InterceptorRef(value="secureStack")
public class HomeAction extends ActionSupport implements SessionAware, ServletResponseAware {

	private Map<String, Object> session;
	private String tabs;
	private HttpServletResponse response;
	private String message;
	

	/**
	 * Method to generate tabs for user according to privileges
	 * @return
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String authCheck() throws Exception {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		
		UserManager uManager = new UserManager();
		User user = (User) session.get("user");

			StringBuilder sbTab = new StringBuilder();
			if (user.getUserPrivilege().isRemove_user()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-remove-user\">Users</a></li>");

			} else if (user.getUserPrivilege().isAdd_user()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-user-home\">Users</a></li>");
			}

			if (user.getUserPrivilege().isRemove_train()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-remove-train\">Trains</a></li>");

			} else if (user.getUserPrivilege().isAdd_train()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-train-home\">Trains</a></li>");
			}
			
			if (user.getUserPrivilege().isRemove_station()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-remove-station\">Stations</a></li>");

			} else if (user.getUserPrivilege().isAdd_station()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-station-home\">Stations</a></li>");
			}
			
			if (user.getUserPrivilege().isRemove_device()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-remove-device\">Device</a></li>");

			} else if (user.getUserPrivilege().isAdd_device()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-device-home\">Device</a></li>");
			}
			
			if (user.getUserPrivilege().isRemove_category()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-remove-category\">Categories</a></li>");

			} else if (user.getUserPrivilege().isAdd_category()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"add-category-home\">Categories</a></li>");
			}
			
			int index = sbTab.indexOf("i");
			sbTab.insert(index + 1, " class=\"active\"");
			setTabs(sbTab.toString());
			
			if(session.get("message")!=null){
				message=(String)session.get("message");
				session.remove("message");
			}
			
			return SUCCESS;
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

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
