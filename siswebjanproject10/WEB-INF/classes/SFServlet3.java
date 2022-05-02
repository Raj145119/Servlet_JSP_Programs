import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SFServlet3 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String formNumber = request.getParameter("stu_form_no");
		String name = request.getParameter("stu_name");
		String gender = request.getParameter("stu_gender");
		String mobile = request.getParameter("stu_mobile");
		String email = request.getParameter("stu_email");
		
		
		
		StringBuffer html = new StringBuffer();
	     html.append("<html>");
	     html.append("<body>");
		
		 html.append("<h1>Final Step</h1>");
	     html.append("<form action='sfu4' method='post'>");
	     html.append("<input type='hidden' name='stu_form_no' value='"+formNumber+"'>");
	     html.append("<input type='hidden' name='stu_name' value='"+name+"'>");
	     html.append("<input type='hidden' name='stu_gender' value='"+gender+"'>");
	     html.append("<input type='hidden' name='stu_mobile' value='"+mobile+"'>");
	     html.append("<input type='hidden' name='stu_email' value='"+email+"'>");
	    
	     html.append("Address<input type='text' name='stu_address'><br>");
	     html.append("CollegeName<input type='text' name='stu_college_name' ><br>");
	     
	     html.append("<input type='submit' value='next>>' >");
	     html.append("</form>");
	     
	     
	     html.append("</body>");
	     html.append("</html>");
	     response.setContentType("text/html");
	     PrintWriter pw  = response.getWriter();
		 pw.print(html);
		
		
	}// service

}// End of class
