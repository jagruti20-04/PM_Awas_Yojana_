package com.jagruti.operation;


import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.jagruti.dbcon.*;
@MultipartConfig(maxFileSize = 16177215)
// upload file's size up to 16MB
public class FileUploadDbServlet extends HttpServlet {
    private static final int BUFFER_SIZE = 4096;
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/imgdb";
    private String dbUser = "root";
    private String dbPass = "";

    //naive way to obtain a connection to database
    //this MUST be improved, shown for 
    private Connection getConnection() {
        Connection conn = null;	
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            //wrapping any exception and rethrowing it
            //inside a RuntimeException
            //so the method is silent to exceptions
            throw new RuntimeException("Failed to obtain database connection.", e);
        }
        return conn;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //get values of text fields
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
//        GetSet.setFname(firstName);
//        GetSet.setLname(lastName);
        
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

        Connection conn = null; // connection to the database
        String message = null; // message will be sent back to client
        try {
            // connects to the database
            conn = getConnection();
            // constructs SQL statement
            String sql = "INSERT INTO contacts (fname, lname, photo) values (?, ?, ?)";
            //Using a PreparedStatement to save the file
            PreparedStatement pstmtSave = conn.prepareStatement(sql);
            pstmtSave.setString(1, firstName);
            pstmtSave.setString(2, lastName);

            if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                pstmtSave.setBlob(3, inputStream);
            }
            //sends the statement to the database server
            int row = pstmtSave.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }

            String filepath = "C:/Users/prath/workspace/img/WebContent/abc.png";
            //Obtaining the file from database
            //Using a second statement
            String sql1 = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
            PreparedStatement pstmtSelect = conn.prepareStatement(sql1);
            pstmtSelect.setString(1, firstName);
            pstmtSelect.setString(2, lastName);
            ResultSet result = pstmtSelect.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("photo");
                InputStream inputStream1 = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream1.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream1.close();
                outputStream.close();
                System.out.println("File saved");
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }
            // sets the message in request scope
            request.setAttribute("message", message);
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp")
                .include(request, response);
        }
    }
