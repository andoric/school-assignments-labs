import java.util.Scanner;
public class Customer {
	private int itemCount, custNumber;
	private String name;
	private double totalCost;
	public double average;
	private Scanner input = new Scanner(System.in);
	public Customer() {
		this ("unknown",0,0,0);
	}
	public Customer(String n, int ic, int cn, double tc) {
		name = n;
		itemCount = ic;
		custNumber = cn;
		totalCost = tc;
	}
	public void inputCustomerDetail() {
		System.out.print("Customer Number:");
		custNumber = input.nextInt();
		System.out.print("Customer Name:");
		name = input.next();
		do {
			System.out.print("Total Cost:");
			totalCost = input.nextDouble();
			if(totalCost<=0) {
				System.out.print("Error! Total cost must be positive. Re-enter:");
				totalCost = input.nextDouble();
			}		
		}while (totalCost<=0);
		
		do {
			System.out.print("Item Count:");
			itemCount = input.nextInt();
			if(itemCount<=0) {
				System.out.print("Error! item count must be positive. Re-enter:");
				itemCount = input.nextInt();
			}		
		}while (itemCount<=0);
	}
	public void calculateAverage() {
		if (itemCount==0)
			average = 0.00;
		else
		average = totalCost/itemCount;
	}
	public void print(String x) {
		String format = "%10s |%10s |%15.2f |%10s |%15.2f |%-2s %n";
		System.out.printf(format, custNumber, name, totalCost, itemCount, average, x);
				
	}

}
