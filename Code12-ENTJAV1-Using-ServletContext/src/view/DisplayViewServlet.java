package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

public class DisplayViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the bound object set by the first Servlet (Controller).
		StudentBean student = (StudentBean) request.getAttribute("estudyante");
						
		//We are now ready to send the response back to client.
		response.setContentType("text/html"); //set the MIME type
						
		//Create a PrintWriter object.
		PrintWriter out = response.getWriter();
						
		out.print("<html>");
		out.print("<head><title>Grade Computation using JavaBean</title></head>");
		out.print("<body>");
		out.print("<h2>Grade Computation using Model View Controller</h2>");
		out.print("<p>Student ID: <b>" + student.getId() + "</b></p>");
		out.print("<p>Name: <b>" + student.getName() + "</b></p>");
		out.print("<p>Midterm Grade: <b>" + student.getMidterm() + "</b></p>");
		out.print("<p>PreFinal Grade: <b>" + student.getPreFinal() + "</b></p>");
		out.print("<p>Final Grade: <b>" + student.getFinalGrade() + "</b></p>");			
		out.print("<p>Remarks: " + student.getRemarks() + "</p>");
		out.print("<p><i>Note - " + getServletContext().getInitParameter("passingMark") 
								  + "% is the passing score.</i></p>");
		out.print("<p>Date Accessed: <i>" + new Date() + "</i></p>");
		out.print("<hr/>");
		out.print("<form action='index.html'>");
		out.print("    <input type='submit' value='<< GO BACK >>'/>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
						
		out.close();			
	}
}
