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

/**
 * Manages database calls to parcel table
 * 
 */
public class ParcelManager {

	/**
	 * Adds a new parcel to the database
	 * 
	 * @param parcel
	 *            Parcel to be added
	 * @return If parcel added true, otherwise false
	 */
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

	/**
	 * Removes a parcel from database
	 * 
	 * @param parcel
	 *            Parcel to be removed
	 * @return boolean If parcel removed true, otherwise false
	 */
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
	 * @return List of parcels
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

	/**
	 * Get a parcel from parcel ID
	 * 
	 * @param id
	 *            ID of parcel to get
	 * @return Parcel
	 */
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

	/**
	 * Updates a parcel in database
	 * 
	 * @param parcel
	 *            Parcel to be updated
	 * @return If parcel updated true, otherwise false
	 */
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

	/**
	 * Search parcels by given search text
	 * 
	 * @param searchText
	 *            Parcel ID or Sender NIC or Receiver NIC
	 * @return Parcel list which match the search
	 */
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

	/**
	 * Gets a list of parcels which are to be loaded to a train
	 * 
	 * @param myStation
	 *            Station that parcels currently resides
	 * @return List of parcels
	 */
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

	/**
	 * Assigns a train to the parcel
	 * 
	 * @param train
	 *            Train to be assigned
	 * @param id
	 *            Parcel
	 * @return If train assigned true, otherwise false
	 */
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

	/**
	 * Confirms parcels arrival to a station
	 * 
	 * @param stationID
	 *            Station which parcel is recently arrived
	 * @param id
	 *            Subjected Parcel
	 * @return If parcel updated correctly true, otherwise false
	 */
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

	/**
	 * Gets a list of parcels which were assigned trains an check if the given
	 * parcel is in it. So only these parcels can be arrived to station.
	 * 
	 * @param id
	 *            Parcel in question
	 * @return If parcel is in a state where it can be arrived to another
	 *         station true, otherwise false
	 */
	public boolean getParcelsToConfirm(long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Parcel p WHERE p.released=0 and p.train is not null and p.ID=:searchText");
		query.setLong("searchText", id);
		List<Parcel> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() > 0) {

			return true;
		}
		return false;
	}

	/**
	 * Search for a parcel where it can be released
	 * @param searchText Parcel ID or receiver NIC
	 * @param stationID Station in question
	 * @return List of eligible parcels
	 */
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

	/**
	 * Mark a parcels as released to customer
	 * @param id Parcel ID
	 * @param userName User who is releasing the parcel
	 * @return If released correctly true, otherwise false
	 */
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

	/**
	 * Gives current location of a parcel
	 * @param id Parcel ID
	 * @param nic NIC of customer
	 * @return Current station name
	 */
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

	/**
	 * Returns list of pending parcels for given Station
	 * @param station Station in question
	 * @return List of stations
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
	 * @param year Year to calculate
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
			out[0] = getIncome(january, february, station);
			out[1] = getIncome(february, march, station);
			out[2] = getIncome(march, april, station);
			out[3] = getIncome(april, may, station);
			out[4] = getIncome(may, june, station);
			out[5] = getIncome(june, july, station);
			out[6] = getIncome(july, august, station);
			out[7] = getIncome(august, september, station);
			out[8] = getIncome(september, october, station);
			out[9] = getIncome(october, november, station);
			out[10] = getIncome(november, december, station);
			out[11] = getIncome(december, end, station);
			return out;
		}
		return null;

	}

	/**
	 * Gets income of a station in the given time period
	 * @param start Start time
	 * @param end End time
	 * @param station Station ID
	 * @return Total income
	 */
	public float getIncome(long start, long end, int station) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String qText = "select sum(p.totalCost) as totalCost from Parcel p WHERE p.dateRecieved>=:start and p.dateRecieved<:end";
		if (station != -1) {
			qText = "select sum(p.totalCost) as totalCost from Parcel p WHERE p.dateRecieved>=:start and p.dateRecieved<:end and starts="
					+ station;
		}
		Query query = session.createQuery(qText);
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

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		float[] out = new float[3];
		try {
			d = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// int daysOfMonth=calendar.getMaximum(Calendar.DAY_OF_MONTH);
		long yearBegin = 0, yearEnd = 0, monthBegin = 0, monthEnd = 0, dayBegin = 0, dayEnd = 0;
		try {
			yearBegin = df.parse("1/1/" + year).getTime() / 1000;
			yearEnd = df.parse("1/1/" + (year + 1)).getTime() / 1000;
			monthBegin = df.parse(month + "/1/" + year).getTime() / 1000;
			monthEnd = df.parse((month + 1) + "/1/" + year).getTime() / 1000;
			dayBegin = df.parse(month + "/" + day + "/" + year).getTime() / 1000;
			dayEnd = df.parse(month + "/" + (day + 1) + "/" + year).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		out[0] = getIncome(yearBegin, yearEnd, station);
		out[1] = getIncome(monthBegin, monthEnd, station);
		out[2] = getIncome(dayBegin, dayEnd, station);
		return out;

	}
/**
 * Get the number of parcels currently in station
 * @param station Station in question
 * @return Number of parcels
 */
	public int getToBeHandled(int station) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("select count(p.id) as total from Parcel p WHERE p.currentStation=:station");
		query.setInteger("station", station);
		List<Long> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list != null && list.size() > 0) {
			for (Long arr : list) {
				return arr.intValue();
			}
		}
		return 0;
	}

	/**
	 * Get the number of parcels received in a given day
	 * @param station Station in question
	 * @param date Date to count parcels
	 * @return Number of parcels
	 */
	public int getRecieved(int station, Date date) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		long dayBegin = 0;
		try {
			dayBegin = df.parse(month + "/" + day + "/" + year).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("select count(p.id) as total from Parcel p WHERE p.currentStation=:station and p.dateRecieved>=:start");
		query.setInteger("station", station);
		query.setLong("start", dayBegin);
		List<Long> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list != null && list.size() > 0) {
			for (Long arr : list) {
				return arr.intValue();
			}
		}
		return 0;

	}

	/**
	 * Gets annual income on each station
	 * @param year Year to calculate
	 * @return Annual incomes and station names as JSON array
	 */
	public String getAnualSatationIncome(int year) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long start = 0, end = 0;
		try {
			start = df.parse("1/1/" + year).getTime() / 1000;
			end = df.parse("1/1/" + new Integer(year + 1).toString()).getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		StationManager sm = new StationManager();

		List<Station> list = sm.getStationList();

		if (list != null && list.size() > 0) {
			sb.append("[");
			for (Station arr : list) {
				int id = arr.getID();
				float income = getIncome(start, end, id);
				sb.append("{ station : \"" + arr.getName() + "\", value :"
						+ income + " },");

			}
			sb.append("]");
		}

		return sb.toString();
	}
}
