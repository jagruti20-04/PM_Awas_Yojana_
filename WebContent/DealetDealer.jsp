<%@page import="com.jagruti.dbcon.*" %>
<%@page import="java.sql.*" %>
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
<% 
try{
	 Connection con=DbConnection.connect();
	 
	 int id=Integer.parseInt(request.getParameter("did"));
	 PreparedStatement ps2=con.prepareStatement("delete from dealer_db where did=?");
	   ps2.setInt(1,id);
	   
	   
	   int i=ps2.executeUpdate();
	   
	   if(i>0)
	   {
		   response.sendRedirect("DealerView.jsp");  
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
%>

</body>
</html>