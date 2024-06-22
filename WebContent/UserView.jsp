<%@page import="com.jagruti.dbcon.*" %>
<%@page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<%@page import="com.jagruti.operation.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>   
<head> 
<head>
<title>Visitors an Admin Panel Category Bootstrap Responsive Website Template | Login :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
 
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;
     box-sizing: border-box;100px 10px>  
}  
button {   
       background-color:black;;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;  
          
         }   
 
 input[type=text], input[type=password] {   
        width: 300px;   
        margin: 5px 0;  
        padding: 5px 5px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;
         
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px; 
           box-sizing: border-box;100px 10px>
          
          
    }
    .table {
      border-collapse: collapse;
       position: absolute;
       top: 100px;
        left: 300px;
        width: 70%;
        height: 70px;
         padding: 5px 5px;
        border-bottom: 1px solid black;
        
 
    }    
    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid white;
       
       width: 10%;
       height: 10px;
    }
     td {
      
      color: solid black;
      text-transform: uppercase;
      
    }
   
    th {
      background-color:#f2f2f2;
      color: white;
      text-transform: uppercase;
      
    }
</style>   
</head>    
<body> 
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
      <h5 >Pradhan Mantri Awas Yojana</h5>
       <h6>Welcome to user Login </h6>
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->
<div class="nav notify-row" id="top_menu">
    <!--  notification start -->
    <ul class="nav top-menu">
        
               
       
      
    </ul>

</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
       
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                
                <span class="username">Admin </span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="login.html"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="Index.html">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>Task Bar</span>
                    </a>
                    <ul class="sub">
						<li><a href="registration.html">Add Dealers</a></li>
						<li><a href="DealerView.jsp">View Dealers</a></li>
						 <li><a href="UserView.jsp">View Awas </a></li>
						<li><a href="addAwas.html">Add Awas</a></li>
                        
                       
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>View Awas Report</span>
                    </a>
                    <ul class="sub">
						<li><a href="Viewhome.jsp">View Submitted Photo</a></li>
						<li><a href="ViewComplaint.jsp">View Complaints</a></li>
						 <li><a href="BillView.jsp">Submitted Bills</a></li>
						
                        
                       
                    </ul>
                </li>
                 
               
                
                
               
               
               
               
                <li>
                    <a href="login.html">
                        <i class="fa fa-user"></i>
                        <span>Log Out</span>
                    </a>
                </li>
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
     
        <div class="container">  
     
<center><table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'
         
     >
<tr >
           
           <th style="color:Black">User ID</th>
    <th style="color:Black" >User Name</th>
    <th style="color:Black">User Phone Number</th>
    <th style="color:Black">User Email</th>
    <th style="color:Black">City</th>
    <th style="color:Black">Region</th>
    <th style="color:Black">Location</th>
    <th style="color:Black">Plan title</th>
    
     <th style="color:Black"></th>
           
            
          </tr>
         
         
  <%
 
 
  try{
	   Connection con=DbConnection.connect();
	   
	   PreparedStatement ps2=con.prepareStatement("select * from awas_db ");
	   
	   
	   ResultSet rs=ps2.executeQuery();
	   while(rs.next())
	   {
  %>
<tr>
     <td style="color:Black"><%= rs.getString("uid")%></td>
    <td style="color:Black"><%= rs.getString("uname")%></td>
     <td style="color:Black"><%= rs.getString("uphone")%></td>
     <td style="color:Black"><%= rs.getString("uemail")%></td>
     <td style="color:Black"><%= rs.getString("ucity")%></td>
     <td style="color:Black"><%= rs.getString("uregion")%></td>
     <td style="color:Black"><%= rs.getString("ulocation")%></td>
     <td><a href="viewImage.jsp?uid=<%=rs.getString("uid") %>">PLAN TITLE</a></td>
      


	<% 

	   

		
%>
      <td><a href="DeleteAwas.jsp?did=<%=rs.getString("uid") %>">Delete</a></td>
    
    
     
  </tr>
  <% 
	     
	 }
  }
  catch(Exception e)
  {
	  e.printStackTrace();
	  response.sendRedirect("error.html");
  }
    
  %>
  
</table></center>
 </div>
 <script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
    
        
</body>     
</html>  