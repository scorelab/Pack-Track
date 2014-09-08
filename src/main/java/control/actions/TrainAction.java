package control.actions;

import java.util.List;
import java.util.Map;

import model.managers.TrainManager;
import model.managers.UserManager;
import model.models.Train;
import model.models.User;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "secureStack")
public class TrainAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String tableRows;

	@org.apache.struts2.convention.annotation.Action(value = "add-train-home", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addTrain() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isAdd_train()) {

			TrainManager tm = new TrainManager();
			List<Train> list = tm.getTrainList();
			StringBuilder sb = new StringBuilder();
			for (Train train : list) {
				String temp = "<tr><td>" 
						+ train.getName() 
						+ "</td><td>"
						+ train.getStart().getName()
						+ "</td><td>"
						+ train.getFinish().getName()
						+ "</td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@org.apache.struts2.convention.annotation.Action(value = "add-remove-train", results = { @Result(name = "error", location = "login", type = "redirect") })
	public String addRemoveTrainAction() throws Exception {

		User user = (User) session.get("user");
		if (user != null && user.getUserPrivilege().isRemove_train()) {

			TrainManager tm = new TrainManager();
			List<Train> list = tm.getTrainList();
			StringBuilder sb = new StringBuilder();
			for (Train train : list) {
				String temp = "<tr><td>" 
						+ train.getName() 
						+ "</td><td>"
						+ train.getStart().getName()
						+ "</td><td>"
						+ train.getFinish().getName()
						+ "</td><td><button type='button' class='btn btn-default btn-s change_tr' name='"+train.getID()+"'><span class='glyphicon glyphicon-pencil'></span> Change</button></td><td><button type='button' class='btn btn-default btn-s deletes_tr' name='"+train.getID()+"'><span class='glyphicon glyphicon-trash'></span> Delete</button></td></tr>";
				sb.append(temp);
			}
			tableRows = sb.toString();
			return SUCCESS;
		} else {
			return ERROR;
		}

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
