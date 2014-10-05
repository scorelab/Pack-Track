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

@InterceptorRef(value="secureStack")
public class NavbarAction extends ActionSupport implements SessionAware, ServletResponseAware{
	private Map<String, Object> session;
	private String items;
	private HttpServletResponse response;
	

	/**
	 * Method to generate tabs for user according to privileges
	 * @return
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "navbar", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String authCheck() throws Exception {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		
		UserManager uManager = new UserManager();
		User user = (User) session.get("user");

			StringBuilder sbTab = new StringBuilder();
			if (user.getUserPrivilege().isRemove_user()) {
				sbTab.append("<li id=\"users\"><a href=\"#\">Users<span class=\"fa arrow\"></span></a><ul class=\"nav nav-second-level\"><li><a href=\"add-user-home\" id=\"add-user-home\">User List</a></li><li><a href=\"add_user\" id=\"add_user\">Add User</a></li></ul></li>");

			} else if (user.getUserPrivilege().isAdd_user()) {
				sbTab.append("<li id=\"users\"><a href=\"#\">Users<span class=\"fa arrow\"></span></a><ul class=\"nav nav-second-level\"><li><a href=\"add-user-home\" id=\"add-user-home\">User List</a></li><li><a href=\"add_user\" id=\"add_user\">Add User</a></li></ul></li>");
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
			
			if (user.getUserPrivilege().isAdd_parcel() || user.getUserPrivilege().isRelease_parcel() || user.getUserPrivilege().isSelect_train()) {
				sbTab.append("<li><a href=\"#home\" data-url=\"parcel-home\">Parcel</a></li>");

			}
			
			int index = sbTab.indexOf("i");
			setItems(sbTab.toString());
			return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getItems() {
		return items;
	}

	public void setItems(String tabs) {
		this.items = tabs;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}

}
