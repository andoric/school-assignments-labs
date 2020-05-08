import java.util.Scanner;

public class Count {
	Scanner input = new Scanner(System.in);
	private int startNum, stepSize;
	public Count(){
		this(0,0);
	}
	private Count(int x, int y) {
		startNum = x;
		stepSize = y;
	}
	private void getValuesFromUser() {
		startNum = 0; stepSize = 0;
		while(startNum<=0) {
			System.out.print("Enter the number to start with:");
			startNum=input.nextInt();
			if (startNum>0) {
				break;
			}else {
				System.out.print("Input must be >0...");
				}
		}
		while(stepSize<=0) {
			System.out.print("Enter how much you want to count down by:");
			stepSize=input.nextInt();
			if (stepSize>0) {
				break;
			}else {
				System.out.print("Input must be >0...");
				}
		}
	}
	public void printMenu() {
		System.out.print("\n1)Display Count \n2)Exit");
	}
	public boolean processMenu() {
		int compare;
		System.out.print("\nEnter your selection:");
		compare = input.nextInt();
		if (compare ==1) {
			getValuesFromUser();
			displaySteps();
		}else if (compare==2) {
			return false;
		}else{
			System.out.println("***invalid input***");
		}return true;
	}
	private void displaySteps() {
		System.out.println("The numbers are:");
		for(;startNum>=0;startNum=startNum-stepSize) {
			System.out.print(startNum + " ");
		}System.out.println();
	}

}
