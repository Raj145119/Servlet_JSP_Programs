package student.com.controler;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import student.com.pjo.Department;


public class DeptViewControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		Department dept=null;
		ArrayList<Department>list=new ArrayList<Department>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="select * from Department";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
		long id=rs.getLong("department_id");
		String dname=rs.getString("department_name");
		String hod=rs.getString("hod_name");
		 dept=new Department();
		 dept.setDeparmentId(id);
		 dept.setDepartmentName(dname);
		 dept.setHodName(hod);
		 list.add(dept);
		}
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
	request.setAttribute("deptView",list);
	RequestDispatcher rd=null;
	rd=request.getRequestDispatcher("department_view.jsp");
	rd.forward(request,response);
	
	}

}
