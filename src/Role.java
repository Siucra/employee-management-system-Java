public class Role{//PARENT CLASS

	private String title;
	private double salary;
	
	public Role() {
		//null constructor
	}

	public Role(String title,double salary) {
		//super();
		this.title = title;
		this.salary = salary;
	}
	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
