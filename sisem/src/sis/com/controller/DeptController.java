package sis.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sis.com.bo.Department;

/**
 * Servlet implementation class DeptController
 */
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //1
		//fetch require parameter if present
		
	//2	//create model object
     ArrayList<Department> list = new ArrayList<Department>();		
		
	//3	//fill this list with data
		//jdbc ??
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
		String sql="SELECT DEPTNO,DNAME,LOC FROM DEPT";
		rs  =stmt.executeQuery(sql);
		while(rs.next()){
			long id = rs.getLong("deptno");
			String name = rs.getString("dname");
			String location  = rs.getString("loc");

			//create new object and fill it	
			Department dept  = new Department();
			dept.setId(id);
			dept.setName(name);
			dept.setLocation(location);
			//add to list
			list.add(dept);	
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
    //end of jdbc
	//4	//set attribute 
	request.setAttribute("deptList", list);	
	 RequestDispatcher rd = null;
	 rd = request.getRequestDispatcher("dept_view.jsp");
	 rd.forward(request, response);
		
	}

}
