package model;

public class ForexBean {

	//Create instance variables.
	//Input values.
	private String currency;
	private double pesoAmount;
	
	//Computed or derived values.
	private String currencyEquivalent;
	private double convertedAmount;
	
	public ForexBean() {	
	}

	public ForexBean(String currency, double pesoAmount) {
		this.currency = currency;
		this.pesoAmount = pesoAmount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getPesoAmount() {
		return pesoAmount;
	}

	public void setPesoAmount(double pesoAmount) {
		this.pesoAmount = pesoAmount;
	}

	public String getCurrencyEquivalent() {
		return currencyEquivalent;
	}

	public void setCurrencyEquivalent(String currencyEquivalent) {
		this.currencyEquivalent = currencyEquivalent;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

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
}
