package student.com.controler;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.com.pjo.Student;

public class ViewRecordControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		Student stu=null;
		ArrayList<Student>list=new ArrayList<Student>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="select * from Student5";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
		long id=rs.getLong("id");
		String name=rs.getString("name");
		String gender=rs.getString("gender");
		String email=rs.getString("email_id");
		long bId=rs.getLong("branch_id");
		 stu=new Student();
		 stu.setId(id);
		 stu.setName(name);
		 stu.setEmailId(email);
		 stu.setBarchId(bId);
		 stu.setGender(gender);
		 list.add(stu);
		}
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
	request.setAttribute("View",list);
	RequestDispatcher rd=null;
	rd=request.getRequestDispatcher("student_view.jsp");
	rd.forward(request,response);
	
	}

}
