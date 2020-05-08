
public class CountTest {
 public static void main(String[] args) {
	System.out.println("Program Developed by Tyler Bay");
	Count counter = new Count();
	do{
		counter.printMenu();
	}while(counter.processMenu());
	System.out.println("Goodbye!");
 }
}
