<%@page import="java.util.List"%>
<%@page import="student.com.pjo.Department" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Department> dpt=(List<Department>)request.getAttribute("Add");
%>
<form action="record" method="post">
<center>
<table border="1px"cellpadding="0" cellspacing="0" height="300px"; width="40%">
<tr>
<td colspan="2" height="70px" bgcolor="#993300"></td>
</tr>
<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Name</td>
<td><input type="text" name="u_name" style="height:40px; width:100%; background-color:#CCCCCC;"placeholder="  Enter Your Name "></td>
</tr>
<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Email Id</td>
<td><input type="text" name="u_age" style="height:40px; width:100%; background-color:#CCCCCC;"placeholder="  Enter Your Age"></td>
</tr>
<tr>
 <td width="40%" style=" padding-left:20px; font-size:18px">Gender</td>
<td height="40px" bgcolor="#CCCCCC">
Male<input type="radio" value="male" name="gender">
Female<input type="radio" value="female" name="gender">
Other<input type="radio" value="other" name="gender">
</td>
</tr>
<tr>
<td width="40%" style=" padding-left:20px; font-size:18px">Branch</td>
<td>
<%if(dpt!=null){ %> 
<select name="dept" style="height:40px; width:50%; margin-left:10px; font-size:26px;">
<option>select</option>
<%for(Department dd:dpt){%>
<option value='<%=dd.getDeparmentId()%>'> <%=dd.getDepartmentName()%> </option>
<%}%>
</select>
<%}%>
</td>
</tr>
<tr>
<td colspan="2" height="50px" bgcolor="#0000FF">
<input type="submit" value="Add" style="height:35px; width:15%; margin-left:170px;font-size:24px">
<input type="reset" value="Clear" style="height:35px; width:15%;font-size:24px">
<a href="Index.jsp" style="text-decoration:none; background-color:#E0E0E0;border:1px solid #000000; font-size:28px;">Home</a>
</td>
</tr>

</table>
</center>
</form>
</body>
</html>