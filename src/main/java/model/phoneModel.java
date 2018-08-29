package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import controller.myConnect;
import entities.hibernateUtils;
import entities.phone;

public class phoneModel {
	phone phone;

	public phoneModel(phone phone) {
		this.phone = phone;
	}
	
	public phoneModel() {
	}

	public List<phone> getPhoneByid(int contactid)
	{
		
			//phone pho=null;
			Session session=hibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String sql="select e.phone from phonecontact e where e.contactid= :contactid";
			Query query=session.createNativeQuery(sql);
			query.setParameter("contactid", contactid);
			List<phone> pho=query.list();
			session.getTransaction().commit();
			return pho;
		
	}
	
	public int insertPhone()
	{
		int kq=0;
		try
		{
			Session session=hibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String sql="insert into phonecontact(contactid, phone) values(:contactid,:phone)";
			Query query=session.createNativeQuery(sql);
			query.setParameter("contactid", phone.getContactid());
			query.setParameter("phone", phone.getPhone());
			session.save(phone);
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
