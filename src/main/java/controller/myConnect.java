package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnect {
	private String servername;
	private String port;
	private String db_name;
	private String db_user;
	private String db_pass;
	public myConnect() {
		this.servername = "127.0.0.1";
		this.port = "3306";
		this.db_name = "contact";
		this.db_user = "root";
		this.db_pass = "";
	}


	public Connection getcn()
	{
		Connection cn=null;
		try
		{
			String db_url="jdbc:mysql://"+servername+":"+port+"/"+db_name;
			System.out.println(db_url);
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection(db_url, db_user, db_pass);
		}catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return cn;
	}
	
}




