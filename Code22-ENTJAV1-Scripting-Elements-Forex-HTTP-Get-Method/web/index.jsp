<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BPI Forex Computation System</title>
</head>
<body>
	<img src='image/bpiforex.jpg'>
	<h2>BPI Forex Computation System</h2>
	<fieldset>
		<legend>Forex Form</legend>
		<form action='convertforex.jsp'>
			<p>Enter Philippine Peso Amount: Php
				<input type='number' name='pesoAmount' min='1' max="500000" required="required"/>
			</p>
			<p>Select Currency:
				<select name="currency">
					<option value="USD">US$ Dollar</option>
					<option value="EUR">&euro;uro</option>
					<option value="JPY">&yen;en</option>
				</select>
			</p>
			<p>
				<input type='submit' value='Convert Currency'/>&nbsp;&nbsp;&nbsp;
				<input type='reset'/>
			</p>
		</form>
	</fieldset>
	<hr/>
	<p><i>&copy; 2020 iAcademy Games Changers</i></p>
</body>
</html>