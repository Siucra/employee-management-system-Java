
public class PartEmployee extends Employee {
	//class for part time employees
	//inherits values from Parent class
	
	//part time hours
	//amount per hour
	
	//part time hours !>30
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
	   
	   //override the viewEmployeeDetails  from Employee class (Polymorphism)
	   public void viewEmployeeDetails() {
		   super.viewEmployeeDetails();
		   System.out.println("Part time hours: " + getPartHours());
		   System.out.println("Amount per hour: "+ getPartAmHour());
		   System.out.println("-------------------------------------");
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
