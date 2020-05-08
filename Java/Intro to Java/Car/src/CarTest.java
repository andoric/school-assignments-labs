public class CarTest {

	public static void main(String[] args) {
		// create a Car using the default constructor
		Car defaultCar=new Car();
		System.out.print("Default car attributes are: ");
		defaultCar.displayCar();
		System.out.println(" and acceleration of "+defaultCar.calcAcceleration());
		
		// create a Car using initial constructor
		Car initialCar=new Car("ABCD 123",10,50);
		System.out.print("Initial car attributes are: ");
		initialCar.displayCar();
		System.out.println(" and acceleration of "+initialCar.calcAcceleration());

		// create a Car using copy constructor
		Car copyCar=new Car(initialCar);
		System.out.print("Copied car attributes are: ");
		copyCar.displayCar();
		System.out.println(" and acceleration of "+copyCar.calcAcceleration());
		
		// change values based on user input
		System.out.println("\nUpdate car attributes: ");
		initialCar.inputPlate();
		initialCar.inputTime();
		initialCar.inputVelocity();
		System.out.print("Updated car attributes are: ");
		initialCar.displayCar();
		System.out.println(" and acceleration of "+initialCar.calcAcceleration());
	}
}
