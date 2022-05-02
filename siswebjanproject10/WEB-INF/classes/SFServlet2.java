import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SFServlet2 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String formNumber = request.getParameter("stu_form_no");
		String name = request.getParameter("stu_name");
		String gender = request.getParameter("stu_gender");
		
		StringBuffer html = new StringBuffer();
	     html.append("<html>");
	     html.append("<body>");
		 html.append("<h1>step2</h1>");
	     html.append("<form action='sfu3' method='post'>");
	     html.append("<input type='hidden' name='stu_form_no' value='"+formNumber+"'>");
	     html.append("<input type='hidden' name='stu_name' value='"+name+"'>");
	     html.append("<input type='hidden' name='stu_gender' value='"+gender+"'>");
	    
	     html.append("Mobile<input type='text' name='stu_mobile'><br>");
	     html.append("email<input type='text' name='stu_email' ><br>");
	     
	     html.append("<input type='submit' value='next>>' >");
	     html.append("</form>");
	     
	     
	     html.append("</body>");
	     html.append("</html>");
	     response.setContentType("text/html");
	     PrintWriter pw  = response.getWriter();
		 pw.print(html);
		
		
	}// service

}// End of class
