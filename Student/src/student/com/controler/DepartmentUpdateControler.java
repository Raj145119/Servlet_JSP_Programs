



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

	import student.com.pjo.Department;

	public class DepartmentUpdateControler  extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String ids=request.getParameter("upp");
			Connection con=null;
			Statement stmt=null;
			Department dept=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:XE";
				String user="system";
				String password="system";
				con=DriverManager.getConnection(url,user,password);
				String sql="select * from Department where department_id="+ids;
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
			}
			} catch (ClassNotFoundException e) {
	            System.out.println("Class not found");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Sql error");
				e.printStackTrace();
			}
		request.setAttribute("update",dept);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("update_dept_record.jsp");
		rd.forward(request,response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 PrintWriter pw=response.getWriter();
			
			 String ids=request.getParameter("d_id");
			String name=request.getParameter("h_name");
			String dname=request.getParameter("d_name");
			Connection con=null;
			PreparedStatement pstmt=null;
			boolean isUpdated=false;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:XE";
				String user="system";
				String password="system";
				
				con=DriverManager.getConnection(url,user,password);
				String sql="update Department set hod_name =?,department_name=? where department_id="+ids;
	  
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,dname);
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


	
			 
			 
