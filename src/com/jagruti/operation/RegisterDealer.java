package com.jagruti.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jagruti.dbcon.DbConnection;

/**
 * Servlet implementation class RegisterDealer
 */
public class RegisterDealer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDealer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			 Connection con=DbConnection.connect();
//			 response.sendRedirect("Index.html");
		     
		      String dname=request.getParameter("name");
		      String dshop =request.getParameter("shop");
		      String dregion=request.getParameter("region");
		      String dcity=request.getParameter("city");
		      String demail=request.getParameter("email");
		      String dphone=request.getParameter("phone");
		      String dpassword=request.getParameter("password");
		     PreparedStatement ps1=con.prepareStatement("insert into dealer_db values(?,?,?,?,?,?,?,?)");
		     ps1.setInt(1,0);
		     ps1.setString(2,demail);
		     ps1.setString(3,dpassword);
		     ps1.setString(4,dshop);
		     ps1.setString(5,dphone);
		     ps1.setString(6,dregion);
		     ps1.setString(7,dcity);
		     ps1.setString(8,dname);
		     
		   
		      
		      
		  int i=ps1.executeUpdate();
		  if(i>0)
		  {  
//		  
		  response.sendRedirect("Index.html");
		  }
		  else
		  {
			  
			  response.sendRedirect("error.html");
		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
