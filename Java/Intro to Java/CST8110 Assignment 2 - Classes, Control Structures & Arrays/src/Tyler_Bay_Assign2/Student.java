import java.util.Scanner;
/**
 * <p>
 * This class is designed to take the details of any number of students and calculate their final grade based
 * on the marks input by the user. After all inputs are given, the program outputs a full list of the students' grades.
 * Calculates letter grade and GPA for each student.
 * </p>
 * @author: Tyler Bay 
 * @student# 040 720 667
 * @version 1.0
 * @CST8110
 * @since 2019/11/01
 * 
 */

public class Student {
	private long studNumber;
	private String firstName, lastName;
	private double totalMarks, totalBonus, gpa, marks[];
	private static final int NUMBER_MARKS=3;				//static NUMBER_MARKS is the only value that needs to change
	private Scanner input;							//if the students require more than 3 marks each.
	private int bonus;

	public Student() {
		input = new Scanner(System.in);
		marks = new double [NUMBER_MARKS];
	}
	public void readStudentDetails() {
		System.out.print("Enter Student Number:");
		studNumber = input.nextLong();
		System.out.print("Enter first name:");
		firstName = input.next();
		System.out.print("Enter last name:");
		lastName = input.next();
		this.readMarks();
		do {
		System.out.print("Enter number of bonuses (no more than 5):");
		bonus= input.nextInt();
		if (bonus>5||bonus<0) {
			System.out.println("ERROR: Bonuses must be 5 or less" );
			bonus = input.nextInt();
		}
		}while (bonus>5||bonus<0); 
		this.readBonuses(bonus);
	}
	private void readMarks() {
		System.out.println("Please enter the student's three marks as percentages (0-100) one at a time.");
		for(int i=0;i<NUMBER_MARKS;i++) {
			do {
				System.out.print("Enter a mark:");
				marks[i]=input.nextDouble();
				if (marks[i]>100||marks[i]<0) {
					System.out.println("ERROR:Marks must be between 0-100");
					System.out.println("Enter a proper mark:");
					marks[i]=input.nextDouble();
				}
			}while(marks[i]>100||marks[i]<0); //ensures the code continues to execute if marks are out of bounds
				
			}
		}
	
	private void readBonuses(int x) {
		for (int i=0;i<x;i++) {
			System.out.println("Please enter the bonus #" + (i+1) ); //i+1 makes it more readable for the user.
			totalBonus+=input.nextDouble();							//bonus#1 instead of #0.
		}
	}
	public void calculateGpa() {
		for(int i=0;i<NUMBER_MARKS;i++) {
			totalMarks += marks[i];
		}
		totalMarks+=convertBonus();		//this is the only time convertBonus() is called, applying to totalMarks for use
		gpa = (totalMarks/(NUMBER_MARKS*100))*4;	//in the methods called after it.
		if (gpa>4) {							
			gpa = 4;							
		}
		if (!checkEligibility()) {		//check eligibility is true when no failing grades. 
			gpa = 0;
		}
	}
	private double convertBonus() {			//convert bonus as per the assignment is added on to gpa. However,
		if (totalBonus>15) {				//the values for the bonus are not applied until calculateGpa() is called,
			totalBonus = 15;				//and therefore calculateGpa() must be called before findGradeLetter().
		}									
											 											
		return (totalBonus/15)*2;			
	}
	public double calculatePercentage() {
		return (totalMarks/(NUMBER_MARKS*100))*100;					 
	}																
	public String findGradeLetter() {								
		if (!checkEligibility()) {
			return "F";
		}
		if (calculatePercentage()>=90) {
			return "A+";
		}else if (calculatePercentage()>=85) {
			return "A";
		}else if (calculatePercentage()>=80) {
			return "A-";
		}else if (calculatePercentage()>=77) {
			return "B+";
		}else if (calculatePercentage()>=73) {
			return "B";
		}else if (calculatePercentage()>=70) {
			return "B-";
		}else if (calculatePercentage()>=67) {
			return "C+";
		}else if (calculatePercentage()>=63) {
			return "C";
		}else if (calculatePercentage()>=60) {
			return "C-";
		}else if (calculatePercentage()>=57) {
			return "D+";
		}else if (calculatePercentage()>=53) {
			return "D";
		}else if (calculatePercentage()>=50) {
			return "D-";
		}return "F";	//this should be redundant as !checkEligibility() is called first.
	}
	private boolean checkEligibility() {
		for (int i=0;i<NUMBER_MARKS;i++) {
			if (marks[i]<50) {
				return false;
		}
		}return true;
	}
	public void displayStudentDetails() {
		String format = ("|%10s\t|%16s\t|%10.2f\t|%5.2f|%8s\t\t|\n");	//printf format string. e.g. |+right oriented 10 spaces of padding,[arg], tab.
		String format2 = ("|%10s\t|%16s\t|%10.2f\t|%5.2f|%8s\t\t|%40s\n");	

		if (checkEligibility()) {
			System.out.printf(format, studNumber , firstName+" "+lastName, 
					totalMarks, gpa, findGradeLetter());
		}else
		System.out.printf(format2, studNumber , firstName+" "+lastName, 
				totalMarks, gpa, findGradeLetter(),
				"Note: Failed one or more course");
	}
	public static void displayTitle() {
		System.out.println("GPA CALCULATOR\n==============");
	}
	public static void displayHeader() {
		System.out.println("********************************************************************************");
		System.out.printf("%40s","MARKLIST\n");
		System.out.println("********************************************************************************");
		String format = ("|%10s\t|%16s\t|%10s\t|%-5s|%8s\t|%n");	
		System.out.printf(format, "Student Number","Name"," Total Marks"," GPA"," Grade Letter");
		System.out.println("--------------------------------------------------------------------------------");

		}
		
	}


