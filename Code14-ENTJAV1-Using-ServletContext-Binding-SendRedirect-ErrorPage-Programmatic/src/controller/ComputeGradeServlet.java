package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext application; //Defaulted to null.
	
	public void init() throws ServletException {
		System.out.println("init method executed.");
		this.application = getServletContext();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost (request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create local variables.
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double midterm = Double.parseDouble(request.getParameter("midterm"));
		double preFinal = Double.parseDouble(request.getParameter("preFinal"));
		
		System.out.println("ID Entered: " + id);
		System.out.println("Name Entered: " + name);
		System.out.println("Midterm Raw Grade Entered: " + midterm);
		System.out.println("Pre-Final Raw Grade Entered: " + preFinal);
		
		//Perform server logging.
		getServletContext().log("ID Entered: " + id);
		application.log("Name Entered: " + name);
		application.log("Midterm Raw Grade Entered: " + midterm);
		application.log("Pre-Final Raw Grade Entered: " + preFinal);
				
		StudentBean student = new StudentBean(id, name, midterm, preFinal, getServletContext());
		
		//Once we have all the input values, 
		//We are now ready to perform
		//Business logic methods.
		student.computeFinalGrade();
		student.determineRemarks();
		
		//perform data object binding on application scope
		//request.setAttribute("estudyante", student);
		getServletContext().setAttribute("estudyante", student);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("display.html");
		//dispatcher.forward();
		//request.getRequestDispatcher("display.html").forward(request, response);
		//getServletContext().getRequestDispatcher("/display.html").forward(request, response);
		
		response.sendRedirect("display.html");
	}
}
