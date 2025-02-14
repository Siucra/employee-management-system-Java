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

		prepopulate();
		employeeMenu();
	}
	
	public static void prepopulate() {
		
		//role and employee prepopulated seperately since there is no inheritance
		Role r1 = new Role("Maintenance","50000");
		//prepopulate employees
		FullEmployee bob = new FullEmployee(001,"Bob",59,"Male","Senior",r1, 40, 18.05);
		employeeDirectory.add(bob);
		
		//PartEmployee bob = 
		Role r2 = new Role("Janitor","300000");
		PartEmployee jen = new PartEmployee(002,"Jen",21,"Female","Junior",r2,20,15.50);
		employeeDirectory.add(jen);
		
	}
	
	//verify user before application's functionality
	//public static void verifyUser() {
		//System.out.println("*********************************************");
		//System.out.println("Enter ");
		//System.out.println("*********************************************");
	//}
	
	public static void employeeMenu() {
		System.out.println("*".repeat(25));;
		System.out.println("EMPLOYEE MANAGEMENT SYSTEM MENU");
		System.out.println("1 - Add Employee Menu");
		System.out.println("2 - Edit Employee Menu");
		System.out.println("3 - Fire Employee Menu");
		System.out.println("4 - View Employee Menu");
		System.out.println("*".repeat(25));;
		
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
				viewAllEmployeeDetails();
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
		
		System.out.println("-".repeat(18));
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
			System.out.println("-".repeat(20));
			System.out.println("Is this employee Part or Full time?");
			System.out.println("Please enter either 'Part' or 'Full");
			System.out.println("-".repeat(20));
				String empType = input.next();//stored input to be used more than once in loop
				if(empType.equalsIgnoreCase("Part")){
						System.out.println("'Part' option has been selected.");//validation message
						addPartEmployee(e, role);
					}
				else if(empType.equalsIgnoreCase("Full")) {
					System.out.println("'Full' option has been selected");//validation message
					addFullEmployee(e,role);
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}	
			}

		}

	public static void addPartEmployee(Employee e, Role role) {
		
		System.out.println("Add part time hours; must be 15-30");
		int pthInput = input.nextInt();
		
		//check if user input is between 15-30
			if(pthInput<15 || pthInput>30) {
				System.out.println("Invalid hours. Please try again.");
			}
			
		System.out.println("Enter amount per hour.");
		Double hourlyRate =  input.nextDouble();

		PartEmployee partEmp = new PartEmployee(e.getEmployeeID(), e.getName(), e.getAge(), e.getGender(), e.getStatus(),role,pthInput,hourlyRate);

		//print all input info and confirm if user wants to add
		addPartEmpConfirmation(partEmp);
	}

	private static void addPartEmpConfirmation(PartEmployee part) {
		System.out.println("*".repeat(20));//repeat * 20 times
		
		System.out.println("ID: "+ part.getEmployeeID() );
		System.out.println("Name: " + part.getName());
		System.out.println("Age: " + part.getAge());
		System.out.println("Gender: " + part.getGender());
		System.out.println("Status: " + part.getStatus());
		System.out.println("Title: " + part.getRole().getTitle());
		System.out.println("Salary: "+ part.getRole().getSalary());
		System.out.println("Hours: " + part.getPartHours());
		System.out.println("Amount per Hour: " + part.getPartAmHour());
		System.out.println("*".repeat(20));
		
		System.out.println("Are you sure you want to add "+part.getName() + " as an employee?");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		switch(input.next()) {
			case"1":{
				
				System.out.println(part.getName()+ " has been added to the Employee Directory");
				employeeDirectory.add(part);
				System.out.println("Returning to Main Menu...");
				employeeMenu();
				
				break;
			}
			case"2":{//if user clicks no go back to employeeMenu ( user input values would reset)
				System.out.println("Employee discarded.");//confirmation message, remove later
				System.out.println("Returning to Main Menu...");
				employeeMenu();
				break;
			}
			default:{
				System.out.println("Invalid input. Please try again.");
				break;
			}
			
		}
		
	}
	
	public static void addFullEmployee(Employee e, Role role) {
		System.out.println("Add full time hours: Must be 30-40");
		int fthInput = input.nextInt();
			if(fthInput <30 || fthInput >40) {
				System.out.println("Invalid hours. Please try again.");
			}
		
		System.out.println("Enter Amount per Hour");
		Double hourlyRate = input.nextDouble();
			
		FullEmployee fullEmp = new FullEmployee(e.getEmployeeID(), e.getName(), e.getAge(), e.getGender(), e.getStatus(),role,fthInput,hourlyRate);
		addFullEmpConfirmation(fullEmp);		

	}

	public static void addFullEmpConfirmation(FullEmployee full) {
		
		System.out.println("*".repeat(20));//repeat * 20 times
		System.out.println("ID: "+ full.getEmployeeID() );
		System.out.println("Name: " + full.getName());
		System.out.println("Age: " + full.getAge());
		System.out.println("Gender: " + full.getGender());
		System.out.println("Status: " + full.getStatus());
		System.out.println("Title: " + full.getRole().getTitle());
		System.out.println("Salary: "+ full.getRole().getSalary());
		System.out.println("Hours: " + full.getFullHours());
		System.out.println("Amount per Hour: " + full.getFullAmHour());
		System.out.println("*".repeat(20));
		
		System.out.println("Are you sure you want to add "+full.getName());
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		
		switch(input.next()) {
			case"1":{
				System.out.println(full.getName() +" has been added to the Employee Directory.");
				employeeDirectory.add(full);
				System.out.println("Returning to Main Menu...");
				break;
			}
			case"2":{
				System.out.println("Employee discarded.");//confirmation message, remove later
				System.out.println("Returning to Main Menu...");
				break;
			}
			default:{
				System.out.println("Invalid input please try again.");
				break;
			}
			
		}
	}
	
	public static void viewAllEmployeeDetails() {
		for(Employee e: employeeDirectory) {
			e.viewEmployeeDetails();
		}
		
		
	}


		
	
}
