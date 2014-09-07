package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.StationManager;
import model.managers.UserManager;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value="secureStack")
public class AddUserAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	List<Station> stationList= new StationManager().getStationList();
	private String name;
	private String userName;
	private String nic;
	private String email;
	private String designation;
	private String phone;
	private String role;
	private String shed;
	private String sub_dept;
	private int station;
	private boolean add_user;
	private boolean remove_user;
	private boolean add_train;
	private boolean remove_train;
	private boolean add_station;
	private boolean remove_station;
	private boolean add_category;
	private boolean remove_category;
	private boolean add_device;
	private boolean remove_device;

	@org.apache.struts2.convention.annotation.Action(value = "add_user", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String createUser() throws Exception {

		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password"))
				&& user != null
				&& user.getUserPrivilege().isAdd_user()) {

			if (uManager.isUser(userName)) {
				addFieldError("userName", "UserName already exist");
			}

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "add-user-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password"))
				&& user != null
				&& user.getUserPrivilege().isAdd_user()) {

			return "add_user";
		} else {
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public String getName() {
		return name;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Name cannot be empty")
	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "UserName cannot be empty")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNic() {
		return nic;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "NIC cannot be empty")
	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Email cannot be empty")
	@EmailValidator(type = ValidatorType.FIELD, message = "Not a valid email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getShed() {
		return shed;
	}

	public void setShed(String shed) {
		this.shed = shed;
	}

	public String getSub_dept() {
		return sub_dept;
	}

	public void setSub_dept(String sub_dept) {
		this.sub_dept = sub_dept;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public boolean isAdd_user() {
		return add_user;
	}

	public void setAdd_user(boolean add_user) {
		this.add_user = add_user;
	}

	public boolean isRemove_user() {
		return remove_user;
	}

	public void setRemove_user(boolean remove_user) {
		this.remove_user = remove_user;
	}

	public boolean isAdd_train() {
		return add_train;
	}

	public void setAdd_train(boolean add_train) {
		this.add_train = add_train;
	}

	public boolean isRemove_train() {
		return remove_train;
	}

	public void setRemove_train(boolean remove_train) {
		this.remove_train = remove_train;
	}

	public boolean isAdd_station() {
		return add_station;
	}

	public void setAdd_station(boolean add_station) {
		this.add_station = add_station;
	}

	public boolean isRemove_station() {
		return remove_station;
	}

	public void setRemove_station(boolean remove_station) {
		this.remove_station = remove_station;
	}

	public boolean isAdd_category() {
		return add_category;
	}

	public void setAdd_category(boolean add_category) {
		this.add_category = add_category;
	}

	public boolean isRemove_category() {
		return remove_category;
	}

	public void setRemove_category(boolean remove_category) {
		this.remove_category = remove_category;
	}

	public boolean isAdd_device() {
		return add_device;
	}

	public void setAdd_device(boolean add_device) {
		this.add_device = add_device;
	}

	public boolean isRemove_device() {
		return remove_device;
	}

	public void setRemove_device(boolean remove_device) {
		this.remove_device = remove_device;
	}

}