package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("init method executed.");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create local variables;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double midterm = Double.parseDouble(request.getParameter("midterm"));
		double preFinal = Double.parseDouble(request.getParameter("preFinal"));
		
		StudentBean student = new StudentBean(id, name, midterm, preFinal, getServletConfig());
		
		//Once we have all the input values,
		//We are now ready to perform
		//Business logic methods.
		student.computeFinalGrade();
		student.determineRemarks();
		
		//Perform data object binding.
		request.setAttribute("estudyante", student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.html");
		dispatcher.forward(request, response);
	}
}