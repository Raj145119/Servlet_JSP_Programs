import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SFServlet4 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String formNumber = request.getParameter("stu_form_no");
		String name = request.getParameter("stu_name");
		String gender = request.getParameter("stu_gender");
		String mobile = request.getParameter("stu_mobile");
		String email = request.getParameter("stu_email");
		String address = request.getParameter("stu_address");
		String collegeName = request.getParameter("stu_college_name");
		
		
		//jdbc code
		StringBuffer html = new StringBuffer();
	     html.append("<html>");
	     html.append("<body>");
	     html.append("<h1>Your form successfuly submited</h1><hr>");
	     html.append("<h1>FormNumber "+formNumber+"</h1>");
	     html.append("<h1>Name "+name+"</h1>");
	     html.append("<h1>Gender "+gender+"</h1>");
	     html.append("<h1>Mobile "+mobile+"</h1>");
	     html.append("<h1>Email "+email+"</h1>");
	     html.append("<h1>Address "+address+"</h1>");
	     html.append("<h1>College-Name "+collegeName+"</h1>");
	     
	     
	     
	     
	     html.append("</body>");
	     html.append("</html>");
	     response.setContentType("text/html");
	     PrintWriter pw  = response.getWriter();
		 pw.print(html);
		
		
	}// service

}// End of class
