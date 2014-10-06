package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.CategoryManager;
import model.managers.StationManager;
import model.models.Category;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class ChangeCategoryAction extends ActionSupport implements
		SessionAware, ServletRequestAware {

	private HttpServletRequest response;
	private Map<String, Object> session;
	private Category temp;

	@org.apache.struts2.convention.annotation.Action(value = "change_category", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String changeCategory() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_category()) {
			CategoryManager cm = new CategoryManager();
			String param = getServletRequest().getParameter("id");
			System.out.println(param);
			setTemp(cm.getCategory(Integer.parseInt(param)));
			System.out.println(getTemp().getCatName());
			if (getTemp() == null) {
				return "done";
			}
			session.put("change", param);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "delete_category", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "add-remove-category", type = "redirect") })
	public String deleteUser() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_category()) {
			CategoryManager cm = new CategoryManager();
			String param = getServletRequest().getParameter("id");
			System.out.println(param);
			if (cm.deleteCategory(Integer.parseInt(param), user.getUserName())) {
				session.put("message", "Category deleted successfully!");
				session.remove("change");
			}
			return "done";
		} else {
			return ERROR;
		}
	}

	public void setServletRequest(HttpServletRequest response) {
		this.response = response;
	}

	public HttpServletRequest getServletRequest() {
		return this.response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Category getTemp() {
		return temp;
	}

	public void setTemp(Category temp) {
		this.temp = temp;
	}
}
