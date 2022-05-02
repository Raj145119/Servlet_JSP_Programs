<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="student.com.pjo.Login"%>
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
<title>Insert title here</title>
</head>

<body>
<h1> <a href="Index.jsp"> <= Back...</a> </h1>
<%
 Login user  = (Login) session.getAttribute("record");
List<Student> stu=(List<Student>)request.getAttribute("View");
%>
<table border="1px" class="table table-hover"cellspacing="0px" cellpadding="0px" width="70%" align="center">
<tr height="40px" align="center" class="danger" style="font-size:30px">
<td>Id</td>
<td>Name</td>
<td>Gender</td>
<td>Email-Id</td>
<td>Branch-Id</td>
<%if(user!=null){ %>
<% if("super".equals(user.getRole()) ){ %>
<td>Operation</td>
<%} %>
</tr>
<%for(Student st:stu){ %>
<tr height="40px" style="text-align:center;font-size:20px" class="success">
<td><%=st.getId()%></td>
<td><%=st.getName()%></td>
<td><%=st.getGender()%></td>
<td><%=st.getEmailId()%></td>
<td><%=st.getBarchId()%></td>
<% if("super".equals(user.getRole()) ){ %>
<td>
<a href="delete?del=<%=st.getId()%>">Delete</a>&nbsp;
<a href="update?up=<%=st.getId()%>">Update</a></td>
<%} %>
</tr>
<%} %>
<%} %>
</table>
</body>
</html>