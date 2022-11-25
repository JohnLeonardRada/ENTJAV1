package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double midterm = Double.parseDouble(request.getParameter("midterm"));
		double preFinal = Double.parseDouble(request.getParameter("preFinal"));
		
			StudentBean student = new StudentBean(id, name, midterm, preFinal);
			//Perform business logic methods
			student.computeFinalGrade();
			student.determineRemarks();
			
			//Ready to send the response back to client
			/*Multipurpose Internet Mail Extension (MIME) - web server tells
			what type of data the web browser will receive from the web server*/
			
			response.setContentType("text/html"); //set the MIME type
			
			//Create a printWriter object
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>Grade Computation using JavaBean</title></head>");
			out.print("<body>");
			out.print("<h2>Grade Computation using JavaBean</h2>");
			out.print("<p>Student ID: <b>" + id + "</b></p>");
			out.print("<p>Name: <b>" + name + "</b></p>");
			out.print("<p>Midterm Grade: <b>" + midterm + "</b></p>");
			out.print("<p>PreFinal Grade: <b>" + preFinal + "</b></p>");
			out.print("<p>Final Grade: <b>" + student.getFinalGrade() + "</b></p>");			
			out.print("<p>Remarks: " + student.getRemarks() + "</p>");
			out.print("<hr/>");
			out.print("<form action='index.html'>");
			out.print("    <input type='submit' value='<< GO BACK >>'/>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
			
			out.close();					
	}
	
	public void destroy() {
		System.out.println("destroy method activated");		
	}
}