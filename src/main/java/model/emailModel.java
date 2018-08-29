package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import controller.myConnect;
import entities.email;
import entities.hibernateUtils;

public class emailModel {
	email email;

	public emailModel(email email) {
		this.email = email;
	}
	
	
	public emailModel() {
	}


	public List<email> getEmailbyID(int contactid)
	{
		
	
		Session session=hibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		String sql="select e.email from emailcontact e where e.contactid= :contactid";
		Query query=session.createNativeQuery(sql);
		query.setParameter("contactid", contactid);	
		List<email> em=query.list();
		
		session.getTransaction().commit();
	
			
		return em;
		
	}
	
	public int insertEmail()
	{
		int kq=0;
		try
		{
			Session session=hibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String sql="insert into emailcontact(contactid,email) values(:contactid,:email)";
			Query query=session.createNativeQuery(sql);
			query.setParameter("contactid", email.getContactid());
			query.setParameter("email",email.getEmail());
			session.save(email);
			
			session.joinTransaction();
			kq=query.executeUpdate();
			session.close();
			
			
			
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return kq;
	}
	
}
