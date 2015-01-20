package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Category;
import model.models.Station;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Manages database calls to Category table
 * 
 */
public class CategoryManager {

	/**
	 * Adds category to DB
	 * 
	 * @param cat
	 *            Category to be added
	 * @return If added correctly true, otherwise false
	 */
	public boolean addCategory(Category cat) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(cat);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Gets a list of Categories
	 * 
	 * @return list of Categories
	 */
	public List<Category> getCategoryList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Category where deleted='false'");
		List<Category> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * Get Category by ID
	 * 
	 * @param id
	 *            Category ID
	 * @return Category object
	 */
	public Category getCategory(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category where catid=:id");
		query.setInteger("id", id);
		List<Category> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	/**
	 * Marks a Category deleted
	 * 
	 * @param id
	 *            Category to be deleted
	 * @param by
	 *            User who performs delete
	 * @return If deleted correctly true, otherwise false
	 */
	public boolean deleteCategory(int id, String by) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update Category set deleted=1, deleteby=:by where catid=:id");
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
	 * Update category
	 * 
	 * @param cat
	 *            Category to be updated
	 * @return If updated correctly true, otherwise false
	 */
	public boolean updateCategory(Category cat) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(cat);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
