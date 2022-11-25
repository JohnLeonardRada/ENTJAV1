package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeBean;

import javax.servlet.http.Cookie;

public class ComputeSalesServlet extends HttpServlet {
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
		String salesCode = request.getParameter("salesCode");
		double salesAmount = Double.parseDouble(request.getParameter("salesAmount"));
		
		System.out.println("ID Entered: " + id);
		System.out.println("Name Entered: " + name);
		System.out.println("Sales Code Entered: " + salesCode);
		System.out.println("Sales Amount Entered: " + salesAmount);
		
		//Perform server logging.
		getServletContext().log("ID Entered: " + id);
		application.log("Name Entered: " + name);
		application.log("Sales Code Entered: " + salesCode);
		application.log("Sales Amount Entered: " + salesAmount);
				
		EmployeeBean employee = new EmployeeBean(id, name, salesCode, salesAmount, getServletContext());
		
		//Once we have all the input values, 
		//We are now ready to perform
		//business logic methods.
		employee.computeSales();
		
		//Create cookies.
		Cookie cookieId = new Cookie("employeeID", employee.getId());
		Cookie cookieName = new Cookie("employeeName", employee.getName());
		Cookie cookieSalesCode = new Cookie("salesCode", employee.getSalesCode());
		Cookie cookieSalesAmount = new Cookie ("salesAmount", new Double (employee.getSalesAmount()).toString());
		Cookie cookieTakeHomePay = new Cookie ("takeHomePay", new Double (employee.getTakeHomePay()).toString());
		Cookie cookieGrossEarned = new Cookie ("grossEarned", new Double (employee.getGrossEarned()).toString());
		Cookie cookieSalesCommission = new Cookie ("salesCommission", new Double (employee.getSalesCommission()).toString());
		
		//Set all cookie validity to three months.
		cookieId.setMaxAge(14 * 24 * 60 * 60);
		cookieName.setMaxAge(14 * 24 * 60 * 60);
		cookieSalesCode.setMaxAge(14 * 24 * 60 * 60);
		cookieSalesAmount.setMaxAge(14 * 24 * 60 * 60);
		cookieTakeHomePay.setMaxAge(14 * 24 * 60 * 60);
		cookieGrossEarned.setMaxAge(14 * 24 * 60 * 60);
		cookieSalesCommission.setMaxAge(14 * 24 * 60 * 60);
		
		//Send all the created cookies to the client's browser.
		response.addCookie(cookieId);
		response.addCookie(cookieName);
		response.addCookie(cookieSalesCode);
		response.addCookie(cookieSalesAmount);
		response.addCookie(cookieTakeHomePay);
		response.addCookie(cookieGrossEarned);
		response.addCookie(cookieSalesCommission);
		
		response.getWriter().print("<p>Please click <a href='display.html'>here</a> to continue</p>");
	}
}
