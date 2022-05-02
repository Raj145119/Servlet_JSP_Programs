<%@page import="java.util.List"%>
<%@page import="student.com.pjo.Login"%>
<%@page import="student.com.pjo.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" />
<script  src="Bootstrap/js/jquery.js"></script>
<script  src="Bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DeptView</title>
</head>

<body>
<h1><a href="Index.jsp">Back to Home</a></h1>
<%
List<Department> stu=(List<Department>)request.getAttribute("deptView");
%>
<table border="1px" class=" table table-hover "cellspacing="0px" cellpadding="0px" width="70%" align="center">
<tr height="40px" align="center" class="danger" style="Background-color:blue;font-size:30px">
<td>Id</td>
<td>Name</td>
<td>Hod Name</td>
<td>Operation</td>
</tr>
<%for(Department st:stu){ %>
<tr height="40px" style="background-color:#999999;text-align:center;font-size:20px">
<td><%=st.getDeparmentId()%></td>
<td><%=st.getDepartmentName()%></td>
<td><%=st.getHodName()%></td>
<td><a href="del?del=<%=st.getDeparmentId()%>">Delete</a>&nbsp;
<a href="dupdate?upp=<%=st.getDeparmentId()%>">Update</a></td>
</tr>
<%} %>
</table>
</body>
</html>