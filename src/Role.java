public class Role{//PARENT CLASS
	/**
	 *
	/*
	 * title
	 * hours Worked*** might remove))
	 * salary
	 * 
	 * */
	private String title;
	private int hoursW;
	private String salary;
	
	public Role() {
		//null constructor
	}

	public Role(String title, int hoursW, String salary) {
		this.title = title;
		this.hoursW = hoursW;
		this.salary = salary;
	}
	
	public void printRoleDetails() {
		System.out.println("Job Title: " + getTitle());
		System.out.println("Hours: " + getHoursW());
		System.out.println("Salary: " +getSalary());
		System.out.println("-------------------------------------");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHoursW() {
		return hoursW;
	}

	public void setHoursW(int hoursW) {
		this.hoursW = hoursW;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
