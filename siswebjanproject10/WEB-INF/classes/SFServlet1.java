import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SFServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		long formNumber = System.currentTimeMillis();
		StringBuffer html = new StringBuffer();
	     html.append("<html>");
	     html.append("<body>");
	     html.append("<h1>step1</h1>");
	     html.append("<form action='sfu2' method='post'>");
	     html.append("FN<input type='text' name='stu_form_no'value='"+formNumber+"' readonly='readonly'><br>");
	     html.append("Name<input type='text' name='stu_name' ><br>");
	     html.append("Gender<input type='text' name='stu_gender' ><br>");
	     html.append("<input type='submit' value='next>' >");
	     html.append("</form>");
	     
	     
	     
	     html.append("</body>");
	     html.append("</html>");
	     response.setContentType("text/html");
	     PrintWriter pw  = response.getWriter();
		 pw.print(html);
		
		
	}// service

}// End of class
