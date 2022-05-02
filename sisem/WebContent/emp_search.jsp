<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="css/sis.css">
</head>
<body>
<a href="home.jsp">back to home</a>
<%
Object obj  = request.getAttribute("not_found_msg");
%>
<%if(obj!=null){%>
     <h1>NOT FOUND MSG :  <%=obj %></h1>
<%} %>


<!-- <fieldset><legend>Emp Search by Id</legend>
 <form action="empsearch">
  Enter emp No <input type="text" name="emp_id">
  <input type="submit" value="Find Employee">
 </form>
</fieldset>
 -->
 <%@include file="search_form.jsp" %>
 
</body>
</html>