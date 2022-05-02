package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.com.pjo.Login;

public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter pw= response.getWriter();
     String userName=request.getParameter("u_name");
     String userPassword=request.getParameter("u_password");
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet result=null;
    Login usr=null;
      try {
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
		   String url="jdbc:oracle:thin:@localhost:1521:XE";
		   String user="system";
		   String password="system";
    	  con=DriverManager.getConnection(url,user,password);
    	  String sql="select * from stu_login where login_id=? and login_password=?";
    	  pstmt=con.prepareStatement(sql);
    	  pstmt.setString(1,userName);
    	  pstmt.setString(2,userPassword);
    	  result=pstmt.executeQuery();
    	  if(result.next()){
	    	  long id=result.getLong("id");
	    	  String name=result.getString("name");
	    	  String role=result.getString("role");
	    	   usr=new Login();
	    	  usr.setId(id);
	    	  usr.setName(name);
	    	  usr.setRole(role);
    	  }
	} catch (SQLException e) {
  System.out.println("sql error");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
   System.out.println("Calss not found");
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	if(usr!=null){
		    HttpSession session=request.getSession();
		    session.setAttribute("record",usr);
		    response.sendRedirect("Index.jsp");
	}else{
		
		    HttpSession session=request.getSession();
		    //session.setAttribute("record", "welcome");
		    response.sendRedirect("Login.jsp");
	}
      
	}
	}
}