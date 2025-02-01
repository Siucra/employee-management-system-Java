
public class Application {
//Employee management system functionality
	/**
	 * -add employee
	 * -edit employee: role, salary, status
	 * -remove ("fire") employee
	 * -view employee (just one) or all employee
	 * -view employee: role, salary status
	 * 
	 * Employee - PARENT
	 * Job - role, hrs etc CHILD
	 * Status - penalty points etc CHILD
	 * Desc - physical appearance etc CHILD(maybe unneeded)
	 * 
	 * 
	 * Types of employees: (inheritance?)
	 * part time 
	 * full time
	 * intern
	 * 
	 */
	
	public static void main(String[]args) {
		
		prepopulate();
	}
	
	public static void prepopulate() {
		
		//role and employee prepopulated seperately since there is no inheritance
		Role r1 = new Role("Maintenance",60,"50000");
		//prepopulate employees
		Employee bob = new Employee(001,"Bob",59,"Male","Senior",r1);
		
		bob.viewEmployeeDetails();
		
		
		
	}
}
