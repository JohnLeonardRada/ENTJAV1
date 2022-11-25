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
		
		Cookie cookieId = CookieHelper.getCookie(allCookies, "employeeID");
		Cookie cookieName = CookieHelper.getCookie(allCookies, "employeeName");
		Cookie cookieSalesCode = CookieHelper.getCookie(allCookies, "salesCode");
		Cookie cookieSalesAmount = CookieHelper.getCookie(allCookies, "salesAmount");
		Cookie cookieTakeHomePay = CookieHelper.getCookie(allCookies, "takeHomePay");
		Cookie cookieGrossEarned = CookieHelper.getCookie(allCookies, "grossEarned");
		Cookie cookieSalesCommission = CookieHelper.getCookie(allCookies, "salesCommission");
		
		if (cookieId != null && cookieName != null && cookieSalesCode != null
			&& cookieSalesAmount != null && cookieTakeHomePay != null && cookieGrossEarned != null
			&& cookieSalesCommission !=null) {
	
			//We are now ready to send the response back to client
			response.setContentType("text/html"); //set the MIME type
			
			//Create a PrintWriter object.
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head></title></head>");
			out.print("<body>");
			
			request.getRequestDispatcher("design/header.html").include(request, response);
			
			out.print("<p>Employee ID: <b>" + cookieId.getValue() + "</b></p>");
			out.print("<p>Name: <b>" + cookieName.getValue() + "</b></p>");
			out.print("<p>Sales Code: <b>" + cookieSalesCode.getValue() + "</b></p>");
			out.print("<p>Sales Amount: <b>" + cookieSalesAmount.getValue() + "</b></p>");
			out.print("<p>Take Home Pay: <b>" + cookieTakeHomePay.getValue() + "</b></p>");
			out.print("<p>Gross Earned: " + cookieGrossEarned.getValue() + "</p>");
			out.print("<p>Sales Commission: " + cookieSalesCommission.getValue() + "</p>");
				
			out.print("<p>Date Accessed: <i>" + new Date() + "</i></p>");
			
			//Create a form event that will delete all cookies created.
			out.print("<p><form action='clearcookies.action'>");
			out.print("     <input type='submit' value='Clear ALL Cookies'/>");
			out.print("</form></p>");
			
			out.print("<p><form action='index.html'>");
			out.print("     <input type='submit' value='<< GO BACK >>'/>");
			out.print("</form></p>");
			
			request.getRequestDispatcher("design/footer.html").include(request, response);
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		} else {
			response.sendRedirect("index.html");
		}
	}
}
