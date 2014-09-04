package model.managers;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Train;

import org.hibernate.Session;

public class TrainManager {

	public void addTrain(Train train) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(train);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
	public boolean removeTrain(Train train) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(train);
			session.getTransaction().commit();
			session.close();
			HibernateUtil.getSessionFactory().close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
