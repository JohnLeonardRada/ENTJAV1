<%!
	//Create instance variables.
	//Input values.
	private String currency;
	private double pesoAmount;
	
	//Computed or derived values.
	private String currencyEquivalent;
	private double convertedAmount;

	public void convertAmount() {
		if (currency.equals("USD")) {
			this.convertedAmount = pesoAmount / 50.90;
			this.currencyEquivalent = "US$";
		} else if (currency.equals("EUR")) {
			this.convertedAmount = pesoAmount / 56.8521;
			this.currencyEquivalent = "&euro;";
		} else if (currency.equals("JPY")) {
			this.convertedAmount = pesoAmount / 0.4825;
			this.currencyEquivalent = "&yen;";
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BPI Forex Computation System</title>
</head>
<body>
	<img src='image/bpiforex.jpg'>
	<h2>BPI Forex Computation System</h2>
	
	<%
		//declare local variables
		pesoAmount = Double.parseDouble(request.getParameter("pesoAmount"));
		currency = request.getParameter("currency");
		
		convertAmount();
	%>
	
	<p>Your equivalent peso amount of <b><%=pesoAmount %> is equivalent to <%=currencyEquivalent %>
	<%=convertedAmount%></b>.
	
	<hr/>
	
	<form action='index.jsp'>
		<input type="submit" value='<< GO BACK >>'>
	</form>
</body>
</html>