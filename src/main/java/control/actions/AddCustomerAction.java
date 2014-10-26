package control.actions;

import java.util.Map;

import model.managers.CustomerManager;
import model.managers.DeviceManager;
import model.models.Customer;
import model.models.Device;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value = "secureStack")
public class AddCustomerAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String name;
	private String email;
	private String mobile;
	private String telephone;
	private String address;
	private String nic;
	private String addBy;

	@org.apache.struts2.convention.annotation.Action(value = "add_customer", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "add_parcel-input", type = "redirect") })
	public String createUser() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {

			CustomerManager cm = new CustomerManager();
			Customer customer = new Customer();
			customer.setNic(nic);
			customer.setName(name);
			customer.setMobile(mobile);
			customer.setTelephone(telephone);
			if (!email.equals("")) {
				customer.setEmail(email);
			} else {
				customer.setEmail(null);
			}
			customer.setAddBy(user.getUserName());
			if (cm.addCustomer(customer)) {
				session.put("message", "Customer " + customer.getName()
						+ " added successfully!");
				return "done";
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@org.apache.struts2.convention.annotation.Action(value = "add_customer-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		if (session.get("sender") != null) {
			nic = (String) session.get("sender");
		}
		if (session.get("receiver") != null) {
			nic = (String) session.get("receiver");
		}
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_parcel()) {
			return "add_customer";
		} else {
			return ERROR;
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Customer name cannot be empty")
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@EmailValidator(type = ValidatorType.FIELD, message = "Not a valid email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNic() {
		return nic;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Customer NIC cannot be empty")
	public void setNic(String nic) {
		this.nic = nic;
	}

}
