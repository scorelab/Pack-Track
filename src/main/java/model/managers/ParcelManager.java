package model.managers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.db.HibernateUtil;
import model.models.Parcel;
import model.models.Station;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ParcelManager {

	public boolean addParcel(Parcel parcel) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(parcel);
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
		if (list.size() > 0) {
			System.out.println("rtbb d3e3");
			return true;
		}
		return false;
	}

	public List<Parcel> searchRealease(String searchText, int stationID) {
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
		if (list.size() > 0) {
			return list.get(0).getCurrentStation().getName();
		}
		return null;
	}

	/*
	 * Returns list of pending parcels for given Station
	 */
	public List<Parcel> getPendingParcelList(Station station) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p where p.destination.id=:station and p.currentStation.id!=:station");
		query.setInteger("station", station.getID());
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * Gives the income by month in a given year
	 * 
	 * @param year
	 * @return array containing incomes of 12 months
	 */
	public float[] getIncomeMonth(int year, int station) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long january = 0, february = 0, march = 0, april = 0, may = 0, june = 0, july = 0, august = 0, september = 0, october = 0, november = 0, december = 0, end = 0;
		try {
			january = df.parse("1/1/" + year).getTime() / 1000;
			february = df.parse("1/2/" + year).getTime() / 1000;
			march = df.parse("1/3/" + year).getTime() / 1000;
			april = df.parse("1/4/" + year).getTime() / 1000;
			may = df.parse("1/5/" + year).getTime() / 1000;
			june = df.parse("1/6/" + year).getTime() / 1000;
			july = df.parse("1/7/" + year).getTime() / 1000;
			august = df.parse("1/8/" + year).getTime() / 1000;
			september = df.parse("1/9/" + year).getTime() / 1000;
			october = df.parse("1/10/" + year).getTime() / 1000;
			november = df.parse("1/11/" + year).getTime() / 1000;
			december = df.parse("1/12/" + year).getTime() / 1000;
			end = df.parse("1/1/" + new Integer(year + 1).toString()).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		float[] out = new float[12];
		if (january != 0) {
			out[0] = getIncome(january, february,station);
			out[1] = getIncome(february, march,station);
			out[2] = getIncome(march, april,station);
			out[3] = getIncome(april, may,station);
			out[4] = getIncome(may, june,station);
			out[5] = getIncome(june, july,station);
			out[6] = getIncome(july, august,station);
			out[7] = getIncome(august, september,station);
			out[8] = getIncome(september, october,station);
			out[9] = getIncome(october, november,station);
			out[10] = getIncome(november, december,station);
			out[11] = getIncome(december, end,station);
			return out;
		}
		return null;

	}

	public float getIncome(long start, long end, int station) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String qText="select sum(p.totalCost) as totalCost from Parcel p WHERE p.dateRecieved>=:start and p.dateRecieved<:end";
		if(station!=-1){
			qText="select sum(p.totalCost) as totalCost from Parcel p WHERE p.dateRecieved>=:start and p.dateRecieved<:end and starts="+station;
		}
		Query query = session
				.createQuery(qText);
		query.setLong("start", start);
		query.setLong("end", end);
		List<Double> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list != null && list.size() > 0) {
			for (Double arr : list) {
				if (arr == null) {
					return 0f;
				}
				return (float) Math.round(arr.floatValue() * 100) / 100;
			}
		}
		return 0f;
	}

	/**
	 * Gives the income of the year,month and day for a given station and date.
	 * 
	 * @param station
	 *            station to calculate income
	 * @param date
	 *            to calculate income
	 * @return
	 */
	public float[] getIncomeStation(int station, String date) {
		System.out.println(station);
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		Date d=new Date();
		float[] out = new float[3];
		try {
			d = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(d);
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
//		int daysOfMonth=calendar.getMaximum(Calendar.DAY_OF_MONTH);
		long yearBegin=0, yearEnd=0, monthBegin=0, monthEnd=0, dayBegin=0, dayEnd=0;
		try {
			yearBegin=df.parse("1/1/"+year).getTime()/1000;
			yearEnd=df.parse("1/1/"+(year+1)).getTime()/1000;
			monthBegin=df.parse(month+"/1/"+year).getTime()/1000;
			monthEnd=df.parse((month+1)+"/1/"+year).getTime()/1000;
			dayBegin=df.parse(month+"/"+day+"/"+year).getTime()/1000;
			dayEnd=df.parse(month+"/"+(day+1)+"/"+year).getTime()/1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		out[0]=getIncome(yearBegin, yearEnd,station);
		out[1]=getIncome(monthBegin, monthEnd,station);
		out[2]=getIncome(dayBegin, dayEnd,station);
		return out;

	}
}
