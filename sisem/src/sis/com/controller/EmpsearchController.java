package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Employee;
public class EmpsearchController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String idStr = request.getParameter("emp_id");
	
	Employee foundEmp  = null;
	
	//jdbc start
Connection con  = null;
Statement stmt  = null;
ResultSet rs  = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="system";
	con  = DriverManager.getConnection(url, user, password);
	stmt = con.createStatement();
	String sql="SELECT * from emp2 where empno="+idStr;
	rs  =stmt.executeQuery(sql);
	if(rs.next()){
		long id = rs.getLong("empno");
		String name = rs.getString("ENAME");
		String job  = rs.getString("job");
		float salary  = rs.getFloat("sal");
		long deptno = rs.getLong("deptno");
		foundEmp  = new Employee();
		foundEmp.setId(id);
		foundEmp.setName(name);
		foundEmp.setJob(job);
		foundEmp.setSalary(salary);
		foundEmp.setDeptNumber(deptno);
	}
	
	
} catch (ClassNotFoundException e) {
	e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
}finally{
	try {
		if(con!=null){
			con.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//jdbc end
	
RequestDispatcher rd  = null;

if(foundEmp==null){
//not found
	String notFoundMsg = "There are no such employee exist for give id "+ idStr;
	request.setAttribute("not_found_msg", notFoundMsg); 
	rd  = request.getRequestDispatcher("emp_search.jsp");
}else{
	//found 
	request.setAttribute("emp", foundEmp);
	rd  = request.getRequestDispatcher("emp_search_result.jsp");
	
}
 

rd.forward(request, response);



	
	
	}
 

}
