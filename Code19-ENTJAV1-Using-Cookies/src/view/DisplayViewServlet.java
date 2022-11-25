package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.CookieHelper;

import javax.servlet.http.Cookie;

public class DisplayViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie allCookies[] = request.getCookies();
		
		Cookie cookieId = CookieHelper.getCookie(allCookies, "studentId");
		Cookie cookieName = CookieHelper.getCookie(allCookies, "studentName");
		Cookie cookieMidterm = CookieHelper.getCookie(allCookies, "midtermGrade");
		Cookie cookiePreFinal = CookieHelper.getCookie(allCookies, "preFinalGrade");
		Cookie cookieFinal = CookieHelper.getCookie(allCookies, "finalGrade");
		Cookie cookieRemarks = CookieHelper.getCookie(allCookies, "remarks");
		
		if (cookieId != null && cookieName != null && cookieMidterm != null
			&& cookiePreFinal != null && cookieFinal != null && cookieRemarks != null) {
	
			//We are now ready to send the response back to client.
			response.setContentType("text/html"); //set the MIME type
			
			//Create a PrintWriter object.
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>iAcademy Grade Computation</title></head>");
			out.print("<body>");
			
			request.getRequestDispatcher("design/header.html").include(request, response);
			
			out.print("	<p>Student ID: <b>" + cookieId.getValue() + "</b></p>");
			out.print(" <p>Name: <b>" + cookieName.getValue() + "</b></p>");
			out.print(" <p>Midterm Grade: <b>" + cookieMidterm.getValue() + "</b></p>");
			out.print(" <p>PreFinal Grade: <b>" + cookiePreFinal.getValue() + "</b></p>");
			out.print(" <p>FINAL Grade: <b>" + cookieFinal.getValue() + "</b></p>");
			out.print(" <p>Remarks: " + cookieRemarks.getValue() + "</p>");
			
			out.print(" <p><i>Note: " + getServletContext().getInitParameter("passingMark") 
				+ "% is the passing score.</i></p>");
			
			out.print(" <p>Date Accessed: <i>" + new Date() + "</i></p>");
			
			//Create a form event that will delete all cookies created.
			out.print(" <p><form action='clearcookies.action'>");
			out.print(" 	<input type='submit' value='Clear ALL Cookies'/>");
			out.print(" </form></p>");
			
			out.print(" <p><form action='index.html'>");
			out.print(" 	<input type='submit' value='<< GO BACK >>'/>");
			out.print(" </form></p>");
			
			request.getRequestDispatcher("design/footer.html").include(request, response);
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		} else {
			response.sendRedirect("index.html");
		}
	}
}
