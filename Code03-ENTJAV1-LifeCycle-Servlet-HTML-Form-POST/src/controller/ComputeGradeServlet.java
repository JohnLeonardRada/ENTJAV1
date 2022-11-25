package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This is a URL mapping we have set earlier. 
//Notice that the value of the form
//Action must be same with this Java Servlet.
@WebServlet("/computeGrade.action")
public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Create instance variables.
	//Input values from user.
	private String id;
	private String name;
	private double midterm;
	private double preFinal;
	
	//Computed values.
	private double finalGrade;
	private String remarks;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method activated.");
		
		//Perform member instance variables initialization.
		id = "";
		name = "";
		remarks = "";
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.id = request.getParameter("id");
		this.name = request.getParameter("name");
		this.midterm = Double.parseDouble(request.getParameter("midterm"));
		this.preFinal = Double.parseDouble(request.getParameter("preFinal"));
		
			//Perform business logic methods.
			computeFinalGrade();
			determineRemarks();
			
			response.setContentType("text/html");
			
			//Create a printWriter object.
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>Grade Computation</title></head>");
			out.print("<body>");
			out.print("<h2>Grade Computation</h2>");
			out.print("<p>Student ID: <b>" + this.id + "</b></p>");
			out.print("<p>Name: <b>" + this.name + "</b></p>");
			out.print("<p>Midterm Grade: <b>" + this.midterm + "</b></p>");
			out.print("<p>PreFinal Grade: <b>" + this.preFinal + "</b></p>");
			out.print("<p>Final Grade: <b>" + this.finalGrade + "</b></p>");
			out.print("<p>Remarks: " + this.remarks + "</p>");
			out.print("<hr/>");
			out.print("<form action = 'index.html'>");
			out.print("		<input type = 'submit' value = '<<GO BACK>>'/>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
			
			out.close();
	}

	public void destroy() {
		System.out.println("Destroy Method Activated");
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
