package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private double midterm;
	private double preFinal;
	
	private double finalGrade;
	private String remarks;
	
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method activated");
		
		id="";
		name="";
		remarks="";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.id = request.getParameter("id");
		this.name = request.getParameter("name");
		this.midterm = Double.parseDouble(request.getParameter("midterm"));
		this.preFinal = Double.parseDouble(request.getParameter("preFinal"));
		
			//Perform business logic methods
			computeFinalGrade();
			determineRemarks();
			
			//Ready to send the response back to client
			/*Multipurpose Internet Mail Extension (MIME) - web server tells
			what type of data the web browser will receive from the web server*/
			
			response.setContentType("text/html"); //set the MIME type
			
			//Create a printWriter object
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>Grade Computation using on web.xml Deployment Descriptor</title></head>");
			out.print("<body>");
			out.print("<h2>Grade Computation using on web.xml Deployment Descriptor</h2>");
			out.print("<p>Student ID: <b>" + this.id + "</b></p>");
			out.print("<p>Name: <b>" + this.name + "</b></p>");
			out.print("<p>Midterm Grade: <b>" + this.midterm + "</b></p>");
			out.print("<p>PreFinal Grade: <b>" + this.preFinal + "</b></p>");
			out.print("<p>Final Grade: <b>" + this.finalGrade + "</b></p>");			
			out.print("<p>Remarks: " + this.remarks + "</p>");
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
	
	public void computeFinalGrade() {
		this.finalGrade = this.midterm * 0.5 + this.preFinal * 0.5;
	}

	public void determineRemarks() {
		this.remarks = (this.finalGrade >= 60)
				?"<font color = 'blue'><b>Congratulations you passed.</b></font>"
				:"<font color = 'red'><b>You have to re-enroll this subject next term.</b></font>";
	}
}
