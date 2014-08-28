package model.managers;

import model.db.HibernateUtil;
import model.models.Device;

import org.hibernate.Session;

public class DeviceManager {
	
	public void addDevice(Device device){
	Session session =HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(device);
	session.getTransaction().commit();
	session.close();
	HibernateUtil.getSessionFactory().close();
	}

}
