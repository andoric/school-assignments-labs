package cst8284.assignment2.officeManager;
import java.util.Scanner;
/**
 * @ClassName OfficeManager
 * @author Tyler Bay
 * @description This class works with a framework of Employee based classes in order to manage 
 * a small business. <br> It stores the Employee objects containing the employee data in a one 
 * dimensional array of objects. It is essentially a small working DBMS for a small office environment. 
 * @date 2020-03-04
 */

public class OfficeManager {
	private double totalSalary, totalBonus, grandTotal;
	private int totalHours, lastEmployeeIndex=0;		//totalHours is never used, but in the UML, so here it is.
	private Scanner scanner;
	private Employee employees[] = new Employee[100];
	private final int 	CREATE_EMPLOYEE = 1,
						DISPLAY_EMPLOYEE=2,
						DISPLAY_EMPLOYEES=3,
						DISPLAY_TOTAL_COMPENSATION=4,
						EXIT=0;
	private boolean running = true;
	/**
	 * inititalizes scanner object for use throughout class
	 */
	public OfficeManager() {
		scanner = new Scanner(System.in);
	}
	/**
	 * do-while to display the menu and execute user choices.
	 */
	public void launch() {
		do {
			int menuItem;
			System.out.println(displayMenu());
			menuItem = scanner.nextInt();
			scanner.nextLine();
			executeMenuItem(menuItem);

		}while (running);
	}
	/**
	 * outputs a simple menu to the console with options for the user.
	 * @return String
	 */
	private String displayMenu() {
		return("Enter a selection from the following menu: \n"
				+ "1. Create an employee \n"
				+ "2. Display an employee \n"
				+ "3. Display all employees \n"
				+ "4. Display total compensation to all employees \n"
				+ "0. Exit Program \n");
	}
	/**
	 * Takes a user input as a parameter and executes the correct menu item based on the input.
	 * @param choice
	 */
	private void executeMenuItem(int choice) {
		if (choice == CREATE_EMPLOYEE) {
			String fullname, address, name[];
			double salary=0;
			int empType=0;
			Employee tempEmp; //Temporary employee object to store values before committing to array.
			System.out.println("Select type of employee: \n"
					+ "1. Supervisor \n"
					+ "2. Assistant \n"
					+ "3. Driver");
			empType = scanner.nextInt();
			scanner.nextLine();		//nextLine added to dump the '\n' not added by nextInt() src=https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
			System.out.println("Enter employee FirstName LastName: ");
			fullname=scanner.nextLine();
			name= fullname.split(" ");
			System.out.println("Enter employee address:");
			address = scanner.nextLine();
			System.out.println("Salary in dollars:");
			salary = scanner.nextDouble();
			scanner.nextLine();		//re: line 69
			
			switch(empType){
			case 1:
				tempEmp= new Supervisor(name[0], name[1], salary);
				tempEmp.setAddress(address);
				System.out.println("Bonus in dollars:");
				double bonus = scanner.nextDouble();
				scanner.nextLine();		//re: line 69
				((Supervisor) tempEmp).setBonus(bonus);	//casting is necessary to give access to child methods
				saveEmployee(tempEmp);
				break;
			case 2:
				tempEmp= new Assistant(name[0],name[1],salary);
				tempEmp.setAddress(address);
				System.out.println("Hourly rate for overtime: ");
				double ot = scanner.nextDouble();
				scanner.nextLine();		//re: line 69
				((Assistant) tempEmp).setOverTimeRate(ot);
				System.out.println("Extra Hours: ");
				int hrs = scanner.nextInt();
				scanner.nextLine();		//re: line 69
				((Assistant) tempEmp).setExtraHours(hrs);
				saveEmployee(tempEmp);
				break;
			case 3:
				tempEmp = new Driver(name[0],name[1],salary);
				tempEmp.setAddress(address);
				System.out.println("Driving License Number: ");
				String dlNum = scanner.next();
				((Driver) tempEmp).setLicense(dlNum);
				System.out.println("Hourly Rate: ");
				double hrly = scanner.nextDouble();
				scanner.nextLine();
				((Driver) tempEmp).setHourlyRate(hrly);
				System.out.println("Number of hours: ");
				int numHrs = scanner.nextInt();
				totalHours+=numHrs;					//keeps a running tally of hours for no reason
				scanner.nextLine();
				((Driver) tempEmp).setNumDrivingHours(numHrs);
				System.out.println("Number of traffic violations: ");
				int violations = scanner.nextInt();
				scanner.nextLine();
				((Driver) tempEmp).setTrafficViolations(violations);
				saveEmployee(tempEmp);
				break;
			default:
				System.out.println("Error: invalid employee type");
			}
			
			
		}else if (choice == DISPLAY_EMPLOYEE) {
			System.out.print("Enter Employee name: ");
			String name = scanner.nextLine();
			String splitName[] = name.split(" ");
			getEmployee(splitName[0],splitName[1]);
		}else if (choice == DISPLAY_EMPLOYEES) {
			getEmployees();
			
		}else if (choice == DISPLAY_TOTAL_COMPENSATION) {
			System.out.println("Total compensation paid to all employees:");
			System.out.println("Total salaries: " + computeTotalSalaries());
			System.out.println("Total bonuses: " + computeTotalBonus());
			System.out.println("Grand Total: " + computeTotalCompensation());			
		}else if(choice == EXIT) {
			System.out.println("Goodbye!");
			running = false;
		}
		
	}

	/**
	 * Takes an Employee object as a param to see if it is possible to add an employee to the array
	 * based on two conditions: if the array is full you can't add a new employee, and if the employee
	 * already exists (based on name and address) you cannot add the same employee. Automatically returns
	 * true if no employees have been added to the array yet.
	 * @param employ
	 * @return boolean
	 */
	private boolean addEmployee(Employee employ) {
		if(getEmployeeIndex()==0) {
			return true;
		}
		if (getEmployeeIndex() <100) {

			for(int i =0;i<getEmployeeIndex();i++) {
				String arrCompareName, paramCompareName, arrCompareAddr, paramCompareAddr;
				arrCompareName =employees[i].getName();
				paramCompareName = employ.getName();
				arrCompareAddr = employees[i].getAddress();
				paramCompareAddr = employ.getAddress();
				if (arrCompareName.equals(paramCompareName)&&arrCompareAddr.equals(paramCompareAddr)) {
					System.out.println("Error: That employee already exists.");
					return false;
				}	
			}	
			return true;
		}System.out.println("Error: Maximum number of employees (100) reached.");
		return false;
	}
	/**
	 * Takes an employee object as a param, first calling addEmployee(param) and adding it to
	 * the array and incrementing the working index if it is possible to add.
	 * @param employ
	 * @return boolean
	 */
	private boolean saveEmployee(Employee employ) {
		if(addEmployee(employ)) {
			employees[getEmployeeIndex()] = employ;
			System.out.println("Success! Employee Saved");
			lastEmployeeIndex++;	//must be incremented directly, unless an increment method was to be created.
			return true;
		}System.out.println("Error: unable to save");
		return false;
	}
	/**
	 * computes total base salaries.<br> 
	 * 
	 * Salary calculations can never be correct as per UML and program instructions.
	 * Drivers are paid two salaries, as they are given a base salary, and then also calculated 
	 * based on hourly rate. <br><br>Either the user input to a driver constructor should not take salary, or the
	 * hours worked/hourly rate should be derived from the salary provided. 
	 *  
	 * @return double base salaries
	 */
	private double computeTotalSalaries() {
		totalSalary=0;
		for(int i =0;i<getEmployeeIndex();i++) {
			totalSalary+=employees[i].getBaseSalary();
		}return totalSalary;
		
	}
	/**
	 * Computes all bonuses paid to supervisors, and all overtime paid to assistants,
	 * assuming that overtime is considered a bonus..?
	 * @return double amount of bonuses paid
	 */
	private double computeTotalBonus() {
		totalBonus=0;
		for (int i =0;i<getEmployeeIndex();i++) {
			totalBonus+=employees[i].computeSalary();
		}return totalBonus - computeTotalSalaries();
	}
	/**
	 * Computes the total compensation given to all employees.
	 * @return double value of all compensation paid.
	 */
	private double computeTotalCompensation() {
		grandTotal = 0;
		for(int i =0;i<getEmployeeIndex();i++) {
			grandTotal+=employees[i].computeSalary();
		}return grandTotal;
	}
	/**
	 * A method to output all employees in the array.
	 * @return
	 */
	private Employee[] getEmployees() {
		for(int i =0;i<getEmployeeIndex();i++) {
			System.out.println("Employee #"+(i+1));
			System.out.println(employees[i].toString());
		}
		return employees;
	}
/**
 * a getter to add a layer of protection for the private variable, but it's a private method, so it seems redundant.
 * @return lastEmployeeIndex
 */
	private int getEmployeeIndex() {
		return lastEmployeeIndex;	
	}
	/**
	 * A method to search the array for an employee with a name that matches the params.
	 * @param fname
	 * @param lname
	 * @return
	 */
	private Employee getEmployee(String fname, String lname) {
		for (int i =0;i<getEmployeeIndex();i++) {
			if (employees[i].getName().equals(fname+" "+lname)) {
				System.out.println(employees[i].toString());
				return employees[i];
			}
		}
		System.out.println("Employee not found.");
		return null;
		
	}
	

}
