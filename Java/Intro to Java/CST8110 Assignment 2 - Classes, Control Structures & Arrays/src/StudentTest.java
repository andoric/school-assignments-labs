import java.util.Scanner;
/**
 * <p>
 * This class is the test class that runs the main method for class Student. It takes the input of how many
 * students you will be inputting grades for, and then iterates through the Student methods for each student in the array.
 * Finally, it calls the Student.displayStudentDetails() method to show a list of the final grades for all students.
 * </p>
 *@author: Tyler Bay 
* @student# 040 720 667
* @version 1.0
* @CST8110
* @since 2019/11/01
* 
*/

public class StudentTest {
	public static void main(String[]args) {
		int numStudents;
		Scanner inputter = new Scanner(System.in);  //second scanner class required as Student.input is not created
		Student.displayTitle();						//until a student object is created.
		System.out.print("Please enter the number of students:");
//		do {
		numStudents = inputter.nextInt();
//		if (numStudents<0&&numStudents>100) {
//			System.out.println("Error: number of students must be a real number < 100");
//		}
//		}while(numStudents<0&&numStudents>100);
		Student students[];
		students= new Student[numStudents];
		for (int i =0;i<students.length;i++) {  //array.length is a java utility that will count the current length
			System.out.println("Enter details of student " +(i+1)); //of an array. Useful for arrays you don't know
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");		//beforehand how long they will be. 
			students[i] = new Student(); //each array item must be instantiated. 
			students[i].readStudentDetails();
			students[i].calculateGpa(); 
			students[i].findGradeLetter();
		}
		Student.displayHeader();				//static methods and variables will be displayed in italics.
		for (int i =0;i<students.length;i++) {
			students[i].displayStudentDetails();
		}
		inputter.close();
	}

}
