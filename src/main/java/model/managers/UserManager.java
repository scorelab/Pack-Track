package model.managers;

import java.util.List;

import model.db.HibernateUtil;
import model.models.User;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserManager {

	public User login(String userName, String password){
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from User where username=:userName and password=:password");
		query.setString("userName",userName);
		query.setString("password", password);
		List<User> list=query.list();
		session.getTransaction().commit();
		session.close();
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
