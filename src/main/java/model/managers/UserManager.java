package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.db.SHACheckSum;
import model.models.Train;
import model.models.User;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Manages database calls regarding users
 * 
 */
public class UserManager {

	/**
	 * Login method that returns a user object when given valid credentials.
	 * 
	 * @param userName
	 * @param password
	 * @return User object
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
				.createQuery("from User u where u.userName=:userName and u.password=:password and u.userDetail.deleted='false'");
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
				.createQuery("from User u where u.userName=:userName and u.password=:password and u.userDetail.deleted='false'");
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
	 * 
	 * @return
	 */
	public List<User> getUserList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.userDetail.deleted='false'");
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * Checks a given user name exists in the DB
	 * 
	 * @param userName
	 *            User name to be checked
	 * @return True if exists, false otherwise
	 */
	public boolean isUser(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username=:userName");
		query.setString("userName", userName);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * Adds a new user to the database
	 * 
	 * @param user
	 *            user to be added
	 * @return If user added true, otherwise false
	 */
	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets a user by user name
	 * 
	 * @param userName
	 *            User name to query
	 * @return User object
	 */
	public User getUser(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username=:userName");
		query.setString("userName", userName);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	/**
	 * Updates user
	 * 
	 * @param user
	 *            User to be updated
	 * @return If updated correctly true, otherwise false
	 */
	public boolean updateUser(User user) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Marks a user deleted
	 * 
	 * @param userName
	 *            User to be deleted
	 * @param by
	 *            User who is deleting
	 * @return If deleted correctly true, otherwise false
	 */
	public boolean deleteUser(String userName, String by) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update User_detail set deleted=1, deleteby=:by where username=:userName");
			query.setString("userName", userName);
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
	 * Gets user by email
	 * 
	 * @param email
	 *            Email to query
	 * @return User object
	 */
	public User getUserByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.userDetail.email=:email and  u.userDetail.deleted='false'");
		query.setString("email", email);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	/**
	 * Checks a given email exists in the DB
	 * 
	 * @param email
	 *            Email to check
	 * @return If email exists true, otherwise false
	 */
	public boolean checkEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.userDetail.email=:email");
		query.setString("email", email);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * Check for NIC already exists
	 * 
	 * @param NIC
	 *            NIC to be checked
	 * @return If NIC exists true, otherwise false
	 */
	public boolean checkNIC(String NIC) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User u where u.nicNumber=:nic");
		query.setString("nic", NIC);
		List<User> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return false;
		}

		return true;
	}

}
