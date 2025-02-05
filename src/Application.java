import java.util.Scanner;
public class Application {
//Employee management system functionality
	/**
	 * -add employee
	 * -edit employee: role, salary, status
	 * -remove ("fire") employee
	 * -view employee (just one) or all employee
	 * -view employee: role, salary status
	 * 
	 * Employee - 
	 * Job - role, hrs etc 
	 * Status - penalty points etc 
	 * Desc - physical appearance etc (maybe unneeded)
	 * 
	 * 
	 * Types of employees: (inheritance?)
	 * part time 
	 * full time
	 * intern
	 * 
	 */


	static Scanner input = new Scanner(System.in);
	
	public static void main(String[]args) {

		prepopulate();
	}
	
	public static void prepopulate() {
		
		//role and employee prepopulated seperately since there is no inheritance
		Role r1 = new Role("Maintenance","50000");
		//prepopulate employees
		Employee bob = new Employee(001,"Bob",59,"Male","Senior",r1);
		
		//PartEmployee bob = 
		Role r2 = new Role("Janitor","300000");
		PartEmployee jen = new PartEmployee(002,"Jen",21,"Female","Junior",r2,20,15.50);
		
		bob.viewEmployeeDetails();
		jen.viewEmployeeDetails();
		
	}
	
	//verify user before application's functionality
	//public static void verifyUser() {
		//System.out.println("*********************************************");
		//System.out.println("Enter ");
		//System.out.println("*********************************************");
	//}
	
	public static void employeeMenu() {
		System.out.println("*********************************************");
		System.out.println("EMPLOYEE MANAGEMENT SYSTEM MENU");
		System.out.println("1 - Add Employee");
		System.out.println("2 - Edit Employee");
		System.out.println("3 - Fire Employee");
		System.out.println("4 - View Employee");
		System.out.println("*********************************************");
		
		switch(input.nextInt()) {
			case 1:{
				
				break;
			}
		}
	}
	
	
	
	
	
}
