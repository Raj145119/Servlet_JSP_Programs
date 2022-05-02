<%@page import="student.com.pjo.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
</head>
<%
Student st=(Student)request.getAttribute("update");
%>
<body>
<center>
<table border="1px"cellpadding="0" cellspacing="0" height="300px"; width="40%">
<tr>
<td colspan="2" height="70px" bgcolor="#993300"></td>
</tr>
<tr>
<form action="update" method="post" >
<td width="40%" style=" padding-left:20px; font-size:18px">Id</td>
<td><input type="text" name="u_id" style="height:40px; width:100%; background-color:#CCCCCC;"
 value="<%=st.getId()%>" readonly="readonly"></td>
</tr>

<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Name</td>
<td><input type="text" name="u_name" style="height:40px; width:100%; background-color:#CCCCCC;"
placeholder="  Enter Your Name " value="<%=st.getName()%>"></td>
</tr>
<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Email Id</td>
<td><input type="text" name="u_age" style="height:40px; width:100%; background-color:#CCCCCC;"
placeholder="  Enter Your Age" value="<%=st.getEmailId()%>"></td>
</tr>
<tr>
 <td width="40%" style=" padding-left:20px; font-size:18px">Gender</td>
<td height="40px" bgcolor="#CCCCCC">
Male<input type="radio" value="<%=st.getGender()%>"name="gender">
Female<input type="radio" value="<%=st.getGender()%>" name="gender">
Other<input type="radio" value="<%=st.getGender()%>" name="gender">
</td>
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