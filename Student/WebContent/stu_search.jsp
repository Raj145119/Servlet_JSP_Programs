<%@page import="java.util.List"%>
<%@page import="student.com.pjo.Student"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" />
<script  src="Bootstrap/js/jquery.js"></script>
<script  src="Bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
<%
List<Student>stu=(List<Student>)request.getAttribute("search");
%>
</head>
<body>
<%
if(!stu.isEmpty()){
%>
<table border="1px" cellspacing="0px" cellpadding="0" width="40%" align="center">
<tr style="background-color:blue
">
<td>ID</td>
<td>Name</td>
<td>gender</td>
<td>Email</td>
<td>Branch ID</td>
</tr>
<%for(Student st:stu){ %>
<tr>
<td><%=st.getId()%></td>
<td><%=st.getName()%></td>
<td><%=st.getGender()%></td>
<td><%=st.getEmailId()%></td>
<td><%=st.getBarchId()%></td>
</tr>
<%} %>
</table>
<%} else{%>
<h1>Record not found...</h1>
<%} %>
</body>
</html>