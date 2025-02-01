import java.io.Serializable;

public class Role implements Serializable {//PARENT CLASS
	/**
	 *
	/*
	 * title
	 * hours Worked
	 * salary
	 * 
	 * salary class inherits from Role class 
	 * status class inherits from Role class 
	 * 
	 * */
	private String title;
	private int hoursW;
	private String salary;

	private static final long serialVersionUID = 1L;
	
	public Role() {
		//null constructor
	}

	public Role(String title, int hoursW, String salary) {
		this.title = title;
		this.hoursW = hoursW;
		this.salary = salary;
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
