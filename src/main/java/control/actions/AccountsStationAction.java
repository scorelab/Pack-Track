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
 * Gets income of a station for specific day
 *
 */
@InterceptorRef(value = "secureStack")
public class AccountsStationAction extends ActionSupport implements
		SessionAware {

	private Map<String, Object> session;
	private List<Station> stationList = new StationManager().getStationList();
	private int station;
	private String date;
	private float dayIncome[];
	private float[] incomeMonth;
	private int year;
	private String stName;

	/**
	 * Handles accounts-station view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "accounts-station", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String getReport() throws Exception {
		year = Integer.parseInt(date.substring(date.lastIndexOf("/") + 1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int todayYear = cal.get(Calendar.YEAR);
		if (year < 2014 || year > todayYear) {
			addFieldError("date", "Not a valid year");
			return SUCCESS;
		}
		ParcelManager pm = new ParcelManager();
		setDayIncome(pm.getIncomeStation(station, date));
		setIncomeMonth(pm.getIncomeMonth(getYear(), station));
		for (Station st : stationList) {
			if (st.getID() == station) {
				stName = st.getName();
			}
		}
		return SUCCESS;
	}

	/**
	 * Input action for accounts-station view
	 * @return redirect state
	 * @throws Exception
	 */
	@org.apache.struts2.convention.annotation.Action(value = "accounts-station-input", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String input() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAccounts()) {

			return "accounts-station";
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

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Date cannot be empty")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public float[] getDayIncome() {
		return dayIncome;
	}

	public void setDayIncome(float dayIncome[]) {
		this.dayIncome = dayIncome;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float[] getIncomeMonth() {
		return incomeMonth;
	}

	public void setIncomeMonth(float[] incomeMonth) {
		this.incomeMonth = incomeMonth;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}
}
