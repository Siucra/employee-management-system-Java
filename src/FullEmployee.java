
public class FullEmployee extends Employee{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//class for full time employees
	//inherits values from Parent class
	
	//full time hours
	//amount per hour
	
	//full time hours !>40
	
	private int fullHours;
	private double fullAmHour;
	
	public FullEmployee() {
		//null constructor
	}

	public FullEmployee(int employeeID, String name, int age, String gender, String status, Role role) {
		super(employeeID, name, age, gender, status, role);
	}

	public int getFullHours() {
		return fullHours;
	}

	public void setFullHours(int fullHours) {
		this.fullHours = fullHours;
	}

	public double getFullAmHour() {
		return fullAmHour;
	}

	public void setFullAmHour(double fullAmHour) {
		this.fullAmHour = fullAmHour;
	}
	
	
	

	
	
	
	
	
	
	

}
