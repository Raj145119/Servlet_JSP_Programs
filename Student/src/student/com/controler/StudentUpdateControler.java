package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.com.pjo.Student;

public class StudentUpdateControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("up");
		Connection con=null;
		Statement stmt=null;
		Student stu=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="select * from Student5 where id="+ids;
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
		
		}
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
	request.setAttribute("update",stu);
	RequestDispatcher rd=null;
	rd=request.getRequestDispatcher("update_stu_record.jsp");
	rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
		
		 String ids=request.getParameter("u_id");
		String name=request.getParameter("u_name");
		String emailId=request.getParameter("u_age");
		String gender=request.getParameter("gender");
		String department=request.getParameter("dept");
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isUpdated=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			
			con=DriverManager.getConnection(url,user,password);
			String sql="update Student5 set name=?,email_id=?,gender=? where id="+ids;
  
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name.toUpperCase());
			pstmt.setString(2,emailId);
			pstmt.setString(3,gender);
			int rs=pstmt.executeUpdate();
			if(rs==1){
				isUpdated=true;
			}
			
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
		
		if(isUpdated){
			pw.print("<a href='Index.jsp'>Back to Home</a><br>");
			pw.print("<a href='addRecord.jsp'>Add record</a>");
pw.print("<h1 style='background-color:black;color:white; width:40%'>Record Updated Sucess fully<h1>");
		}else{
			pw.print("<a href='addRecord.jsp'>Add record</a><br>");
			pw.print("<a href='Index.jsp'>Back to Home</a>");
			pw.print("<h1 style='background-color:black;color:white; width:40%'>Record not updated<h1>");
		}
		
	}


}
		 
		 
