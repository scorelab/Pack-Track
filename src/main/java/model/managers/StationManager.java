package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Device;
import model.models.Station;
import model.models.User;

import org.hibernate.Query;
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
	
	/**
	 * Returns a list of Stations
	 * @return
	 */
	public List<Station> getStationList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Station");
		List<Station> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
