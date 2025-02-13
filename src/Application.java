import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	//company statistics method for admin?
	static int centralID = 003;
	static Scanner input = new Scanner(System.in);
	static ArrayList<Employee>employeeDirectory = new ArrayList<Employee>();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[]args) {

		//prepopulate();
		employeeMenu();
	}
	
	public static void prepopulate() {
		
		//role and employee prepopulated seperately since there is no inheritance
		Role r1 = new Role("Maintenance","50000");
		//prepopulate employees
		Employee bob = new Employee(001,"Bob",59,"Male","Senior",r1);
		employeeDirectory.add(bob);
		
		//PartEmployee bob = 
		Role r2 = new Role("Janitor","300000");
		PartEmployee jen = new PartEmployee(002,"Jen",21,"Female","Junior",r2,20,15.50);
		employeeDirectory.add(jen);

		
		
		//bob.viewEmployeeDetails();
		//jen.viewEmployeeDetails();
		
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
		System.out.println("1 - Add Employee Menu");
		System.out.println("2 - Edit Employee Menu");
		System.out.println("3 - Fire Employee Menu");
		System.out.println("4 - View Employee Menu");
		System.out.println("*********************************************");
		
		switch(input.nextInt()) {
			case 1:{
				System.out.println("Loading Add Employee Menu....");
				try {
					addEmployeeMenu();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("An error has occured when adding an employee.");
				}
				break;
			}
			case 2:{
				System.out.println("Loading...");			
				break;
			}
			case 3:{
				System.out.println("Loading...");	
				break;
			}
			case 4:{
				System.out.println("Loading...");
				//viewEmployeeDetails();
				break;
			}
			default:{
				System.out.println("Invalid input please try again.");
				//loop back
			}
			
		}
		employeeMenu();
	}

	public static void addEmployeeMenu() throws IOException{
		//add employee as a whole
		//show total employee amount
		
		System.out.println("------------------------------");
		Employee e = new Employee();
		
		e.setEmployeeID(centralID);
		centralID++;
		
		System.out.println("Enter Employee Name");
		e.setName(reader.readLine());
		
		System.out.println("Enter Employee age");
		e.setAge(input.nextInt());

		while (true) {//makes sure the input is valid
            System.out.println("Enter Employee gender: ");
            e.setGender(input.next());

            if ( e.getGender().equalsIgnoreCase("Male") ||  e.getGender().equalsIgnoreCase("Female")) {
                break; // if user enters valid input, exit loop
            }
            else {//else, repeat loop
                System.out.println("Invalid input. Please enter 'Male' or 'Female'.");
            }
        }

		//Role r = new Role();//instantiating so we can access Role class INSTANTIATION	
		
		while (true) {
			System.out.println("Enter Employee status: Junior/Senior");
			e.setStatus(input.next());
			if (e.getStatus().equalsIgnoreCase("Junior")||e.getStatus().equalsIgnoreCase("Senior")){
					break;
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}
			}
		Role role = new Role();
		System.out.println("Enter Employee Job Title");
		role.setTitle(input.next());
		
		System.out.println("Enter Employee annual salary");
		role.setSalary(input.next());
		
		while(true) {
			System.out.println("---------------------------------------------------");
			System.out.println("Is this employee Part or Full time?");
			System.out.println("Please enter either 'Part' or 'Full");
			System.out.println("---------------------------------------------------");
				String empType = input.next();//stored input to be used more than once in loop
			if(empType.equalsIgnoreCase("Part")){
					System.out.println("u selected part");
					PartEmployee part = new PartEmployee();
					addPartEmployee(e, part, role);
				}
				else if(empType.equalsIgnoreCase("Full")) {
					System.out.println("u selected full");
					FullEmployee full = new FullEmployee();
					System.out.println("Enter fulltime hours from 40-60");
						if(input.nextInt() <40){
							System.out.println("The amount entered is invalid. Please try again.");
						}
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}	
		}
		
		
		//System.out.println(" " + e.getEmployeeID());
	}
	
	public static void addPartEmployee(Employee e,Employee part, Role role) {
		
		System.out.println("Add part time hours; must be 15-30");
		int pthInput = input.nextInt();
		
		//check if user input is between 15-30
			if(pthInput<15 || pthInput>30) {
				System.out.println("Invalid hours. Please try again.");
			}
			else {
				//casting - gives Employee access to subclass PartEmployee by treating super() as subclass
				((PartEmployee) part).setPartHours(pthInput);
			}
			
		System.out.println("Enter amount per hour.");
		((PartEmployee) part).setPartAmHour(input.nextDouble());

		 System.out.println(((PartEmployee) part).getPartHours());

		//print all input info and confirm if user wants to add
		 addPartEmpConfirmation(e, part, role);
	}

	private static void addPartEmpConfirmation(Employee e, Employee part, Role role) {
		System.out.println("*".repeat(20));//repeat * 20 times
		
		System.out.println("ID: "+ e.getEmployeeID() );
		System.out.println("Name: " + e.getName());
		System.out.println("Age: " + e.getAge());
		System.out.println("Gender: " + e.getGender());
		System.out.println("Status: " + e.getStatus());
		System.out.println("Title: " + role.getTitle());
		System.out.println("Salary: "+ role.getSalary());
		System.out.println("Hours: " + ((PartEmployee) part).getPartHours());
		System.out.println("Amount per Hour: " + ((PartEmployee)part).getPartAmHour());
		System.out.println("*".repeat(20));
		
		System.out.println("Are you sure you want to add "+e.getName() + " as an employee?");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		switch(input.next()) {
			case"1":{
				
				System.out.println(e.getName()+ " has been added to the Employee Directory");
				
				employeeDirectory.add(e);
				employeeDirectory.add(part);
				
				//need to view if all info is added
				//e.viewEmployeeDetails();
				//employeeMenu();
				break;
			}
			case"2":{
				
				break;
			}
			default:{
				System.out.println("Invalid input. Please try again.");
				break;
			}
			
		}
		
	}

		
	
}
