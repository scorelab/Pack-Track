package control.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;

import model.managers.DeviceManager;
import model.managers.ParcelManager;
import model.managers.UserManager;
import model.models.Device;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success", type = "json")
@ParentPackage("json-default")
public class TrackParcelFullAction extends ActionSupport implements
		ServletRequestAware {

	private HttpServletRequest request;
	private Parcel parcel;

	@org.apache.struts2.convention.annotation.Action(value = "track-master", results = { @Result(name = "success", type = "json") })
	public String execute() {
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String imei = request.getParameter("imei");
		ParcelManager pm = new ParcelManager();
		UserManager um = new UserManager();
		DeviceManager dm = new DeviceManager();
		User user = um.login(userName, password);
		Device device = dm.getDeviceByIMEI(imei);

		if (user == null || device == null) {
			return "success";
		} else if (!user.getUserName().equals(
				device.getAssigned().getUserName())) {
			return "success";
		}

		if (id != null && !id.equals("")) {
			setParcel(pm.getParcel(Long.parseLong(id)));
		}
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}
}
