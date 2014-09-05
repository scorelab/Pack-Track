package model.managers;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Station;

import org.hibernate.Session;

public class StationManager {

	public void addStation(Station station) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(station);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

	public boolean removeStation(Station station) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(station);
			session.getTransaction().commit();
			session.close();
			HibernateUtil.getSessionFactory().close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
