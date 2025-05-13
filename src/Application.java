import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

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
		Role r1 = new Role("Maintenance",50000);
		
		//prepopulate employees
		FullEmployee bob = new FullEmployee(001,"Bob",59,"Male","Senior",r1, 40, 18.05);
		employeeDirectory.add(bob);
		
		//PartEmployee bob = 
		Role r2 = new Role("Janitor",300000);
		PartEmployee jen = new PartEmployee(002,"Jen",21,"Female","Junior",r2,20,15.50);
		employeeDirectory.add(jen);
		
	}
	
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
				editEmployee();
				break;
			}
			case 3:{
				System.out.println("Loading...");
				fireEmployee();
				break;
			}
			case 4:{
				System.out.println("Loading...");
				viewAllEmployeeDetails();
				break;
			}
			default:{
				System.out.println("Invalid input please try again.");
				employeeMenu(); //recursion
				break;
			}
			
		}
	}

	public static void addEmployeeMenu() throws IOException{
		
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
		role.setSalary(input.nextDouble());
		
		while(true) {
			System.out.println("-".repeat(20));
			System.out.println("Is this employee Part or Full time?");
			System.out.println("Please enter either 'Part' or 'Full");
			System.out.println("-".repeat(20));
				String empType = input.next();//stored input to be used more than once in loop
				if(empType.equalsIgnoreCase("Part")){
						System.out.println("'Part' option has been selected.");//validation message
						addPartEmployee(e, role);
						break;
					}
				else if(empType.equalsIgnoreCase("Full")) {
					System.out.println("'Full' option has been selected");//validation message
					addFullEmployee(e,role);
					break;
				}
				else {
					System.out.println("Invalid input. Please try again.");
					break;
				}	
			}

		}

	public static void addPartEmployee(Employee e, Role role) {
		
		System.out.println("Add part time hours; must be 15-30");
		int pthInput = input.nextInt();
		
		//check if user input is between 15-30
			while(pthInput<15 || pthInput>30) {
				System.out.println("Invalid hours. Please try again.");
				pthInput = input.nextInt(); // Read again if input was invalid
			}
			
		System.out.println("Enter amount per hour.");
		Double hourlyRate =  input.nextDouble();

		PartEmployee partEmp = new PartEmployee(e.getEmployeeID(), e.getName(), e.getAge(), e.getGender(), e.getStatus(),role,pthInput,hourlyRate);

		//print all input info and confirm if user wants to add
		addPartEmpConfirmation(partEmp);
	}

	public static void addPartEmpConfirmation(PartEmployee part) {
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
			while(fthInput <30 || fthInput >40) {
				System.out.println("Invalid hours. Please try again.");
				fthInput = input.nextInt();
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
				employeeMenu();
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
		System.out.println("*".repeat(30));//repeat * 30 times
		System.out.println("1 - View All Names.");
		System.out.println("2 - View All Ages.");
		System.out.println("3 - View All Genders.");
		System.out.println("4 - View All Status.");
		System.out.println("5 - View All Roles.");
		System.out.println("6 - View All Salaries.");
		System.out.println("7 - View Total Part Time Employees.");
		System.out.println("8 - View Total Full Time Employees.");
		System.out.println("0 - Return to Main Menu.");
		System.out.println("*".repeat(30));//repeat * 30 times
		
		switch(input.next()) {
			case"1":{
				System.out.println("NAMES:\n");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(12));
					System.out.println(e.getName());
					System.out.println("-".repeat(12));
				}
				break;
			}
			case"2":{
				System.out.println("AGES:\n");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(12));
					System.out.println(e.getAge());
					System.out.println("-".repeat(12));
				}
				break;
			}
			case"3":{
				int maleCount = 0;
				int femaleCount = 0;
				System.out.println("GENDERS:\n");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(12));
					if(e.getGender().equalsIgnoreCase("Male")) {
						maleCount++;
						System.out.println("MALE TOTAL: "+maleCount);
					}
					else if(e.getGender().equalsIgnoreCase("Female")) {
						femaleCount++;
						System.out.println("FEMALE TOTAL: "+femaleCount);
					}
					System.out.println("-".repeat(12));
				}
				
				System.out.println("Total Male Employees: " + maleCount);
				System.out.println("Total Female Employees: "+femaleCount);
				
				break;
			}
			case"4":{
				int seniorCount = 0;
				int juniorCount = 0;
				System.out.println("STATUS:");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(12));
					if(e.getStatus().equalsIgnoreCase("Senior")) {
						seniorCount++;
						System.out.println("Total Senior Status Employees: "+seniorCount);
					}
					else if(e.getStatus().equalsIgnoreCase("Junior")) {
						juniorCount++;
						System.out.println("Total Junior Status Employees: "+juniorCount);
					}
					System.out.println("-".repeat(12));
				}
				break;
			}
			case"5":{
				System.out.println("Roles:\n");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(12));
					System.out.println(e.getRole().getTitle());
					System.out.println("-".repeat(12));
				}
				break;
			}
			case"6":{
				System.out.println("Salaries:\n");
				for(Employee e: employeeDirectory) {
					System.out.println("-".repeat(18));
					if(e instanceof PartEmployee) {
						System.out.println("Part Time Employees");
						System.out.println("-".repeat(12));
						System.out.println("ID: "+ e.getEmployeeID() + " - "+ e.getName());
						System.out.println(e.getRole().getTitle());
						System.out.println(e.getRole().getSalary()+ " Annual");
					}
					else if(e instanceof FullEmployee) {
						System.out.println("Full Time Employees");
						System.out.println("-".repeat(12));
						System.out.println("ID: "+ e.getEmployeeID() + " - " + e.getName());
						System.out.println(e.getRole().getTitle());
						System.out.println(e.getRole().getSalary()+ " Annual");
					}
					
					System.out.println("-".repeat(18));
				}
				break;
			}
			case"7":{
				int partEmpTotal = 0;
				
				for(Employee e: employeeDirectory) {
					//.getClass checks if PartEmployee is the EXACT class, not subclass (like instanceof)
					if(e.getClass() == PartEmployee.class) {
					partEmpTotal++;
					}
				}
				System.out.println("-".repeat(12));
				System.out.println("Total Part Time Employees: "+partEmpTotal);
				System.out.println("-".repeat(12));
				break;
				
			}
			case"8":{//
				int fullEmpTotal = 0;
				
				for(Employee e: employeeDirectory) {
					//.getClass checks if PartEmployee is the EXACT class, not subclass (like instanceof)
					if(e.getClass() == FullEmployee.class) {
						fullEmpTotal++;
					}
				}
					System.out.println("-".repeat(12));
					System.out.println("Total Full Time Employees: "+ fullEmpTotal);
					System.out.println("-".repeat(12));
				
				break;
			}
			case"0":{
				System.out.println("Returning to Main Menu....");
				employeeMenu();
				break;
			}
			default:{
				System.out.println("Invalid input. Please try again.");
			}
		}
		viewAllEmployeeDetails();
	
	}

	public static void editEmployee() {
		while (true) {//loops the method until condition is met
			for(Employee e: employeeDirectory) {
				System.out.println("-".repeat(12));
				e.viewEmployeeDetails();
				System.out.println("-".repeat(12));
			}
			
			System.out.println("Enter Employee ID you wish to Edit.");
			if(!input.hasNextInt()) {
				System.out.println("Invalid input. Please try again.");
				input.nextLine(); //Clear the invalid input to prevent issues
				return;
			}
			
			int idToEdit = input.nextInt();
			input.nextLine(); // Clear newline left in buffer
			boolean idIsFound = false;
			
			for(Employee e: employeeDirectory) {
				if(e.getEmployeeID() == idToEdit) {
					idIsFound = true;
					//user confirmation
					System.out.println("You have selected "+e.getName() +", ID: "+e.getEmployeeID());
					System.out.println("Are you sure you want to edit this Employee?");
					System.out.println("-".repeat(25));
					System.out.println("1 - YES");
					System.out.println("2 - NO");
					System.out.println("-".repeat(25));
					
					switch(input.next()){
						case"1":{
							System.out.println("*".repeat(20));
							System.out.println("Loading Edit Menu.....");
								try {
									editEmployeeMenu(e);
									} 
								catch (IOException e1) {
									System.out.println("An error has occured. please try again.");
								}
								return;
						}
						case"2":{
							System.out.println("*".repeat(30));
							System.out.println("Returning to Main Menu....");
							employeeMenu();
							return;
						}
						default:{
							System.out.println("Invalid Input.");
							return;
						}
					}
				}
			}
			
			if (!idIsFound) {
		        System.out.println("Employee ID not found. Please try again.");
			}
		}
	}

	public static void editEmployeeMenu(Employee e) throws IOException {
		System.out.println("*".repeat(30));
		System.out.println("1 - Edit Employee Name.");
		System.out.println("2 - Edit Employee Age.");
		System.out.println("3 - Edit Employee Gender.");
		System.out.println("4 - Edit Employee Status.");
		System.out.println("5 - Edit Employee Role.");
		System.out.println("6 - Edit Employee Salary.");
		System.out.println("M - Return to Main Menu.");
		//System.out.println("7 - Edit Employee Contract");//part or full time?
		System.out.println("*".repeat(30));
		switch(input.next()) {
			case"1":{
				System.out.println("Enter a new name for "+ e.getName());
				String newName = reader.readLine();
				
				//User Confirmation
				System.out.println("Are you sure you want to change this Employee's name from "+e.getName()+ " to "+newName+" ?");
				System.out.println("1 - YES");
				System.out.println("2 - NO");
					switch(input.next()) {
						case"1":{
							System.out.println("Name successfully changed to "+ newName);
							e.setName(newName);
							break;
						}
						case"2":{
							System.out.println("Name change cancelled. Keeping "+ e.getName());
							break;
						}
						default:{
							System.out.println("Invalid Input. Please try again.");
							break;
						}
					}
				break;
			}
			case"2":{
				System.out.println("Enter a new Age for "+e.getAge());
				int newAge = input.nextInt();
				
				//User Confirmation
				System.out.println("Are you sure you want to change " + e.getName()+"'s age from "+e.getAge()+ " to "+newAge+" ?");
				System.out.println("1 - YES");
				System.out.println("2 - NO");
				switch(input.next()) {
					case"1":{
						System.out.println("Age successfully changed to "+ newAge);
						e.setAge(newAge);
						break;
					}
					case"2":{
						System.out.println("Age change cancelled. Keeping "+e.getAge());
						break;
					}
					default:{
						System.out.println("Invalid Input. Please try again.");
						break;
					}
					
				}
				break;
			}
			case"3":{
				System.out.println("Enter new Gender for "+e.getName());
				String newGender;
				
				while(true) {
					newGender = input.next();
					if(newGender.equalsIgnoreCase("Male")|| newGender.equalsIgnoreCase("Female")) {
						break;//exit loop if input is valid
					}
					else {
						System.out.println("Invalid Gender Input. Please try again.");
						}
					}
				System.out.println("Are you sure you want to change "+e.getName()+"'s gender from "+e.getGender()+" to "+newGender+" ?");	
				System.out.println("1 - YES");
				System.out.println("2 - NO");
					switch(input.next()) {
						case"1":{
							System.out.println("Gender successfully changed to "+newGender);
							e.setGender(newGender);
							break;
							}
						case"2":{
							System.out.println("Gender change cancelled. Keeping "+e.getGender());
							break;
							}
						default:{
							System.out.println("Invalid input. Please try again.");
							break;
							}
						}
				break;
			}
			case"4":{
				System.out.println("Enter a new Employee Status to replace "+ e.getName()+"'s" + "Status: "+e.getStatus());
				String newStatus;
				while(true) {
					newStatus = input.next();
					if(newStatus.equalsIgnoreCase("Junior")||newStatus.equalsIgnoreCase("Senior")) {
						break;
					}
					else {
						System.out.println("Invalid Status input. Please try again.");
					}
				}
				System.out.println("Are you sure you want to change "+e.getName()+"'s status from "+e.getStatus()+" to "+newStatus+" ?");	
				System.out.println("1 - YES");
				System.out.println("2 - NO");
				switch(input.next()) {
					case"1":{
						System.out.println("Status successfully changed to "+newStatus);
						e.setStatus(newStatus);
						break;
					}
					case"2":{
						System.out.println("Status change cancelled.");
						break;
					}
					default:{
						System.out.println("Invalid input. Please try again.");
						break;
					}
				}
				break;
			}
			case"5":{
				System.out.println("Enter new Title to replace "+e.getName()+"'s role");
				String newTitle = input.next();
				
					System.out.println("Are you sure you want to change " + e.getName()+"'s Role from "+e.getRole().getTitle()+ " to "+newTitle+" ?");
					System.out.println("1 - YES");
					System.out.println("2 - NO");
				
				
				switch(input.next()) {
					case"1":{
						System.out.println("Title successfully changed to "+newTitle);
						e.getRole().setTitle(newTitle);//update the title of the existing role
						break;
					}
					case"2":{
						System.out.println("Title change cancelled.");
						break;
					}
					default:{
						System.out.println("Invalid input. Please try again.");
						break;
					}
					
				}
				break;
			}
			case"6":{
				System.out.println("Enter new Salary to replace "+e.getName()+"'s Salary");
				double newSalary = input.nextDouble();
				
				System.out.println("Are you sure you want to change " + e.getName()+"'s Salary from "+e.getRole().getSalary()+ " to "+newSalary+" ?");
				System.out.println("1 - YES");
				System.out.println("2 - NO");
				
				switch(input.next()) {
					case"1":{
						System.out.println("Salary successfully changed to "+newSalary);
						e.getRole().setSalary(newSalary);
						break;
					}
					case"2":{
						System.out.println("Salary change cancelled.");
						break;
					}
					default:{
						System.out.println("Invalid input. Please try again.");
						break;
					}
				}
			}
			case"m","M":{
				System.out.println("Returning to main menu....");
				employeeMenu();
				break;
			}
			
			default:{
				System.out.println("Invalid input. Please try again.");
				break;
			}
		}
		editEmployee();	
	}
	
	public static void fireEmployee() {
		while (true) {//loops the method until condition is met
			for(Employee e: employeeDirectory) {
				System.out.println("-".repeat(12));
				e.viewEmployeeDetails();
				System.out.println("-".repeat(12));
			}
			
			System.out.println("Enter Employee ID you wish to Fire.");
			if(!input.hasNextInt()) {
				System.out.println("Invalid input. Please try again.");
				input.nextLine(); //Clear the invalid input to prevent issues
				return;
			}
			
			int idToFire = input.nextInt();
			input.nextLine(); // Clear newline left in buffer
			boolean idIsFound = false;
			
			for(Employee e: employeeDirectory) {
				if(e.getEmployeeID() == idToFire) {
					idIsFound = true;
					//user confirmation
					System.out.println("You have selected "+e.getName() +", ID: "+e.getEmployeeID());
					System.out.println("Are you sure you want to fire this Employee?");
					System.out.println("-".repeat(25));
					System.out.println("1 - YES");
					System.out.println("2 - NO");
					System.out.println("-".repeat(25));
					
					switch(input.next()){
						case"1":{
							System.out.println("*".repeat(20));
							System.out.println(e.getName() + " has been removed.");
							employeeDirectory.remove(e);
							System.out.println("*".repeat(20));
							employeeMenu();
							return;
						}
						case"2":{
							System.out.println("*".repeat(30));
							System.out.println("Returning to Main Menu....");
							employeeMenu();
							return;
						}
						default:{
							System.out.println("Invalid Input.");
							return;
						}
					}
				}
			}
			if (!idIsFound) {
		        System.out.println("Employee ID not found. Please try again.");
			}
		}
	}			
}
