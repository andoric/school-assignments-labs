import java.util.Scanner;
import java.lang.Math;
/*	This program defines the Car class and accepts input from CarTest.java to initialize, copy, and
 * 	alter values for the car class.
 * 
 * 		@author Tyler Bay
 * 		@version 1.0
 * 		@2019-09-19 Introduction to Computer Programming
 * 		@CST 8110_342 
 */

public class Car {

	Scanner input = new Scanner(System.in);
	
	private String plate;
	private int time;
	private double acceleration, velocity;
	
	public Car() {
		plate = "AAAA 111";
		time = 10;
		velocity = 98;
	}
	
	//main constructor statement, initializes variables based on input
	public Car (String inputPlate, int inputTime, double inputVelocity) {
		plate = inputPlate;
		time = inputTime;
		velocity = inputVelocity;
	}
	//secondary constructor that copies the values of the first input
	public Car(Car initialCar) {
		plate = initialCar.plate;
		time = initialCar.time;
		velocity = initialCar.velocity;
	}
	
	//scanner method that accepts new plate info
	public String inputPlate(){
		System.out.println("Enter the plate:");
		return plate = input.nextLine();	
	}
	//scanner method that accepts new time info (seconds)
	public int inputTime() {
		System.out.println("Enter the time:");
		return time= input.nextInt();
	}
	//scanner method that accepts new velocity	(m/s)
	public double inputVelocity() {
		System.out.println("Enter the velocity:");
		return velocity= input.nextDouble();
	}
	//calculation of acceleration, formatted to 2 decimal places (m/s^2)
	public double calcAcceleration() {
		acceleration = velocity/time;
		return acceleration = Math.floor(acceleration*100)/100;
	}
	//outputs car info as called by the various other constructors.
	public void displayCar() {
		System.out.println("Plate is " + plate + " with time of " + time + ", velocity of " + velocity);	
	}
	
}//End class Car

