package model.managers;

import model.db.HibernateUtil;
import model.models.Train;
import org.hibernate.Session;

public class TrainManager {

	public void addTrain(Train train) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(train);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
