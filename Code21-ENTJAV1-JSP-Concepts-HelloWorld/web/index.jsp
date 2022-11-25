<%-- This is a JSP comment. A JSP comment is server-side. You can put sensitive 
information. --%>

<%-- This is JSP declaration element. Here you can create or declare instance, class
or static variables and user-defined functions or methods. 

Please remember that the content that the content of the JSP declaration element must be
pure Java codes.
--%>

<%!
	private String message; //defaulted to null
	
	public void jspInit() {
		System.out.println("JSP jspInit() Method Executed.");
		message = "Hello World Using Java Server Pages";
	}
	
	public void jspDestroy() {
		System.out.println("JSP jspDestroy() Method Executed.");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=message %></title>
</head>
<body>
	<!--  This is the HTML comment. Unsafe to use if it contains sensitive information. -->
	<%-- this is a JSP scriptlet. --%>
	
	<% 
		String school = "iAcademy";
		if (request.getParameter("mensahe") != null) {
			message = request.getParameter("mensahe");
		}
	%>
	<h2><%=message %></h2>
	<p>JSP is Cool.</p>
	<hr/>
	<p><i>&copy; 2020 <%=school %> Game Changers. All rights reserved.</i></p>
	<p><b><%=school %> is <%=2020-2002 %> years in existence.</b></p>
	<p><i>Date Accessed: <%= new java.util.Date() %></i></p>
	<p>Programmed by John Leonard Rada</p>
</body>
</html>