package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Category;
import model.models.Station;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class CategoryManager {

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
	 * Returns a list of Stations
	 * 
	 * @return
	 */
	public List<Category> getCategoryList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

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
	
	public boolean deleteCategory(int id, String by) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session.createSQLQuery("update Category set deleted=1, deleteby=:by where stationid=:id");
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
