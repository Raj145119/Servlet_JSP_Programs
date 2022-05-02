package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class AddRecordControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("u_name");
		String emailId=request.getParameter("u_age");
		String gender=request.getParameter("gender");
		String department=request.getParameter("dept");
		name=name.toUpperCase();
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isInserted=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			
			con=DriverManager.getConnection(url,user,password);
			String sql="insert into Student5 (id,name,email_id,gender,branch_id) "+
  "values (((select nvl(max(id),100)+1 from Student5)),?,?,?,?)";

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,emailId);
			pstmt.setString(3,gender);
			pstmt.setString(4,department);
			int rs=pstmt.executeUpdate();
			if(rs==1){
				isInserted=true;
			}
			
		} catch (ClassNotFoundException e) {
            System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
		
		if(isInserted){
			
			pw.print("<a href='Home.jsp'>Back to Home</a><br>");
			pw.print("<a href='getdept'>Add record</a>");
		pw.print("<h1 style='background-color:black;color:white; width:40%'>Record Inserted Sucess fully<h1>");
		
		}else{
			
			pw.print("<a href='getdept'>Add record</a><br>");
			pw.print("<a href='Index.jsp'>Back to Home</a>");
			pw.print("<h1 style='background-color:black;color:white; width:40%'>Record not inserted<h1>");
		
		}
		
	}
	

}
