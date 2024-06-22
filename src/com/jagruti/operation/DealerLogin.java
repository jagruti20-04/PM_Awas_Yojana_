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
 * Servlet implementation class DealerLogin
 */
public class DealerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealerLogin() {
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
		String password=request.getParameter("Password");
		try{
		   Connection con=DbConnection.connect();
		 PreparedStatement ps3=con.prepareStatement("select *  from  dealer_db where demail=?");
		  ps3.setString(1,email);
		  
		 ResultSet rst=ps3.executeQuery();
		 if(rst.next())
			  {
			 
			    String uemail=rst.getString("demail");
			    String pass =rst.getString("password");
			 if(uemail.equals(email)&& pass.equals(password) )
			 {
				 response.sendRedirect("DealerTask.html"); 
			 }
			 else
			 {
				 response.sendRedirect("error.html");
			 }
		 }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");

		}
	}

}