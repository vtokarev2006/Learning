package p;

class Employee extends Person implements Comparable<Employee> {

	private double salary;

	private int id;
	static  int st;

	static {
		st=2;
	}
	
	public Employee(int id, String name) {
		super(name);
		this.id = id;
	}

	public Employee(String name, int id, double salary ) {
		super(name);
		this.id = id;
		this.salary = salary;
		
	}
	
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void riseSalary(double rise) {
		this.salary = this.salary * rise / 100;
	}

	@Override
	void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Employee arg0) {
		return Double.compare(this.salary,arg0.salary);
	}

	

}
