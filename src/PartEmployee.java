
public class PartEmployee extends Employee {

	private static final long serialVersionUID = 1L;

	private int partHours;
	private double partAmHour;
	
	public PartEmployee() {
		//null constructor
	}

	   public PartEmployee(int employeeID, String name, int age, String gender, String status, Role role, int partHours, double partAmHour) {
	        super(employeeID, name, age, gender, status, role);
	        this.partHours = partHours;
	        this.partAmHour = partAmHour;
	    }
	  

	public int getPartHours() {
		return partHours;
	}

	public void setPartHours(int partHours) {
		this.partHours = partHours;
	}

	public double getPartAmHour() {
		return partAmHour;
	}

	public void setPartAmHour(double partAmHour) {
		this.partAmHour = partAmHour;
	}
	
	
	
}
