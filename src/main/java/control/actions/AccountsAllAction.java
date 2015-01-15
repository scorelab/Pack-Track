package control.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.managers.ParcelManager;
import model.models.Parcel;
import model.models.User;
import model.util.ValidationUtil;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class AccountsAllAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String year;

	@org.apache.struts2.convention.annotation.Action(value = "accounts-all", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String getReport() throws Exception {
		if (!ValidationUtil.isNumeric(year)) {
			addFieldError("year", "Year is numeric");
			return SUCCESS;
		}
		int yearInt = Integer.parseInt(year);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int todayYear = cal.get(Calendar.YEAR);
		System.out.println(todayYear);
		if (yearInt < 2014 || yearInt > todayYear) {
			addFieldError("year", "Not a valid year");
			return SUCCESS;
		}
		ParcelManager pm=new ParcelManager();
		pm.getIncomeMonth(yearInt);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	@org.apache.struts2.convention.annotation.Action(value = "accounts-all-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		User user = (User) session.get("user");
		if (user != null
				&& user.getUserPrivilege().isAccounts()) {
			
			return "accounts-all";
		} else {
			return ERROR;
		}

	}
}