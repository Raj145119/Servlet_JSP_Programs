package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Employee;

public class EmpdeptwiseController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deptNoStr = request.getParameter("deptno");
		List<Employee> list  = new ArrayList<Employee>();
			//jdbc start
		Connection con  = null;
		Statement stmt  = null;
		ResultSet rs  = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="root";
			con  = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String sql="SELECT * from emp2 where deptno="+deptNoStr;
			rs  =stmt.executeQuery(sql);
			while(rs.next()){
				long id = rs.getLong("EMPNO");
				String name = rs.getString("ENAME");
				String job  = rs.getString("job");
				float salary  = rs.getFloat("sal");
				long deptno = rs.getLong("deptno");
				Employee emp  = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setJob(job);
				emp.setSalary(salary);
				emp.setDeptNumber(deptno);
				list.add(emp);
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
	
	
request.setAttribute("emplist", list);
RequestDispatcher rd=request.getRequestDispatcher("emp_view_bydept.jsp");
rd.forward(request, response);
		
		
		
		
	}

}
