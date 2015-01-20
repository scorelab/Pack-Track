package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Station;
import model.models.Train;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class TrainManager {

	@Deprecated
	public boolean addTrain(Train train) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(train);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Deprecated
	public boolean removeTrain(Train train) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(train);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Gets a list of Train
	 * 
	 * @return list of Trains
	 */
	public List<Train> getTrainList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Train");
		List<Train> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * Gets a train by ID
	 * @param id ID of the train
	 * @return Train object
	 */
	public Train getTrain(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Train where train_num=:id");
		query.setInteger("id", id);
		List<Train> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			System.out.println("null");
			return null;
		}

		return list.get(0);
	}

	@Deprecated
	public boolean deleteTrain(int id, String by) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update Train set deleted=1, deleteby=:by where trainid=:id");
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

	@Deprecated
	public boolean updateTrain(Train train) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(train);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
