package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.db.SHACheckSum;
import model.models.User;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserManager {

	/**
	 * Login method that returns a user object when given valid credentials.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User login(String userName, String password) {

		SHACheckSum shaCheckSum = new SHACheckSum(password);
		String passwordEnc = null;
		try {
			passwordEnc = shaCheckSum.getEncrValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User where username=:userName and password=:password");
		query.setString("userName", userName);
		query.setString("password", passwordEnc);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * Checks validity of session
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginCheck(String userName, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User where username=:userName and password=:password");
		query.setString("userName", userName);
		query.setString("password", password);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * Returns a list of Users
	 * @return
	 */
	public List<User> getUserList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean isUser(String userName){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User where username=:userName");
		query.setString("userName", userName);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return false;
		}

		return true;
	}

}
