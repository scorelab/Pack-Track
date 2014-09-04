package model.managers;

import model.db.HibernateUtil;
import model.models.Device;
import org.hibernate.Session;

public class DeviceManager {

	public void addDevice(Device device) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(device);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
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

}
