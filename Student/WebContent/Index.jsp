<%@page import="student.com.pjo.Login"%>
<%@include file="Header.jsp" %>
<%
String bag="img/../img/img5.jpg";
Login user=null;
String act="active";
String title="";
Object obj=session.getAttribute("record");
 user=(Login)obj;
%>
<body style="  background:url(img/../img/ba88.bmp); height:1000px" >
<%if(user!=null){%>

<span style="color:red; font-size:20px">welcome:</span> <span style="color:white;font-size:20px"> <%=user.getName()%></span>
<br> 
<span style="color:red; font-size:20px;">Role:</span><span style="color:white; font-size:20px;"> <%=user.getRole()%></span>
<br><a href="logout"><span  style=" color:#66FF00;font-size:30px">Logout</span></a>
 <%if(user.getRole().equals("user")){ 
act="disabled";
title="Access only Admin user";
%>
<%}%>

<div align="center"> 
<a href="Index.jsp"><button class="btn btn-warning btn-lg glyphicon glyphicon-home">Home</button></a>
<a href="getdept" title="<%=title%>"><button class="btn btn-info btn-lg active" <%=act%>>Add Student</button></a>
<a href="addDept.jsp" title="<%=title%>"><button class="btn btn-success btn-lg active" <%=act%>>Add Department</button></a>
<a href="view"><button class="btn btn-warning btn-lg active">View Record</button></a>
<a href="deptView" title="<%=title%>" ><button class="btn btn-success btn-lg active" <%=act%>>View Department</button></a>
</div>
<div align="center">

<form class="search-form" action="search" method="post">
<input type="text" name="search" placeholder="Search" style="padding-top:5px; margin-top:8px;">
<button class="btn btn-success btn-xs">Search</button>
</form>

</div>
<%}else{%>
</div>
<div class="navbar navbar-inverse" style="margin-bottom:0px;">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand">MySite</a>
</div>
<form action="search" method="post">
<ul class="nav navbar-nav">
<li><a href="Index.jsp"><span class="glyphicon glyphicon-home"></span> Home </span></a></li>
<li class="dropdown">
<a href="#" class="dropdown-toggle"  data-toggle="dropdown">About <span class="caret"></span></a>
<ul class="dropdown-menu" style="background-color:#910000;">
<li><a href="#" style="color:#0000FF">About Campus</a></li>
<li><a href="#" style="color:#0000FF">About Placement</a></li>
<li><a href="#" style="color:#0000FF">About new information..</a></li>
</ul>
</li>
<li><a href="#">Gmail</a></li>
<li><a href="#">Facebook</a></li>
<li><a href="#"><span class="glyphicon glyphicon-phone-alt"></span> Contact us</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li>
<form class="search-form">
<input type="text" name="search" placeholder="Search" style="padding-top:5px; margin-top:8px;">
<button class="btn btn-success btn-xs">Search</button>
</form>
</li>
<li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span>Login</a></li>
<li><a href="signup"><span class="glyphicon glyphicon-user"></span>Signup</a></li>
<li><a href="#">More <span class="glyphicon glyphicon-triangle-right"></span></a></li>
<li><img src="img/../img/india.png" height="30px" width="60%" style="margin-top:10px"></li>
</ul>
</form>
</div>
</div>
<%} %>
<div>
</div>
</body>
</html>