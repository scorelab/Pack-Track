package control.interceptors;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import model.managers.UserManager;
import model.models.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();
		UserManager uManager = new UserManager();
		User user = (User) session.get("user");
		if (uManager.loginCheck((String) session.get("userName"),
				(String) session.get("password")) && user != null) {
			return actionInvocation.invoke();
		} else {
			return "error";
		}

	}

}
