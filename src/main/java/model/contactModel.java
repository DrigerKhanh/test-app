package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.query.Query;

import controller.myConnect;
import entities.contact;
import entities.email;
import entities.hibernateUtils;
import entities.phone;

public class contactModel {
	contact cont;
	Part file;
	
	
	public contactModel(Part file) {
		this.file = file;
	}


	public contactModel(contact cont) {
		this.cont = cont;
	}

	public contactModel() {
	}


	public List<contact> getList(){
		ArrayList<contact> list=new ArrayList<>();
		
			Session session=hibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String sql="from contact";
			Query query=session.createQuery(sql);
			list=(ArrayList<contact>) query.list();
			session.getTransaction().commit();
		
		return list;
	}
	
	public String getFileName(Part filepart)
	{
		String filename="";
		String header=filepart.getHeader("content-Disposition");
		//System.out.println("header:"+header);
		int beginIndex=header.lastIndexOf("=");
		filename=header.substring(beginIndex+1);
		
		//remove "" quotes 2 dau chuoi
		Pattern p=Pattern.compile("\"([^\"]*)\"");
		Matcher m=p.matcher(filename);
		while(m.find())
		{
			filename=m.group(1);
		}
		
		//danh cho IE
		beginIndex=filename.lastIndexOf("\\");
		filename=filename.substring(beginIndex+1);
		
		return filename;
		
	}
	
	public void uploadFile(String uploadRootPath)
	{
		try
		{
			InputStream fis=file.getInputStream();
			byte []data=new byte[fis.available()];
			fis.read(data);
			
			FileOutputStream out=new FileOutputStream(new File(uploadRootPath + "\\" + getFileName(file)));
			out.write(data);
			out.close();
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Upload fail");
		}
		System.out.println("Upload success");
	}
	
	public int insertContact()
	{
		int kq=0;
		try
		{
			Session session=hibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			String sql="insert into contact(contactid,fullname,image,dateofBirth,sex,address) values(:contactid,:fullname,:image,:dateofBirth,:sex,:address)";
			Query query=session.createNativeQuery(sql);
			query.setParameter("contactid", cont.getContactid());
			query.setParameter("fullname", cont.getFullname());
			query.setParameter("image", cont.getImage());
			query.setParameter("dateofBirth", cont.getDateofBirth());
			query.setParameter("sex", cont.getSex());
			query.setParameter("address", cont.getAddress());
			session.save(cont);
			session.joinTransaction();
			kq=query.executeUpdate();
			session.close();
		}catch(Throwable ex)
		{
			ex.printStackTrace();
		}
		return kq;
	}

	
	

}
