package p;

public class Manager extends Employee {

	Manager() {
		super("", 0, 0);
		this.bonus = 0;
	}
	
	
	
	public Manager(String name, int id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}

	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSalary(){
		return super.getSalary()+bonus;
	}
	
}
