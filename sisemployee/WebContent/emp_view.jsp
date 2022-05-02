<%@page import="sis.com.bo.Employee"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<a href="home.jsp">back to home</a>
<hr>
<%
List<Employee> list  = (List<Employee>)  request.getAttribute("emplist");

%>
<h1>TOTAL EMPLOYEE : <%=list.size() %></h1>

 <table border="1" width="100%">
   <caption>ALL Emp List</caption>
  <tr>
   <th>ID</th>
   <th>NAME</th>
   <th>JOB</th>
   <th>SALARy</th>
   <th>DEPT NO</th>
   <th>Action</th>
  </tr>
  
  <%for(Employee emp : list){ %>
  	
  	<tr>
   <td><%=emp.getId() %></td>
   <td><%=emp.getName() %></td>
   <td><%=emp.getJob() %></td>
   <td><%=emp.getSalary() %></td>
   <td><%=emp.getDeptNumber() %></td>
   <td>
      <a href="#">View</a>
      <a href="#">Update</a>
      <a href="#">Delete</a>
     </td>
  </tr>
  	
  <%} %>
  
 </table>


</body>
</html>