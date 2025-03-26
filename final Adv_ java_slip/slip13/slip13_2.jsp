<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@ page import="java.sql.*;" %>
<%! inthno;
String hname,address; %>
<%
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

Connection cn=DriverManager.getConnection("jdbc:odbc:hospital_data","","");
Statement st=cn.createStatement();
ResultSetrs=st.executeQuery("select * from Hospital");
%>
<table border="1" width="40%"> <tr> <td>Hospital No</td> <td>Name</td> <td>Address</td> </tr> <% while(rs.next()) { %> <tr><td><%= rs.getInt("hno") %></td> <td><%= rs.getString("hname") %></td> <td><%= rs.getString("address") %> </tr> <%
}
cn.close();
}catch(Exception e)
{
out.println(e);
}
%>
</body>
</html>