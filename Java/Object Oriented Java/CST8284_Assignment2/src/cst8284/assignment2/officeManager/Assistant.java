package cst8284.assignment2.officeManager;
/**
 * @ClassName Assistant
 * @author Tyler Bay
 * @description This is a subclass of the Employee type. It inherits most of its usefulness from
 * Employee, but implements features specific to Assistants: they are paid an hourly overtime rate
 * for hours work beyond their normal working hours that is added to their salary. 
 * @date 2020-03-04
 */

public class Assistant extends Employee {
	private int extraHours;
	private double overTimeRate;

	public Assistant() {
		super();
	}

	public Assistant(String first, String last) {
		super(first, last);
		
	}

	public Assistant(String first, String last, double salary) {
		super(first, last, salary);
		
	}
	@Override
	public double computeSalary() {
		return getBaseSalary()+(extraHours*overTimeRate);
	}
	public void setExtraHours(int hrs) {
		extraHours = hrs;
	}
	public void setOverTimeRate(double ot) {
		overTimeRate = ot;
	}
	public int getExtraHours() {
		return extraHours;
	}
	public double getOverTimeRate() {
		return overTimeRate;
	}
	@Override
	public String toString() {
		return("Job Function: Assistant\n"
				+super.toString()
				+"Hourly Rate for Overtime: "+getOverTimeRate()+"\n"
				+"Extra Hours: "+getExtraHours()+"\n");
	}

}
