import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
	/**
	 * 
	 *
	private static final long serialVersionUID = 1L;
	/*
	 * -add employee
	 * -edit employee: role, salary, status
	 * -remove ("fire") employee
	 * -view employee (just one) or all employee
	 * -view employee: role, salary status
	 * 
	 * 
	 * what would an employee have in general
	 * -unique ID
	 * - name
	 * - age
	 * - gender
	 * ---should these be inherited?
	 * */
	
	private int employeeID;
	private String name;
	private int age;
	private String gender;
	private String status; //junior, senior
	private Role role;
	//private type Type (part time, full time INHERITED CLASS)
	
	
	public Employee() {
		//null constructor
	}
	public Employee(int employeeID,String name, int age, String gender, String status, Role role) {
		this.employeeID = employeeID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.status = status;
		this.role = role;
	}
	
	//public void showAllEmployee() {
		
	//}
	
	public void viewEmployeeDetails(){
		for(Employee e : Application.employeeDirectory) {
			System.out.println("-------------------------------------");
			System.out.println("ID: " + e.getEmployeeID());
			System.out.println("Name: " +e.getName());
			System.out.println("Age: "+ e.getAge());
			System.out.println("Sex: "+e.getGender());
			System.out.println("Status: " + e.getStatus());
			role.printRoleDetails();//using instance object to call printRoleDetails in Role class
			//if statement here for part or full employee to print
			//PartEmployee.printPartEmployee();
			}
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
