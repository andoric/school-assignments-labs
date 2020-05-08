package assignment1.cst8284;
/**
 * @CST8284_303
 * @author: Tyler Bay
 * @since: 2020-01-21
 * @version 1.0
 * 
 * @Description: This is the test program to ensure that the Employee class is functioning properly.
 * 
 * 
 */

public class TestEmployee {
	
	public static void main(String[] args) {
		System.out.println("Employee Testing");
		Employee employee1 = new Employee("Robert Falk","Truck Driver",6);
		Employee employee2 = new Employee("Rosa Liam","Administrator",13);
		System.out.println(employee1.getName() + ", "+ employee1.getTitle()+", "+employee1.getSeniority());
		System.out.println(employee2.getName() + ", "+ employee2.getTitle()+", "+employee2.getSeniority());
		employee1.setTitle();
		System.out.println(employee1.getName() + ", "+ employee1.getTitle()+", "+employee1.getSeniority());
		employee2.setSeniority();
		System.out.println(employee2.getName() + ", "+ employee2.getTitle()+", "+employee2.getSeniority());

		
	}


}
