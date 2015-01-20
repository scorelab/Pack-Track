package control.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.managers.ParcelManager;
import model.managers.StationManager;
import model.models.Station;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * Gets income of a station in a given time period
 *
 */
@InterceptorRef(value = "secureStack")
public class AccountTimePeriodAction extends ActionSupport implements
		SessionAware {

	private Map<String, Object> session;
	private List<Station> stationList = new StationManager().getStationList();
	private int station;
	private String startDate;
	private String endDate;
	private int startYear;
	private int endYear;
	private String stName;
	private float income;

	/**
	 * Handles account-time-period view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "account-time-period", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String getReport() throws Exception {
		startYear = Integer.parseInt(startDate.substring(startDate
				.lastIndexOf("/") + 1));
		endYear = Integer
				.parseInt(endDate.substring(endDate.lastIndexOf("/") + 1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int todayYear = cal.get(Calendar.YEAR);

		if (startYear < 2014 || startYear > todayYear) {
			addFieldError("startDate", "Not a valid year");
			return SUCCESS;
		}
		if (endYear < 2014 || endYear > todayYear) {
			addFieldError("endDate", "Not a valid year");
			return SUCCESS;
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = df.parse(startDate);
		Date d2 = df.parse(endDate);

		if (d1.after(d2)) {
			addFieldError("startDate", "Start date should come before end date");
			return SUCCESS;
		}

		ParcelManager pm = new ParcelManager();
		income = pm
				.getIncome(d1.getTime() / 1000, d2.getTime() / 1000, station);

		for (Station st : stationList) {
			if (st.getID() == station) {
				stName = st.getName();
			}
		}
		return SUCCESS;
	}

	/**
	 * Input action for account-time-period view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "account-time-period-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAccounts()) {

			return "account-time-period";
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

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStartDate() {
		return startDate;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Date cannot be empty")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Date cannot be empty")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}
}
