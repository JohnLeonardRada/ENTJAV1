package model;

public class StudentBean {

	private String id;
	private String name;
	private double midterm;
	private double preFinal;
		
	private double finalGrade;
	private String remarks;
		
	public StudentBean() {
			
	}
		
	public StudentBean(String id, String name, double midterm, double preFinal) {
		this.id = id;
		this.name = name;
		this.midterm = midterm;
		this.preFinal = preFinal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getPreFinal() {
		return preFinal;
	}

	public void setPreFinal(double preFinal) {
		this.preFinal = preFinal;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public void computeFinalGrade() {
		this.finalGrade = this.midterm * 0.5 + this.preFinal * 0.5;
	}
		
	public void determineRemarks() {
		this.remarks = (this.finalGrade >= 60)
				?"<font color = 'blue'><b>Congratulations you passed.</b></font>"
				:"<font color = 'red'><b>You have to re-enroll this subject next term.</b></font>";
	}	
}