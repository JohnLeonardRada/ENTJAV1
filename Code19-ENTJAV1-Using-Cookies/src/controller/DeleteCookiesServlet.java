package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.CookieHelper;

import javax.servlet.http.Cookie;

public class DeleteCookiesServlet extends HttpServlet {
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
			
			//perform actual cookie deletion
			cookieId.setMaxAge(0);
			cookieName.setMaxAge(0);
			cookieMidterm.setMaxAge(0);
			cookiePreFinal.setMaxAge(0);
			cookieFinal.setMaxAge(0);
			cookieRemarks.setMaxAge(0);
			
			//send all the cookies back to browser for deletion
			response.addCookie(cookieId);
			response.addCookie(cookieName);
			response.addCookie(cookieMidterm);
			response.addCookie(cookiePreFinal);
			response.addCookie(cookieFinal);
			response.addCookie(cookieRemarks);
		}
		response.sendRedirect("index.html");
	}
}
