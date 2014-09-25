package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.CustomerManager;
import model.managers.DeviceManager;
import model.models.Customer;
import model.models.Device;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class GetCustomerAction extends ActionSupport implements SessionAware, ServletRequestAware{

	private Map<String, Object> session;
	private HttpServletRequest response;
	private String data;
	private Customer receiver;
	private Customer sender;
	
	@org.apache.struts2.convention.annotation.Action(value = "get_receiver", results = {
			@Result(name = "error", location = "login", type = "redirect")})
	public String getReceiverDetail() throws Exception {

		User user = (User) session.get("user");
		if (user != null
				&& (user.getUserPrivilege().isAdd_parcel())) {
			String param= getServletRequest().getParameter("receiver_nic");
			System.out.println(param);
			CustomerManager cm=new CustomerManager();
			receiver=cm.getCustomer(param);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	@org.apache.struts2.convention.annotation.Action(value = "get_sender", results = {
			@Result(name = "error", location = "login", type = "redirect")})
	public String getSenderDetail() throws Exception {

		User user = (User) session.get("user");
		if (user != null
				&& (user.getUserPrivilege().isAdd_parcel())) {
			String param= getServletRequest().getParameter("sender_nic");
			System.out.println(param);
			CustomerManager cm=new CustomerManager();
			sender=cm.getCustomer(param);
			return SUCCESS;
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

	public void setServletRequest(HttpServletRequest response) {
		this.response = response;
	}

	public HttpServletRequest getServletRequest() {
		return this.response;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setReceiver(Customer customer) {
		this.receiver = customer;
	}

	public Customer getReceiver() {
		return receiver;
	}

	public Customer getSender() {
		return sender;
	}

	public void setSender(Customer sender) {
		this.sender = sender;
	}
}
