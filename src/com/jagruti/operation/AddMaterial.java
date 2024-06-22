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
 * Servlet implementation class AddMaterial
 */
public class AddMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaterial() {
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
			
			
			String bid = User.getBid();
			String item=request.getParameter("item");
			int qua=Integer.parseInt(request.getParameter("quantity"));
			int cost=Integer.parseInt(request.getParameter("cost"));
			String apass=User.getBpass();
			System.out.println(bid+"Hello "+apass);
			 PreparedStatement ps3=con.prepareStatement("select *  from  addbill_db where bid=? and bpass=?");
			  ps3.setString(1,bid);
			  ps3.setString(2,apass);
			  
			 ResultSet rst=ps3.executeQuery();
			 if(rst.next())
				  {
				 
				    String p=rst.getString("bid");
				    String pass = rst.getString("bpass");
				    
				 if(p.equals(bid) && apass.equals(pass) )
				 {
						PreparedStatement ps = con.prepareStatement("insert into add_material  values (?,?,?,?,?)");
						 ps.setString(1,bid);
						 ps.setString(2,item);
						 ps.setInt(3,qua);
					     ps.setInt(4,cost);
					     ps.setString(5,apass);
					  
						
						
				
						int i = ps.executeUpdate();
						if(i>0)
						{
							response.sendRedirect("welcome.html");
						}
						else
						{
							response.sendRedirect("error.html");
						}
						
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
		}
	}

}

