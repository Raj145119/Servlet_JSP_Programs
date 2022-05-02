<%@page import="student.com.pjo.Department" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
</head>
<%
Department dept=(Department)request.getAttribute("update");
%>
<body>
<center>
<table border="1px"cellpadding="0" cellspacing="0" height="250px"; width="40%">
<tr>
<td colspan="2" height="70px" bgcolor="#993300"></td>
</tr>
<tr>
<form action="dupdate" method="post" >
<td width="40%" style=" padding-left:20px; font-size:18px">Department Id</td>
<td><input type="text" name="d_id" style="height:40px; width:100%; background-color:#CCCCCC;"
 value="<%=dept.getDeparmentId()%>" readonly="readonly"></td>
</tr>

<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Hod</td>
<td><input type="text" name="h_name" style="height:40px; width:100%; background-color:#CCCCCC;"
 value="<%=dept.getHodName()%>"></td>
</tr>
<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Department</td>
<td><input type="text" name="d_name" style="height:40px; width:100%; background-color:#CCCCCC;"
value="<%=dept.getDepartmentName()%>"></td>
</tr>
<tr>
<td colspan="2" height="50px" bgcolor="#0000FF">
<input type="submit" value="Update" style="height:35px; width:19%; margin-left:170px;font-size:24px">
<input type="reset" value="Clear" style="height:35px; width:15%;font-size:24px">
<a href="Index.jsp" style="text-decoration:none; background-color:#E0E0E0;border:1px solid #000000; font-size:28px;">Home</a>
</td>
</tr>
</table>
</center>
</form>
</body>
</html>