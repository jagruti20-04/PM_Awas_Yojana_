<%@page import="com.jagruti.dbcon.*" %>
<%@page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<%@page import="com.jagruti.operation.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Blob image = null;

	

	byte[ ] imgData = null ;

	Statement stmt = null;

	

	try {
         Connection con=DbConnection.connect();
         int id=Integer.parseInt(request.getParameter("uid"));
		   PreparedStatement ps2=con.prepareStatement("select planTitle from awas_db where uid=?");
		   ps2.setInt(1,id);
		   
		   ResultSet rs=ps2.executeQuery();

		

		if (rs.next()) {

		image = rs.getBlob(1);


		imgData = image.getBytes(1,(int)image.length());

	} 


// display the image

response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);


o.flush();

o.close();

} catch (Exception e) {

out.println("Unable To Display image");



return;


}

%>
</body>
</html>