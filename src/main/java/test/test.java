package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.contact;
import entities.email;
import entities.hibernateUtils;

public class test {
	
	public static void main(String [] args)
	{
		Session session=hibernateUtils.getSessionFactory().openSession();
		

	}
}
