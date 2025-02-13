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
	private String salary;
	
	public Role() {
		//null constructor
	}

	public Role(String title,String salary) {
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


	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
