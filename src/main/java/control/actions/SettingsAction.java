package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import model.db.SHACheckSum;
import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef(value="secureStack")
public class SettingsAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private String current;
	private String newP;
	private String repeat;
	
	@org.apache.struts2.convention.annotation.Action(value = "settings", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect") })
	public String execute() throws Exception {
		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		SHACheckSum shaCheckSum = new SHACheckSum(current);
		String password = null;
		try {
			password = shaCheckSum.getEncrValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!user.getPassword().equals(password)){
			addFieldError("current", "Invalid password");
			return SUCCESS;
		}
		if(!newP.equals(repeat)){
			addFieldError("newP", "Passwords do not match");
			return SUCCESS;
		}
		SHACheckSum newShaCheckSum = new SHACheckSum(newP);
		try {
			password = newShaCheckSum.getEncrValue();
			user.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uManager.updateUser(user)) {
			session.put("message", "Your password updated successfully!");
			session.put("user", user);
			session.put("password", user.getPassword());
			return "done";
		}
		return SUCCESS;
	}
	
	@org.apache.struts2.convention.annotation.Action(value = "settings-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {
			
		return "settings";
		
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


	public String getCurrent() {
		return current;
	}


	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Invalid password")
	public void setCurrent(String current) {
		this.current = current;
	}


	public String getNewP() {
		return newP;
	}


	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Invalid password")
	public void setNewP(String newP) {
		this.newP = newP;
	}


	public String getRepeat() {
		return repeat;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Invalid password")
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

}
