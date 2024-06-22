package com.jagruti.operation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jagruti.dbcon.DbConnection;

/**
 * Servlet implementation class SubmitBill
 */
@MultipartConfig(maxFileSize = 16177215)
public class SubmitBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitBill() {
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
			int uid=Integer.parseInt(request.getParameter("id"));
			
			   Connection con=DbConnection.connect();
			InputStream inputStream = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("Photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());

	            //obtains input stream of the upload file
	            //the InputStream will point to a stream that contains
	            //the contents of the file
	            inputStream = filePart.getInputStream();
	        }

			PreparedStatement ps3 = con.prepareStatement("insert into bill_photos  values (?,?)");
			 ps3.setInt(1,uid);
		    
		    
			
			if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                ps3.setBinaryStream(2, inputStream,inputStream.available());
            }
	
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
		}
	}
}



