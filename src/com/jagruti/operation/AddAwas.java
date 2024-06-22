package com.jagruti.operation;

import java.io.IOException;
import java.io.*;


import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.jagruti.dbcon.DbConnection;

/**
 * Servlet implementation class AddAwas
 */
@MultipartConfig(maxFileSize = 16177215)

public class AddAwas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 4096;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAwas() {
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
				
				
				String uname=request.getParameter("uname");
				String uregion=request.getParameter("uregion");
				String uloc=request.getParameter("uloc");
				String uemail=request.getParameter("Email");
				String ucity=request.getParameter("ucity");
				String uphone=request.getParameter("Phone");
				
				
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

				PreparedStatement ps3 = con.prepareStatement("insert into awas_db  values (?,?,?,?,?,?,?,?)");
				 ps3.setInt(1,0);
			     ps3.setString(2,uname);
			     ps3.setString(3,uphone);
			     ps3.setString(4,uemail);
			     ps3.setString(5,ucity);
			     ps3.setString(6,uregion);
			     ps3.setString(7,uloc);
				
				if (inputStream != null) {
	                //files are treated as BLOB objects in database
	                //here we're letting the JDBC driver
	                //create a blob object based on the
	                //input stream that contains the data of the file
	                ps3.setBinaryStream(8, inputStream,inputStream.available());
	            }
		
					int i = ps3.executeUpdate();
				if(i>0)
				{
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

