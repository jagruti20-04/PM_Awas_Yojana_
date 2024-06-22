package com.jagruti.operation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jagruti.dbcon.DbConnection;

/**
 * Servlet implementation class AddBill
 */
public class AddBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBill() {
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
			
			Connection con = DbConnection.connect();
			
			
			String bid=request.getParameter("bid");
			User.setBid(bid);
			
			String uid=request.getParameter("uid");
			String apass=request.getParameter("apassword");
			User.setBpass(apass);
			

			PreparedStatement ps3 = con.prepareStatement("insert into addbill_db  values (?,?,?)");
			 ps3.setString(1,bid);
		     ps3.setString(2,uid);
		     ps3.setString(3,apass);
		  
			
			
	
			int i = ps3.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("AddMaterial.html");
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

