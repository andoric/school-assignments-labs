package cst8284.assignment2.officeManager;
/**
 * @ClassName Driver
 * @author Tyler Bay
 * @description This is a subclass of the Employee type. It inherits most of its usefulness from
 * Employee, but implements features specific to Drivers: they are paid hourly, and have Drivers licenses
 * and traffic violations stored.
 * @date 2020-03-04
 */

public class Driver extends Employee {
	private String driverLicense;
	private int trafficViolations, numDrivingHours;
	private double hourlyRate;

	/**
	 * All constructors of subclasses chain to the super constructors.
	 */
	public Driver() {
		super();
	}

	public Driver(String first, String last) {
		super(first, last);
		
	}

	public Driver(String first, String last, double salary) {
		super(first, last, salary);
		
	}
	@Override
	protected double computeSalary() { 		//this is confusing because as per instructions you are supposed
		return hourlyRate*numDrivingHours;	//to ask for salary, and also their salary is hourly. They are paid
											//twice? Payroll needs to look into this....
	}
	protected boolean canDrive() {		//this is never used for anything.
		return trafficViolations<3
				&&numDrivingHours<300
				&&driverLicense!=null;			
	}
	protected void setLicense(String lic) {
		driverLicense = lic;
	}
	protected void setTrafficViolations(int vio) {
		trafficViolations=vio;
	}
	protected void setNumDrivingHours(int hrs) {
		numDrivingHours = hrs;
	}
	protected void setHourlyRate(double rate) {
		hourlyRate = rate;
	}
	protected String getLicense() {
		return driverLicense;
	}
	protected int getTrafficViolations() {
		return trafficViolations;
	}
	protected int getNumHours() {
		return numDrivingHours;
	}
	protected double getHourlyRate() {
		return hourlyRate;
	}
	@Override
	protected double getBaseSalary() {		//quick fix for the salary calculation issue.
		return computeSalary();
	}
	
	
	
	@Override
	public String toString() {
		return ("Job Function: Driver:"+"\n"
				+ super.toString()
				+"Driver Licence Number: "+getLicense()+"\n"
				+"Hourly Rate: " + getHourlyRate()+"\n"
				+"Number of Hours: "+getNumHours()+"\n"
				+"Number of traffic violations: "+getTrafficViolations()+"\n");
	}
	
	

}
