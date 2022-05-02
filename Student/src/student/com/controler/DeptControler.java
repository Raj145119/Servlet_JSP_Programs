package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptControler extends HttpServlet {
	private static final long serialVersionUID1 = 1L;
       
   
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		String dname=request.getParameter("dept");
		String hname=request.getParameter("hod");
		Connection con=null;
		boolean isInserted=false;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="insert into Department (department_id ,department_name,hod_name) values((select nvl(max(department_id),1000)+1 from Department),?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,dname);
			pstmt.setString(2,hname);
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
	pw.print("<a href='Index.jsp'>Back to Home</a><br>");
	pw.print("<a href='addDept.jsp'>Add New Department</a>");
	pw.print("<h1>Branch inserted successfully</h1>");
}else{
	pw.print("<a href='Index.jsp'>Back to Home</a><br>");
	pw.print("<a href='addDept.jsp'>Add New Department</a>");
	pw.print("<h1>Brach exist</h1>");
}
		
	}
 
}


