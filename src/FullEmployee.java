
public class FullEmployee extends Employee{

	private static final long serialVersionUID = 1L;
	
	private int fullHours;
	private double fullAmHour;
	
	public FullEmployee() {
		//null constructor
	}

	public FullEmployee(int employeeID, String name, int age, String gender, String status, Role role, int fullHours, double fullAmHour) {
		super(employeeID, name, age, gender, status, role);
		this.fullHours = fullHours;
		this.fullAmHour = fullAmHour;
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
