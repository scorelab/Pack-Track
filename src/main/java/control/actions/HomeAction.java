package control.actions;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import model.managers.ParcelManager;
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
@InterceptorRef(value = "secureStack")
public class HomeAction extends ActionSupport implements SessionAware,
		ServletResponseAware {

	private Map<String, Object> session;
	private int toHandle;
	private int recieved;
	private HttpServletResponse response;
	private String message;

	/**
	 * Method to generate details on home screen
	 * 
	 * @return
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String authCheck() throws Exception {
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		ParcelManager pm = new ParcelManager();
		User user = (User) session.get("user");
		toHandle = pm.getToBeHandled(user.getUserDetail().getStation().getID());
		recieved = pm.getRecieved(user.getUserDetail().getStation().getID(),
				new Date());

		if (session.get("message") != null) {
			message = (String) session.get("message");
			session.remove("message");
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getToHandle() {
		return toHandle;
	}

	public void setToHandle(int toHandle) {
		this.toHandle = toHandle;
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

	public int getRecieved() {
		return recieved;
	}

	public void setRecieved(int recieved) {
		this.recieved = recieved;
	}
}
