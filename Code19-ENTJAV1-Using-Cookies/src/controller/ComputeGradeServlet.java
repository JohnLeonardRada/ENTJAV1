package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

import javax.servlet.http.Cookie;

public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext application; //defaulted to null
	
	public void init() throws ServletException {
		System.out.println("init () method executed.");
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
		//business logic methods.
		student.computeFinalGrade();
		student.determineRemarks();
		
		//Create cookies.
		Cookie cookieId = new Cookie("studentId", student.getId());
		Cookie cookieName = new Cookie("studentName", student.getName());
		Cookie cookieMidterm = new Cookie ("midtermGrade", new Double (student.getMidterm()).toString());
		Cookie cookiePreFinal = new Cookie ("preFinalGrade", new Double (student.getPreFinal()).toString());
		Cookie cookieFinal = new Cookie ("finalGrade", new Double (student.getFinalGrade()).toString());
		Cookie cookieRemarks = new Cookie("remarks", student.getRemarks());
		
		//Set all cookie validity to three months.
		cookieId.setMaxAge(3 * 12 * 30 * 24 * 60 * 60);
		cookieName.setMaxAge(3 * 30 * 24 * 60 * 60);
		cookieMidterm.setMaxAge(3 * 30 * 24 * 60 * 60);
		cookiePreFinal.setMaxAge(3 * 30 * 24 * 60 * 60);
		cookieFinal.setMaxAge(3 * 30 * 24 * 60 * 60);
		cookieRemarks.setMaxAge(3 * 30 * 24 * 60 * 60);
		
		//Send all the created cookies to the client's browser.
		response.addCookie(cookieId);
		response.addCookie(cookieName);
		response.addCookie(cookieMidterm);
		response.addCookie(cookiePreFinal);
		response.addCookie(cookieFinal);
		response.addCookie(cookieRemarks);
		
		response.getWriter().print("<p>Please click <a href='display.html'>here</a> to continue</p>");
		
	}
}
