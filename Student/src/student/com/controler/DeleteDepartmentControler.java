
	package student.com.controler;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.*;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	public class DeleteDepartmentControler extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		String ids=request.getParameter("del");
		long id=Long.parseLong(ids);
		PrintWriter pw=response.getWriter();
		
		Connection con=null;
		boolean isDeleted=false;
		Statement st=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			con=DriverManager.getConnection(url,user,password);
			String sql="delete from Department where department_id="+id;
			st=con.createStatement();
			int rs=st.executeUpdate(sql);
			if(rs==1){
				isDeleted=true;
				
			}
		} catch (ClassNotFoundException e) {
	        System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
		if(isDeleted){
			pw.print("<h1><a href='Index.jsp'>Back to Home</a></h1>");
			pw.print("<h1>Record deletd successfully</h1>");
		}else{
			pw.print("<h1><a href='Index.jsp'>Back to Home</a></h1>");
			pw.print("<h1>Record can not be deletd if you want to delete at first you must be delete record of all student</h1>");
		}
		}

	}


