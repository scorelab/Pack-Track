package control.actions;

import model.managers.UserManager;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{

	private String userName;
	private String password;
	private String status;
	@Override
	public String execute() throws Exception {
		UserManager uManager=new UserManager();
		if(uManager.login(userName, password)){
			setStatus("pass");
		}else {
			setStatus("fail");
		}
		return SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
