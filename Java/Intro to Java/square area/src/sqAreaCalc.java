import java.text.DecimalFormat;
import java.util.Scanner;


public class sqAreaCalc {
	public static void main (String args[]) {
	double sqSide;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the size of the square in cm:");
	sqSide = input.nextDouble();
	DecimalFormat form1 = new DecimalFormat("0.00");
	System.out.println("The area of a square of side " + sqSide + " cm is "+ form1.format(sqSide*sqSide) + "cm2.");
	input.close();
	
	}
}
