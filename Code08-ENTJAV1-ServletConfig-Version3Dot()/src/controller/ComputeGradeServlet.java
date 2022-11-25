package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentBean;

@WebServlet(
		urlPatterns = { "/computeGrade.action" }, 
		initParams = { 
				@WebInitParam(name = "midtermHalfGrade", value = "0.5", description = "Half of the grade for the Final grade"), 
				@WebInitParam(name = "preFinalHalfGrade", value = "0.5"), 
				@WebInitParam(name = "passingMark", value = "80", description = "passing grade"), 
				@WebInitParam(name = "messagePassed", value = "<font color='blue'><b>It is time celebrate.</b></font>", description = "message if grade is passed"), 
				@WebInitParam(name = "messageFailed", value = "<font color='red'><b>You have to study the basic concepts.</b></font>", description = "message if grade is failed")
		})
public class ComputeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig config; //This is defaulted to null.
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //Mandatory statement if the intended method init (ServletConfig config).
		this.config = config;
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
		
		StudentBean student = new StudentBean(id, name, midterm, preFinal, config);
		
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