<%@page import="student.com.pjo.SignUp" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" />
<script  src="Bootstrap/js/jquery.js"></script>
<script  src="Bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String otp="";
String status="disabled";
String name="";
String mobile="";
String uId="";
String uPassword="";
Object obj=request.getAttribute("OTP");
SignUp us=null;
if(obj!=null){
us=(SignUp)obj;
name=us.getName();
mobile=us.getMobile();
uId=us.getLoginId();
uPassword=us.getLoginPassword();
otp=us.getOTP();
out.print(otp);
}
%>


<form action="sign" method="post">
<table class="table table-bordered" style="width:35%;height:400px; margin-top:20px" align="center" background="img/../img/img8.jpg">
<tr style="height:100px;">
<td colspan="2" style="text-align:center;font-size:40px;background-color:#993300">
Registration
</td>
</tr>
<tr>
<td width="35%" style="color:white;font-size:18px">User Name</td>
<td><input type="text" name="u_name" value="<%=name%>"style="height:40px; width:100%;border-radius:5px; font-size:20px" autofocus="autofocus"></td>
</tr>
<tr>
<td style="color:white;font-size:18px">Mobile No</td>
<td><input type="text" value="<%=mobile%>"name="u_mobile" maxlength="10" type="text" style="height:40px; width:100%;border-radius:5px;font-size:20px" ></td>
</tr>
<tr>
<td style="color:white;font-size:18px">User ID</td>
<td><input type="text" value="<%=uId%>" name="u_id" type="text" style="height:40px; width:100%;border-radius:5px;font-size:20px"></td>
</tr>
<tr>
<td style="color:white;font-size:18px">User Password</td>
<td><input type="password" value="<%=uPassword %>"name="u_password"type="text" style="height:40px; width:100%; border-radius:5px;font-size:20px"></td>
</tr>
<tr style="height:60px">
<td colspan="2">
<span style="color:white;font-size:18px">OTP</span> &nbsp;<input type="text" name="OTPP" style="height:40px; width:30%;border-radius:5px;margin-left:70px" maxlength="6">
&nbsp;
<a><button class="btn btn-info active">Send OTP</button></a>
</td>
</tr>
<tr style="height:60px">
<td colspan="2">
<input type="submit" value="Sign-Up">
</td>
</tr>
</table>
</form>
</body>
</html>