package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.Parcel;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ParcelManager {

	public boolean addParcel(Parcel parcel) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(parcel);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeParcel(Parcel parcel) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(parcel);
			session.getTransaction().commit();
			session.close();
			HibernateUtil.getSessionFactory().close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Returns a list of Parcels
	 * 
	 * @return
	 */
	public List<Parcel> getParcelList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Parcel");
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public Parcel getParcel(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Parcel where parcelID=:id");
		query.setInteger("id", id);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();

		if (list.size() == 0) {
			System.out.println("null");
			return null;
		}

		return list.get(0);
	}

	public boolean updateParcel(Parcel parcel) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(parcel);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Parcel> search(String searchText) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Parcel p WHERE p.ID=:searchText or p.receiver.nic=:searchText");
		query.setString("searchText", searchText);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public List<Parcel> getParcelsToSelectTrain(int myStation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Parcel p WHERE p.currentStation=:searchText and p.train is null and p.destination!=:searchText");
		query.setInteger("searchText", myStation);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean selectTrain(String train, int id) {
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("update Parcel set train=:train where parcelID=:id");
		query.setInteger("id", id);
		query.setString("train", train);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;

	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}

}
