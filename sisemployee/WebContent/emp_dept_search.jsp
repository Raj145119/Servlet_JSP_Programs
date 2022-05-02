<%@page import="sis.com.bo.Department"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
List<Department>deptlist =(List<Department>) request.getAttribute("deptList"); 
%>

<form action="empdeptwise">
  choose dept
  <select name="deptno">
      <%for(Department dept : deptlist) {%>
		<option value='<%=dept.getId()%>'><%=dept.getName() %>  [<%=dept.getId()%>]</option>
	 <%} %>	
  </select>
  <input type="submit" value="Get emp by Dept">

</form>

</body>
</html>