package control.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.managers.ParcelManager;
import model.managers.StationManager;
import model.managers.TrainManager;
import model.models.Parcel;
import model.models.Station;
import model.models.Train;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import org.json.*;

@InterceptorRef(value = "secureStack")
public class SelectTrainAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private Map<String, Object> session;
	private List<Train> trainList = new TrainManager().getTrainList();
	private String myStation;
	private String pList;
	private HttpServletRequest request;
	private String message;

	@org.apache.struts2.convention.annotation.Action(value = "select-train", results = {
			@Result(name = "error", location = "login", type = "redirect"),
			@Result(name = "done", location = "home", type = "redirect"),
			@Result(name = "change", location = "add-remove-user", type = "redirect") })
	public String selectTrain() throws Exception {
		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isSelect_train()) {
			
			if(session.get("message")!=null){
				setMessage((String)session.get("message"));
				session.remove("message");
			}
			myStation = user.getUserDetail().getStation().getName();

			ParcelManager pm = new ParcelManager();
			List<Parcel> list = pm.getParcelsToSelectTrain(user.getUserDetail()
					.getStation().getID());
			StringBuilder sb = new StringBuilder();
			for (Parcel parcels : list) {
				String temp = "<tr><td><input type='checkbox' id='"
						+ parcels.getID() + "'/></td><td>" + parcels.getID()
						+ "</td><td>" + parcels.getDestination().getName()
						+ "</td><td>" + parcels.isExpress() + "</td><td>"
						+ "</td></tr>";
				sb.append(temp);
			}
			pList = sb.toString();

			String jsonList = request.getParameter("parcels");
			String train = request.getParameter("train");
			if (jsonList != null) {
				JSONArray parcelArray = new JSONArray(jsonList);
				int len = parcelArray.length();
				for(int x=0;x<len;x++){
					pm.selectTrain(train, parcelArray.getInt(x));
				}
				session.put("message", "Train selected successfully!");
				return "done";
			}
			return SUCCESS;
		} else {
			return "error";
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public List<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(List<Train> trainList) {
		this.trainList = trainList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getMyStation() {
		return myStation;
	}

	public void setMyStation(String myStation) {
		this.myStation = myStation;
	}

	public String getPList() {
		return pList;
	}

	public void setPList(String list) {
		this.pList = list;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
