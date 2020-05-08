package assignment1.cst8284;
import java.util.Scanner;
/**
 * @CST8284_303
 * @author: Tyler Bay
 * @since: 2020-01-21
 * @version 1.0
 * 
 * @Description: This class manages information for employees, managing their name, 
 * job title, and years of seniority.
 * 
 * 
 */

public class Employee {
	
	private String name, title;
	private int seniority;
	private Scanner input = new Scanner(System.in);
	
	public Employee (String name, String title, int seniority) {
		this.name = name;
		this.title = title;
		this.seniority = seniority;
	}
	public Employee(String name) {
		this(name, "null", 0);
	}
	public Employee() {
		this("null", "null", 0);
	}
	
	public String setName() {
		System.out.print("Please enter the new name for "+name+":");
		return name = input.nextLine();
	}
	public String setTitle() {
		System.out.print("Please enter the new title for "+name+":");
		return title = input.nextLine();
	}
	public int setSeniority() {
		System.out.print("Please enter the new years of seniority for "+name+":");
		return seniority = input.nextInt();
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public int getSeniority() {
		return seniority;
	}
}
