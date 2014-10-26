package control.actions;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import model.db.SHACheckSum;
import model.managers.UserManager;
import model.models.User;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import control.message.Email;

public class ForgotPasswordAction extends ActionSupport implements
		SessionAware, ServletResponseAware {

	private Map<String, Object> session;
	private HttpServletResponse response;
	private String email;

	@org.apache.struts2.convention.annotation.Action(value = "forgot-password", results = { @Result(name = "done", location = "reset-pass", type = "redirect") })
	public String execute() throws Exception {

		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		UserManager um = new UserManager();
		User user = um.getUserByEmail(email);
		if (user == null) {
			addFieldError("email", "Email does not exist in Pack Track");
			return SUCCESS;
		} else {
			char[] chars = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()1234567890"
					.toCharArray();
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 8; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			SHACheckSum shaCheckSum = new SHACheckSum(sb.toString());
			String password = null;
			try {
				password = shaCheckSum.getEncrValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setPassword(password);

			if (um.updateUser(user)) {
				Email.send("PackTrack Account",
						"Hi,\n Your password has reset.\nYour user name at PackTrack is : "
								+ user.getUserName()
								+ "\n Your new password is : " + sb.toString(),
						email);
			}
		}
		return "done";

	}

	@org.apache.struts2.convention.annotation.Action(value = "forgot-password-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		return "forgot-password";

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getServletResponse() {
		return this.response;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Enter email")
	@EmailValidator(type = ValidatorType.FIELD, message = "Not a valid email")
	public void setEmail(String email) {
		this.email = email;
	}
}
