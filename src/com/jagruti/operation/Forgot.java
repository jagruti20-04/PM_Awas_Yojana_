package com.jagruti.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jagruti.dbcon.DbConnection;

/**
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
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
		String email=request.getParameter("Email");
		String password=request.getParameter("pass");
		try{
		   Connection con=DbConnection.connect();
		   System.out.println(email);
		   System.out.println(password);
		 PreparedStatement ps3=con.prepareStatement("update Dealer_db set password=?  where demail=?");
		  ps3.setString(1,password);
		  ps3.setString(2,email);
		  
		  int i = ps3.executeUpdate();
			if(i>0)
			  {
			  System.out.println(email);
			   System.out.println(password);
			    response.sendRedirect("vary.html"); 
			 }
			 else
			 {
				 response.sendRedirect("error.html");
			 }
		 
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");

		}
	}

}
