<%@page import="sis.com.bo.Employee"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
Employee emp  = (Employee) request.getAttribute("emp");

%>

<fieldset><legend>Emp Details</legend>
ID:<%=emp.getId() %><br>
Name:<%=emp.getName() %><br>
JOB<%=emp.getJob() %><br>
Salary<%=emp.getSalary() %><br>
dept no<%=emp.getDeptNumber() %><br>
</fieldset>

<%-- <%@include file="search_form.jsp" %> --%>
<a href="emp_search.jsp">Other search</a>
<hr>
<jsp:include page="search_form.jsp"></jsp:include>

</body>
</html>