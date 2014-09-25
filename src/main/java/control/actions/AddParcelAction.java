package control.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import model.managers.CategoryManager;
import model.managers.CustomerManager;
import model.managers.DeviceManager;
import model.managers.ParcelManager;
import model.managers.StationManager;
import model.models.Category;
import model.models.Customer;
import model.models.Device;
import model.models.Parcel;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value = "secureStack")
public class AddParcelAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	List<Station> stationList = new StationManager().getStationList();
	List<Category> categoryList = new CategoryManager().getCategoryList();
	private String senderNIC;
	private String receiverNIC;
	private int start;
	private int destination;
	private float weight;
	private float cost;
	private boolean express;
	private float category;
	private String receiver_name;

	@org.apache.struts2.convention.annotation.Action(value = "add_parcel", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String createUser() throws Exception {

		DeviceManager dm = new DeviceManager();
		User user = (User) session.get("user");
		start = user.getUserDetail().getStation().getID();
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {
			CustomerManager cm = new CustomerManager();
			Customer sender = cm.getCustomer(senderNIC);
			Customer receiver = cm.getCustomer(receiverNIC);
			System.out.println(category);
			if (sender == null && receiver == null) {
				System.out.println(1);
				return "add-sender-receiver-parcel";
			} else if (sender == null) {
				System.out.println(2);
				return "add-sender-parcel";
			} else if (receiver == null) {
				System.out.println(3);
				return "add-receiver-parcel";
			}

			Parcel parcel = new Parcel();
			ParcelManager pm = new ParcelManager();
			parcel.setReceiver(receiver);
			parcel.setSender(sender);
			for (Station st : stationList) {
				if (st.getID() == start) {
					parcel.setStarts(st);
					parcel.setCurrentStation(st);
					break;
				}
			}
			for (Station st : stationList) {
				if (st.getID() == destination) {
					parcel.setDestination(st);
					break;
				}
			}
			parcel.setWeight(weight);
			parcel.setExpress(express);
			parcel.setAddBy(user.getUserName());
			parcel.setDateRecieved( (new Date().getTime())/1000);

			cost = category * 5 * weight;
			parcel.setTotalCost(cost);
			if (pm.addParcel(parcel)) {

				session.put("message", "Parcel added successfully!");
				return "done";
			}

		} else {
			return ERROR;
		}
		return SUCCESS;
	}

	@org.apache.struts2.convention.annotation.Action(value = "add_parcel-input", results = {
			@Result(name = "error", location = "login", type = "redirect")})
	public String input() throws Exception {

		DeviceManager dm = new DeviceManager();
		User user = (User) session.get("user");
		start=user.getUserDetail().getStation().getID();
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {
			return "add_parcel";
		}else{
			return ERROR;
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public String getSenderNIC() {
		return senderNIC;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Sender NIC cannot be empty")
	public void setSenderNIC(String senderNIC) {
		this.senderNIC = senderNIC;
	}

	public String getReceiverNIC() {
		return receiverNIC;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Reciever NIC cannot be empty")
	public void setReceiverNIC(String recieverNIC) {
		this.receiverNIC = recieverNIC;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isExpress() {
		return express;
	}

	public void setExpress(boolean express) {
		this.express = express;
	}

	public float getCategory() {
		return category;
	}

	public void setCategory(float category) {
		this.category = category;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	// @RequiredStringValidator(type = ValidatorType.FIELD, message =
	// "Name cannot be empty")
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

}
