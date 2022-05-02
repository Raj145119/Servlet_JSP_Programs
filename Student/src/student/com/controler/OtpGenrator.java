package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.com.pjo.SignUp;

public class OtpGenrator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("u_name");
		String mobile=request.getParameter("u_mobile");
		String uId=request.getParameter("u_id");
		String upassword=request.getParameter("u_password");		
		String otp="";		
	Connection con=null;
	PreparedStatement pstmt=null;
	SignUp us=null;
	int result;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="oracle:jdbc:thin:@localhost:1521:XE";
	    String user="system";
	    String password="system";
	    con=DriverManager.getConnection(url,user,password);
	    String sql="insert into signup_user(id,name,login_id,login_password,mobile,otp,is_active)"+
"values((select nvl(max(id),100) +1 from signup_user ),?,?,?,?,?,'no')";
	    pstmt=con.prepareStatement(sql);
	    pstmt.setString(1, name);
	    pstmt.setString(1,mobile);
	    pstmt.setString(1,uId);
	    pstmt.setString(1,upassword);
	     result=pstmt.executeUpdate();
	     
	    } catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	Random rand=new Random();
	for(int i=1;i<=6;i++){
		otp=otp+rand.nextInt(9);
	}
	 us=new SignUp();
	 us.setOTP(otp);
	  us.setName(name);
	  us.setMobile(mobile);
	  us.setLoginId(uId);
	  us.setLoginPassword(upassword);
	RequestDispatcher rd=null;
	request.setAttribute("OTP",us);
	rd=request.getRequestDispatcher("sign_up.jsp");
	rd.forward(request,response);
	}

}
