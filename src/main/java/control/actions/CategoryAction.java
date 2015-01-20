package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.CategoryManager;
import model.managers.UserManager;
import model.models.Category;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handles category lists
 *
 */
@InterceptorRef(value = "secureStack")
public class CategoryAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String tableRows;
	private String message;

	/**
	 * Generates category list for add-category-home view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "add-category-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addCategory() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_category()) {

			if (session.get("message") != null) {
				setMessage((String) session.get("message"));
				session.remove("message");
			}

			CategoryManager um = new CategoryManager();
			List<Category> list = um.getCategoryList();
			StringBuilder sb = new StringBuilder();
			for (Category category : list) {
				String temp = "<tr><td>" + category.getCatName() + "</td><td>"
						+ category.getUnitCost() + "</td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	/**
	 * Generates category list with buttons for add-remove-category view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "add-remove-category", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveCategory() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_category()) {

			if (session.get("message") != null) {
				setMessage((String) session.get("message"));
				session.remove("message");
			}

			CategoryManager um = new CategoryManager();
			List<Category> list = um.getCategoryList();
			StringBuilder sb = new StringBuilder();
			for (Category category : list) {
				String temp = "<tr><td>"
						+ category.getCatName()
						+ "</td><td>"
						+ category.getUnitCost()
						+ "</td><td><button type='button' class='btn btn-default btn-s change_ca' name='"
						+ category.getID()
						+ "'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-s deletes_ca' name='"
						+ category.getID()
						+ "'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
