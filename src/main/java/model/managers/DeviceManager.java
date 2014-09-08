package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Station;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class DeviceManager {

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
	 * Returns a list of Device
	 * 
	 * @return
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

}
