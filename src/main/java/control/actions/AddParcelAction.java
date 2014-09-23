package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.CategoryManager;
import model.managers.DeviceManager;
import model.managers.StationManager;
import model.models.Category;
import model.models.Device;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class AddParcelAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	List<Station> stationList = new StationManager().getStationList();
	List<Category> categoryList = new CategoryManager().getCategoryList();
	private String senderNIC;
	private String recieverNIC;
	private int start;
	private int destination;
	private float weight;
	private float cost;
	private boolean express;
	private int category;
	
	@org.apache.struts2.convention.annotation.Action(value = "add_parcel", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String createUser() throws Exception {

		DeviceManager dm = new DeviceManager();
		User user = (User) session.get("user");
		start=user.getUserDetail().getStation().getID();
		if (user != null
				&& (user.getUserPrivilege().isAdd_parcel() || user
						.getUserPrivilege().isRemove_device())) {

		} else {
			return ERROR;
		}
		return SUCCESS;
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
	public void setSenderNIC(String senderNIC) {
		this.senderNIC = senderNIC;
	}
	public String getRecieverNIC() {
		return recieverNIC;
	}
	public void setRecieverNIC(String recieverNIC) {
		this.recieverNIC = recieverNIC;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
}
