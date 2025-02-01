
public class Employee {
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
	//private Role role;
	//private salary; OBJECT
	//private status;OBJECT
	
	
	public Employee() {
		//null constructor
	}
	public Employee(int employeeID,String name, int age, String gender) {
		this.employeeID = employeeID;
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	
	
	
	
}
