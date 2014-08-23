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
	String email;
	String designation;
	String role;
	String shed;
	String sub_dept;
	String nic_number;
	int authLevel;
	int privilegeLevel;

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

	public String getSub_dept() {
		return sub_dept;
	}

	public void setSub_dept(String sub_dept) {
		this.sub_dept = sub_dept;
	}

	public String getNic_number() {
		return nic_number;
	}

	public void setNic_number(String nic_number) {
		this.nic_number = nic_number;
	}

	public int getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
	}

	public int getPrivilegeLevel() {
		return privilegeLevel;
	}

	public void setPrivilegeLevel(int privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
