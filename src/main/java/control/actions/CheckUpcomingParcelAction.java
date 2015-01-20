package control.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import model.managers.ParcelManager;
import model.models.Parcel;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class CheckUpcomingParcelAction extends ActionSupport implements
		SessionAware {

	private Map<String, Object> session;
	private String tableRows;

	@org.apache.struts2.convention.annotation.Action(value = "check-upcoming", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String getUpcoming() throws Exception {
		ParcelManager pm = new ParcelManager();
		User user = (User) session.get("user");
		List<Parcel> list = pm.getPendingParcelList(user.getUserDetail()
				.getStation());
		StringBuilder sb = new StringBuilder();
		Date date = new Date();
		for (Parcel parcels : list) {
			if (parcels.getDateRecieved() < date.getTime()/1000
					- (1000 * 60 * 60 * 24 * 2)) {
				sb.append("<tr class='danger'>");
			} else if (parcels.getDateRecieved() < date.getTime()/1000
					- (1000 * 60 * 60 * 24)) {
				sb.append("<tr class='warning'>");
			} else {
				sb.append("<tr>");
			}
			String temp = "<td>" + parcels.getID() + "</td><td>"
					+ parcels.getStarts().getName() + "</td><td>"
					+ parcels.getDestination().getName() + "</td><td>"
					+ parcels.getSender().getNic() + "</td><td>"
					+ parcels.getReceiver().getNic() + "</td><td>"
					+ parcels.getCurrentStation().getName() + "</td><td>"
					+ parcels.isReleased() + "</td><td>" + "</td></tr>";
			sb.append(temp);
		}
		if (list.size() == 0) {
			String temp = "<tr><td>null</td><td>" + "null</td><td>"
					+ "null</td><td>" + "null</td><td>" + "null</td><td>"
					+ "null</td><td>" + "</td></tr>";
			sb.append(temp);
		}
		tableRows = sb.toString();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getTableRows() {
		return tableRows;
	}

	public void setTableRows(String tableRows) {
		this.tableRows = tableRows;
	}
}