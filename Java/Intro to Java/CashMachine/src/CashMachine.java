import java.util.Scanner;
/**
 * @CST8110_342
 * @Author Tyler Bay
 * @since 2019-10-27
 * @version 1.0
 * <p>
 * This class accepts console inputs for purchasing set items, and calculating the given tax rate on said items, to be returned 
 * on a receipt.
 * <p> 
 */
public class CashMachine {
	private static final int MAX_ITEMS = 10;
	private int itemCount;
	private double tax, sum;
	private String receipt = "";
	Scanner consoleInput = new Scanner(System.in);
	
	private Item[] items;
	
	public CashMachine (double tax){
		this.tax = tax;
		items = new Item[MAX_ITEMS];
	}
	private String getOneStringInput(String a){
		System.out.print(a);
		return consoleInput.next();	
	}
	private double getOneDoubleInput(String a) {
		System.out.print(a);
		return consoleInput.nextDouble();
	}
	private int getItemCount() {
		return itemCount;
	}
	private double calculateTax() {
		return sum*tax;
	}
	private double calculateTaxPlusSum() {
		return calculateTax()+sum;
	}
	public boolean processMenu() {		
		double compare;
//		int compareSwitch;
		compare = getOneDoubleInput("\nAction>>");
//		compareSwitch = (int)getOneDoubleInput("\nAction>>");
		if (compare == 1){
			purchaseItem();
		}else if (compare ==2) {
			printReceipt();
		}else if (compare ==3) {
			return false;
		}return true;
//		switch (compareSwitch){
//		case 1:purchaseItem();
//			break;
//		case 2:printReceipt();
//			break;
//		case 3:return false;
//		}return true;
	}
	private void purchaseItem() {
		String itemName, temp="";
		double itemPrice;
		System.out.print("Item name(no spaces)>>");
		itemName = getOneStringInput(temp);
		System.out.print("Item price>>");
		itemPrice = getOneDoubleInput(temp);
	//	itemCount++;
		sum += itemPrice;
		items[itemCount++] = new Item(itemName,itemPrice);
	//	receipt += String.format("%-15s$%.2f%n", itemName, itemPrice);
	}
	public void printMenu() {
		System.out.print("\n1)Purchase Item\n2)Print Receipt\n3)Quit\n");
	}
	private void printReceipt() {
		if (getItemCount()>0) {
			System.out.println("\n Receipt for " + getItemCount() + " items:");
			for (int i = 0; i < itemCount; i++) {
				System.out.print(items[i]);
			}
			
			System.out.printf("%-15s$%.2f%n", "Tax:", calculateTax());
			System.out.printf("%-15s$%.2f%n", "Total:", calculateTaxPlusSum());
		} else {
			System.out.println("\nEmpty!");
		}
	}
}
