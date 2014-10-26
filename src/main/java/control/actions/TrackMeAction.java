package control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.managers.ParcelManager;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TrackMeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String res;
	private String id;
	private String nic;

	@org.apache.struts2.convention.annotation.Action(value = "track-me")
	public String changeUser() throws Exception {

		ParcelManager pm = new ParcelManager();
		String temp = pm.trackParcel(Long.parseLong(getId()), getNic());

		if (temp == null) {
			res = "Invalid details";
		} else if (pm.getParcel(Long.parseLong(getId())).getDestination()
				.getName().equals(temp)) {
			res = "Your package is at it's destination<b>(" + temp
					+ ")</b>. Please pick it from there.";
		} else {
			res = "Your package is at <b>" + temp + "</b>";
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
}
