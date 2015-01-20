package control.actions;

import java.util.Map;

import model.managers.CategoryManager;
import model.managers.ParcelManager;
import model.models.Category;
import model.models.Customer;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import control.message.Email;
import control.message.SmsSender;

/**
 * Handles confirming of parcel arrivals to the station
 *
 */
@InterceptorRef(value = "secureStack")
public class ConfirmArrivalAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String pid;
	private String message;
	private String myStation;

	/**
	 * Handles confirm-arrival view
	 * @return redirect state
	 * @throws Exception
	 */
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
				Parcel parcel=pm.getParcel(Long.parseLong(pid));
				if(parcel.getDestination().getID()==parcel.getCurrentStation().getID()){
					Customer customer=parcel.getReceiver();
					if(!customer.getEmail().equals("")){
						Email.send("PackTrack","Your parcel has arrived it's destination",customer.getEmail());
					}
					if(!customer.getMobile().equals("")){
						String to="+94"+customer.getMobile().substring(1);
						SmsSender.snedSMS(to, "+19284517326", "Your parcel has arrived it's destination");
					}
				}
				return "done";
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * Input action confirm-arrival view
	 * @return redirect state
	 * @throws Exception
	 */
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
