import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int employeeID;
	private String name;
	private int age;
	private String gender;
	private String status;
	private Role role;
	
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

	public void viewEmployeeDetails(){
		//for(Employee e : Application.employeeDirectory) {
			System.out.println("-------------------------------------");
			System.out.println("ID: " + this.getEmployeeID());
			System.out.println("Name: " +this.getName());
			System.out.println("Age: "+ this.getAge());
			System.out.println("Sex: "+this.getGender());
			System.out.println("Status: " + this.getStatus());
			
			if(this.role != null) {
				//only print if there is values in role
				System.out.println("Job Title: " + this.role.getTitle());
				System.out.println("Salary: " +this.role.getSalary());
			}
			else {//if there is no values in roll
				System.out.println("No role assigned.");
			}
			
			//instanceof checks whether an object is an instance of a specific class or a subclass
			//if statement for part or full employee to print
			if(this instanceof PartEmployee) {
				System.out.println("Part-time Hours: "+ ((PartEmployee)this).getPartHours());
				System.out.println("Hourly Rate: " + ((PartEmployee)this).getPartAmHour());
			}
			else if(this instanceof FullEmployee) {
				System.out.println("Full-time Hours: "+((FullEmployee)this).getFullHours());
				System.out.println("Hourly Rate: " + ((FullEmployee)this).getFullAmHour());
			}
			//
			System.out.println("-----------------------------------------");
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
