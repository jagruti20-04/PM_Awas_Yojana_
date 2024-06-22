package com.jagruti.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	
	static Connection con=null;
	public static Connection connect()
	{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pm","root","");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("Something went wrong...");
				System.out.println("connection is not establish");
				e.printStackTrace();
			}

		return con;
	}
	

}





