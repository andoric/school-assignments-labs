package cst8284.assignment2.officeManager;
/**
 * @ClassName Employee
 * @author Tyler Bay
 * @description This class is the superclass framework for the following classes: Driver, 
 * Assistant, and Supervisor. It works with the OfficeManager class in order to track employee
 * details such as name, address, and salary. 
 * @date 2020-03-04
 */

class Employee {
	private String firstName, 
	lastName, 
	address;
	private double baseSalary;
	/**
	 * Default constructor, when given no inputs, defaults first and last name to null.
	 */
	public Employee() {
		this(null,null);
	}
	/**
	 * Name constructor, creates an employee based on first and last name.
	 * @param first
	 * @param last
	 */
	public Employee(String first, String last) {
		firstName = first;
		lastName = last;
	}
	/**
	 * Full param constructor, takes first and last names, and salary as arguments.
	 * @param first
	 * @param last
	 * @param salary
	 */
	public Employee(String first, String last, double salary) {
		firstName = first;
		lastName = last;
		baseSalary = salary;
		
	}
	protected String getName() {
		return firstName+" "+lastName;
	}
	protected void setFirstName(String name) {
		firstName = name;
	}
	protected void setLastName(String name) {
		lastName = name;
	}
	protected void setAddress(String addr) {
		address=addr;
	}
	protected void setBaseSalary(double sal) {
		baseSalary = sal;
	}
	protected double getBaseSalary() {
		return baseSalary;
	}
	protected String getAddress() {
		return address;
	}
	
	
	protected double computeSalary() {
		
		return baseSalary;
		
	}
	@Override
	public String toString() {
		return ("Name: "+ getName()+"\n"
				+"Address: "+getAddress()+"\n"
				+"Salary: "+getBaseSalary()+"\n");
	}
	
	

}
