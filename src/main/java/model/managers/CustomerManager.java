package model.managers;

import model.db.HibernateUtil;
import model.models.Customer;
import model.models.Device;

import org.hibernate.Session;

public class CustomerManager {

	public boolean addCustomer (Customer customer) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(customer);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
}
