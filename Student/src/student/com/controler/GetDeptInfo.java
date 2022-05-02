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

public class GetDeptInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Department>list=new ArrayList<Department>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
 			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="select department_id,department_name from Department";
		    pstmt=con.prepareStatement(sql);
		    rs=pstmt.executeQuery();
			while(rs.next()){
				String name=rs.getString("department_name");
				long id=rs.getLong("department_id");
				Department dp=new Department();
				dp.setDepartmentName(name);
				dp.setDeparmentId(id);
				list.add(dp);
			}
			
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
		
		RequestDispatcher rd=null;
		 request.setAttribute("Add",list);
		rd=request.getRequestDispatcher("addRecord.jsp");
		 rd.forward(request,response);
		 
	}
	
}


