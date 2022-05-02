<%@page import="sis.com.bo.Department"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<a href="home.jsp">back to home</a>
<hr>

<%
    Object obj  = request.getAttribute("deptList");
   List<Department> list  = (List<Department>)obj;
%>
how many department  = <%=list.size() %>


 <table border="1">
   <caption>ALL dept List</caption>
  <tr>
   <th>ID</th>
   <th>NAME</th>
   <th>LOC</th>
  </tr>
  
  <%for(Department dept :list){ %>
  <tr>
   <td><%=dept.getId() %></td> 
   <td><%=dept.getName() %></td>
   <td><%=dept.getLocation() %></td>
  </tr>
  
   <%} %>
  
  
 </table>
</body>
</html>