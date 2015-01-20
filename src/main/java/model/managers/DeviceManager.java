package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Station;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Manages database calls to Device table
 * 
 */
public class DeviceManager {

	/**
	 * Adds Device to the DB
	 * @param device Device to be added
	 * @return If added correctly true, otherwise false
	 */
	public boolean addDevice(Device device) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(device);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Marks a Device deleted
	 * @param device Device to be removed
	 * @return  If removed correctly true, otherwise false
	 */
	public boolean removeDevice(Device device) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(device);
			session.getTransaction().commit();
			session.close();
			HibernateUtil.getSessionFactory().close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Gets a list of Devices
	 * 
	 * @return list of Devices
	 */
	public List<Device> getDeviceList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Device where deleted='false'");
		List<Device> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * Get Device by ID
	 * @param id Device ID
	 * @return Device object
	 */
	public Device getDevice(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Device where devid=:id");
		query.setInteger("id", id);
		List<Device> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			System.out.println("null");
			return null;
		}

		return list.get(0);
	}

	/**
	 * Marks a device deleted
	 * @param id Device to be deleted
	 * @param by User who performs delete
	 * @return  If deleted correctly true, otherwise false
	 */
	public boolean deleteDevice(int id, String by) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update Device set deleted=1, deleteby=:by where devid=:id");
			query.setInteger("id", id);
			query.setString("by", by);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Updates a device
	 * @param device Device to be updated
	 * @return  If updated correctly true, otherwise false
	 */
	public boolean updateDevice(Device device) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(device);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets device by IMEI number
	 * @param imei IMEI to query
	 * @return Device object
	 */
	public Device getDeviceByIMEI(String imei) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Device where imei=:imei");
		query.setString("imei", imei);
		List<Device> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			System.out.println("null");
			return null;
		}

		return list.get(0);
	}
}
