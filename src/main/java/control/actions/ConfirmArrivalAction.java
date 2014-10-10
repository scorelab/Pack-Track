package control.actions;

import java.util.Map;

import model.managers.CategoryManager;
import model.managers.ParcelManager;
import model.models.Category;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value = "secureStack")
public class ConfirmArrivalAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String pid;
	private String message;
	private String myStation;

	@org.apache.struts2.convention.annotation.Action(value = "confirm-arrival", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "confirm-arrival-input", type = "redirect"),
			@Result(name = "change", location = "confirm-arrival", type = "redirect") })
	public String createUser() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {
			setMyStation(user.getUserDetail().getStation().getName());
			ParcelManager pm = new ParcelManager();
			if (pid != null) {
				if (pid.equals("")) {
					addFieldError("pid", "Parcel ID cannot be empty");
					return SUCCESS;
				}
				try {
					Long.parseLong(pid);
				} catch (NumberFormatException e) {
					addFieldError("pid", "Parcel ID is integer only");
					return SUCCESS;
				}
				if (!pm.getParcelsToConfirm(Long.parseLong(pid))) {
					addFieldError("pid", "Parcel ID is not valid");
					return SUCCESS;
				}
			}
			if (pm.confirmArrival(user.getUserDetail().getStation().getID(),
					Long.parseLong(pid))) {
				session.put("message", "Arrival confirmed successfully!");
				return "done";
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "confirm-arrival-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {

			setMyStation(user.getUserDetail().getStation().getName());

			if (session.get("message") != null) {
				setMessage((String) session.get("message"));
				session.remove("message");
			}

			return "confirm-arrival";
		} else {
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return pid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMyStation() {
		return myStation;
	}

	public void setMyStation(String myStation) {
		this.myStation = myStation;
	}

}
