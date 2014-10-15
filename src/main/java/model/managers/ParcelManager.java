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

	public Parcel getParcel(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Parcel where parcelID=:id");
		query.setLong("id", id);
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
		Query query = session
				.createQuery("from Parcel p WHERE p.ID=:searchText or p.receiver.nic=:searchText or p.sender.nic=:searchText");
		query.setString("searchText", searchText);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Parcel> getParcelsToSelectTrain(int myStation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p WHERE p.currentStation=:searchText and p.train is null and p.destination!=:searchText");
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
			SQLQuery query = session
					.createSQLQuery("update Parcel set train=:train where parcelID=:id");
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
	
	public boolean confirmArrival(int stationID, Long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update Parcel set currentStation=:station, train=null where parcelID=:id");
			query.setLong("id", id);
			query.setInteger("station", stationID);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getParcelsToConfirm(long id) {
		System.out.println("ght boo");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p WHERE p.released=0 and p.train is not null and p.ID=:searchText");
		query.setLong("searchText", id);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		if(list.size()>0){
			System.out.println("rtbb d3e3");
			return true;
		}
		return false;
	}

	public List<Parcel> searchRealease(String searchText,int stationID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p WHERE (p.ID=:searchText or p.receiver.nic=:searchText) and p.destination=:station and p.currentStation=:station");
		query.setString("searchText", searchText);
		query.setInteger("station", stationID);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public boolean releaseParcel(Long id, String userName) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("update Parcel set released	=1, releaseBy=:user where parcelID=:id");
			query.setLong("id", id);
			query.setString("user", userName);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String trackParcel(long id, String nic) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p WHERE ( p.sender.nic=:user or p.receiver.nic=:user) and p.ID=:searchText");
		query.setLong("searchText", id);
		query.setString("user", nic);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		if(list.size()>0){
			return list.get(0).getCurrentStation().getName();
		}
		return null;
	}
}
