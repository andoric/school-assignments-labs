package cst8284.assignment2.officeManager;
/**
 * @ClassName Supervisor
 * @author Tyler Bay
 * @description This is a subclass of the Employee type. It inherits most of its usefulness from
 * Employee, but implements features specific to Supervisors: they earn a bonus on top of their salary.
 * @date 2020-03-04
 */

public class Supervisor extends Employee {
	private double bonus;

	public Supervisor() {
		super();
	}

	public Supervisor(String first, String last) {
		super(first, last);
		
	}

	public Supervisor(String first, String last, double salary) {
		super(first, last, salary);
		
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double b) {
		bonus = b;
	}
	
	@Override
	protected double computeSalary() {
		return getBaseSalary()+bonus;
	}
	
	@Override
	public String toString() {
		return ("Job Function: Supervisor" +"\n"
				+super.toString() +
				"Bonus: "+getBonus() +"\n"
				);
	}
	

}
