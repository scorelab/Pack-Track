package model.models;

/**
 * Entity class for user object
 * 
 * @author Dilanka1
 * 
 */
public class User {
	String userName;
	String password;
	String designation;
	String role;
	String shed;
	String subDept;
	String nicNumber;
	UserPrivilege userPrivilege;
	String addBy;
	UserDetail userDetail;

	public User() {
		super();
		this.userPrivilege = new UserPrivilege();
	}

	public User(String userName, String password, String designation,
			String role, String shed, String subDept, String nicNumber,
			UserPrivilege userPrivilege, String addBy, UserDetail userDetail) {
		super();
		this.userName = userName;
		this.password = password;
		this.designation = designation;
		this.role = role;
		this.shed = shed;
		this.subDept = subDept;
		this.nicNumber = nicNumber;
		this.userPrivilege = userPrivilege;
		this.addBy = addBy;
		this.userDetail = userDetail;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getShed() {
		return shed;
	}

	public void setShed(String shed) {
		this.shed = shed;
	}

	public String getSubDept() {
		return subDept;
	}

	public void setSubDept(String sub_dept) {
		this.subDept = sub_dept;
	}

	public String getNicNumber() {
		return nicNumber;
	}

	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
	}

	public UserPrivilege getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(UserPrivilege userPrivilege) {
		this.userPrivilege = userPrivilege;
		userPrivilege.setUser(this);
	}

	public String getAddBy() {
		return addBy;
	}

	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
		userDetail.setUser(this);
	}

}
