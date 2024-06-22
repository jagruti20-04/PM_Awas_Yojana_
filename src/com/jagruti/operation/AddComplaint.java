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
 * Servlet implementation class AddComplaint
 */
public class AddComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaint() {
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
			
			
			
			
			int uid=Integer.parseInt(request.getParameter("uid"));
			String com=request.getParameter("com");
			
			

			PreparedStatement ps3 = con.prepareStatement("insert into Complaint_db  values (?,?)");
			 ps3.setInt(1,uid);
		     ps3.setString(2,com);
		    
			
			
	
			int i = ps3.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("UserTask.html");
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

