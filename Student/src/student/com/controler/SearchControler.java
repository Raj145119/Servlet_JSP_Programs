package student.com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.com.pjo.Student;

public class SearchControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String searchId=request.getParameter("search");
		PrintWriter pw=response.getWriter();
		
		Connection con=null;
		boolean isDeleted=false;
		Statement st=null;
		ResultSet rs=null;
		boolean isValid=false;
		boolean isSearch=false;
		Student stu=null;
	ArrayList<Student>list=new ArrayList<Student>();	
		
		for(int index=0;index<searchId.length();index++){
			char ch=searchId.charAt(index);
				if(ch>='A' && ch<='Z' ||ch>='a'&&ch<='z'){
					isValid=true;
				}
			}
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			String sql=null;
			con=DriverManager.getConnection(url,user,password);
			if(!isValid){
			 sql="select * from Student5 where id="+searchId;
			}else{
				searchId=searchId.toUpperCase(); 
				sql="select * from Student5 where  name like('"+searchId+"')";
			}
			st=con.createStatement();
			 rs=st.executeQuery(sql);
			while(rs.next()){
				long id=rs.getLong("id");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String email=rs.getString("email_id");
		         long bid=rs.getLong("branch_id");
				stu=new Student();
				stu.setId(id);
				stu.setName(name);
				stu.setEmailId(email);
				stu.setGender(gender);
				stu.setBarchId(bid);
				list.add(stu);
				isSearch=true;
			}
		} catch (ClassNotFoundException e) {
	        System.out.println("Class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql error");
			e.printStackTrace();
		}
		
	request.setAttribute("search",list);
	RequestDispatcher rd=null;
	rd=request.getRequestDispatcher("stu_search.jsp");
	rd.forward(request,response);
		}

		}
	


