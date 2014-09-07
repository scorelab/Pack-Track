package model.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserPrivilegeTest {

	User user=new User();
	
	UserPrivilege userPrivilegeDefault=new UserPrivilege(); //Default Contructor
	UserPrivilege userPrivilegeParameter=new UserPrivilege(user, "Rand", 
			true, true, true, false, false,
			false, false, true, false, true,
			true, true, true, true, true,
			false, false);
		
	@Test
	public void isAddUserTest() {
		assertEquals(true, userPrivilegeParameter.isAdd_user());
	}
	
	@Test
	public void isRemoveUserTest() {
		assertEquals(true, userPrivilegeParameter.isRemove_user());
	}

	@Test
	public void isAddStationTest() {
		assertEquals(true, userPrivilegeParameter.isAdd_station());
	}
	
	@Test
	public void isRemoveStationTest() {
		assertEquals(false, userPrivilegeParameter.isRemove_station());
	}

	@Test
	public void isAddTrainTest() {
		assertEquals(false, userPrivilegeParameter.isAdd_train());
	}
	
	@Test
	public void isRemoveTrainTest() {
		assertEquals(false, userPrivilegeParameter.isRemove_train());
	}
	
	@Test
	public void isAddCategoryTest() {
		assertEquals(false, userPrivilegeParameter.isAdd_category());
	}
	
	@Test
	public void isRemoveCategoryTest() {
		assertEquals(true, userPrivilegeParameter.isRemove_category());
	}
	
	@Test
	public void isAddCustomerTest() {
		assertEquals(false, userPrivilegeParameter.isAdd_customer());
	}
	
	@Test
	public void isRemoveCustomerTest() {
		assertEquals(true, userPrivilegeParameter.isRemove_customer());
	}

	@Test
	public void isAddParcelTest() {
		assertEquals(true, userPrivilegeParameter.isAdd_parcel());
	}
	
	@Test
	public void isReleaseParcelTest() {
		assertEquals(true, userPrivilegeParameter.isRelease_parcel());
	}

	@Test
	public void isConfirmArrivalTest() {
		assertEquals(true, userPrivilegeParameter.isConfirm_arrival());
	}
	
	@Test
	public void isCheckUpcomingParcelTest() {
		assertEquals(true, userPrivilegeParameter.isCheck_upcoming_parcel());
	}

	@Test
	public void isSelectTrainTest() {
		assertEquals(true, userPrivilegeParameter.isSelect_train());
	}
	
	@Test
	public void getUserNameTest() {
		assertEquals("Rand", userPrivilegeParameter.getUserName());
	}

	@Test
	public void getUserTest() {
		assertEquals(user, userPrivilegeParameter.getUser());
	}
	
	@Test
	public void isAddDeviceTest() {
		assertEquals(false, userPrivilegeParameter.isAdd_device());
	}
	
	@Test
	public void isRemoveDeviceTest() {
		assertEquals(false, userPrivilegeParameter.isRemove_device());
	}
	
	@Test
	public void setAddUserTest() {
		userPrivilegeDefault.setAdd_user(false);
		assertEquals(false, userPrivilegeDefault.isAdd_user());
	}
	
	@Test
	public void setRemoveUserTest() {
		userPrivilegeDefault.setRemove_user(false);
		assertEquals(false, userPrivilegeDefault.isRemove_user());
	}

	@Test
	public void setAddStationTest() {
		userPrivilegeDefault.setAdd_station(true);
		assertEquals(true, userPrivilegeDefault.isAdd_station());
	}
	
	@Test
	public void setRemoveStationTest() {
		userPrivilegeDefault.setRemove_station(true);
		assertEquals(true, userPrivilegeDefault.isRemove_station());
	}

	@Test
	public void setAddTrainTest() {
		userPrivilegeDefault.setAdd_train(true);
		assertEquals(true, userPrivilegeDefault.isAdd_train());
	}
	
	@Test
	public void setRemoveTrainTest() {
		userPrivilegeDefault.setRemove_train(true);
		assertEquals(true, userPrivilegeDefault.isRemove_train());
	}
	
	@Test
	public void setAddCategoryTest() {
		userPrivilegeDefault.setAdd_category(true);
		assertEquals(true, userPrivilegeDefault.isAdd_category());
	}
	
	@Test
	public void setRemoveCategoryTest() {
		userPrivilegeDefault.setRemove_category(false);
		assertEquals(false, userPrivilegeDefault.isRemove_category());
	}

	@Test
	public void setAddCustomerTest() {
		userPrivilegeDefault.setAdd_customer(true);
		assertEquals(true, userPrivilegeDefault.isAdd_customer());
	}
	
	@Test
	public void setRemoveCustomerTest() {
		userPrivilegeDefault.setRemove_customer(false);
		assertEquals(false, userPrivilegeDefault.isRemove_customer());
	}

	@Test
	public void setAddParcelTest() {
		userPrivilegeDefault.setAdd_parcel(false);
		assertEquals(false, userPrivilegeDefault.isAdd_parcel());
	}
	
	@Test
	public void setReleaseParcelTest() {
		userPrivilegeDefault.setRelease_parcel(false);
		assertEquals(false, userPrivilegeDefault.isRelease_parcel());
	}

	@Test
	public void setConfirmArrivalTest() {
		userPrivilegeDefault.setConfirm_arrival(false);
		assertEquals(false, userPrivilegeDefault.isConfirm_arrival());
	}
	
	@Test
	public void setCheckUpcomingParcelTest() {
		userPrivilegeDefault.setCheck_upcoming_parcel(false);
		assertEquals(false, userPrivilegeDefault.isCheck_upcoming_parcel());
	}

	@Test
	public void setSelectTrainTest() {
		userPrivilegeDefault.setSelect_train(false);
		assertEquals(false, userPrivilegeDefault.isSelect_train());
	}
	
	@Test
	public void setUserNameTest() {
		userPrivilegeDefault.setUserName("Lahiru");
		assertEquals("Lahiru", userPrivilegeDefault.getUserName());
	}

	@Test
	public void setUserTest() {
		userPrivilegeDefault.setUser(user);
		assertEquals(user, userPrivilegeDefault.getUser());
	}
	
	@Test
	public void setAddDeviceTest() {
		userPrivilegeDefault.setAdd_device(true);
		assertEquals(true, userPrivilegeDefault.isAdd_device());
	}
	
	@Test
	public void setRemoveDeviceTest() {
		userPrivilegeDefault.setRemove_device(true);
		assertEquals(true, userPrivilegeDefault.isRemove_device());
	}

}
