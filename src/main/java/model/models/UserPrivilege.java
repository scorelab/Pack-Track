package model.models;

public class UserPrivilege {
	String userName;
	User user;
	boolean add_user;
	boolean remove_user;
	boolean add_station;
	boolean remove_station;
	boolean add_train;
	boolean remove_train;
	boolean add_category;
	boolean remove_category;
	boolean add_customer;
	boolean remove_customer;
	boolean add_parcel;
	boolean release_parcel;
	boolean confirm_arrival;
	boolean check_upcoming_parcel;
	boolean select_train;
	boolean add_device;
	boolean remove_device;
	
	public UserPrivilege() {
		super();
	}

	public UserPrivilege(User user, String userName, boolean add_user,
			boolean remove_User, boolean add_station, boolean remove_station,
			boolean add_train, boolean remove_train, boolean add_category,
			boolean remove_category, boolean add_customer,
			boolean remove_customer, boolean add_parcel,
			boolean release_parcel, boolean confirm_arrival,
			boolean check_upcoming_parcel, boolean select_train, boolean add_device, boolean remove_device) {
		super();
		this.add_user = add_user;
		this.remove_user = remove_User;
		this.add_station = add_station;
		this.remove_station = remove_station;
		this.add_train = add_train;
		this.remove_train = remove_train;
		this.add_category = add_category;
		this.remove_category = remove_category;
		this.add_customer = add_customer;
		this.remove_customer = remove_customer;
		this.add_parcel = add_parcel;
		this.release_parcel = release_parcel;
		this.confirm_arrival = confirm_arrival;
		this.check_upcoming_parcel = check_upcoming_parcel;
		this.select_train = select_train;
		this.user=user;
		this.userName=userName;
		this.add_device=add_device;
		this.remove_device=remove_device;
	}

	public boolean isAdd_user() {
		return add_user;
	}

	public void setAdd_user(boolean add_user) {
		this.add_user = add_user;
	}

	public boolean isRemove_user() {
		return remove_user;
	}

	public void setRemove_user(boolean remove_user) {
		this.remove_user = remove_user;
	}

	public boolean isAdd_station() {
		return add_station;
	}

	public void setAdd_station(boolean add_station) {
		this.add_station = add_station;
	}

	public boolean isRemove_station() {
		return remove_station;
	}

	public void setRemove_station(boolean remove_station) {
		this.remove_station = remove_station;
	}

	public boolean isAdd_train() {
		return add_train;
	}

	public void setAdd_train(boolean add_train) {
		this.add_train = add_train;
	}

	public boolean isRemove_train() {
		return remove_train;
	}

	public void setRemove_train(boolean remove_train) {
		this.remove_train = remove_train;
	}

	public boolean isAdd_category() {
		return add_category;
	}

	public void setAdd_category(boolean add_category) {
		this.add_category = add_category;
	}

	public boolean isRemove_category() {
		return remove_category;
	}

	public void setRemove_category(boolean remove_category) {
		this.remove_category = remove_category;
	}

	public boolean isAdd_customer() {
		return add_customer;
	}

	public void setAdd_customer(boolean add_customer) {
		this.add_customer = add_customer;
	}

	public boolean isRemove_customer() {
		return remove_customer;
	}

	public void setRemove_customer(boolean remove_customer) {
		this.remove_customer = remove_customer;
	}

	public boolean isAdd_parcel() {
		return add_parcel;
	}

	public void setAdd_parcel(boolean add_parcel) {
		this.add_parcel = add_parcel;
	}

	public boolean isRelease_parcel() {
		return release_parcel;
	}

	public void setRelease_parcel(boolean release_parcel) {
		this.release_parcel = release_parcel;
	}

	public boolean isConfirm_arrival() {
		return confirm_arrival;
	}

	public void setConfirm_arrival(boolean confirm_arrival) {
		this.confirm_arrival = confirm_arrival;
	}

	public boolean isCheck_upcoming_parcel() {
		return check_upcoming_parcel;
	}

	public void setCheck_upcoming_parcel(boolean check_upcoming_parcel) {
		this.check_upcoming_parcel = check_upcoming_parcel;
	}

	public boolean isSelect_train() {
		return select_train;
	}

	public void setSelect_train(boolean select_train) {
		this.select_train = select_train;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAdd_device() {
		return add_device;
	}

	public void setAdd_device(boolean add_device) {
		this.add_device = add_device;
	}

	public boolean isRemove_device() {
		return remove_device;
	}

	public void setRemove_device(boolean remove_device) {
		this.remove_device = remove_device;
	}
	
}
