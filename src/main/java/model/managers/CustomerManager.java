package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Customer;
import model.models.Device;
import model.models.Parcel;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Manages database calls to customer table
 * 
 */
public class CustomerManager {

	/**
	 * Adds customer to DB
	 * @param customer Customer to be added
	 * @return If customer added true, otherwise false
	 */
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

	/**
	 * Get customer by NIC
	 * @param nic NIC to query
	 * @return Customer object
	 */
	public Customer getCustomer(String nic) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer where custNIC=:nic");
		query.setString("nic", nic);
		List<Customer> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}
}
