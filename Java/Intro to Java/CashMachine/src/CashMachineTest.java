
public class CashMachineTest {
	public static void main( String[] args){
		
		CashMachine cashMachine = new CashMachine(0.15);

		System.out.println("Welcome to CashMachine!");
		
		do{
			cashMachine.printMenu();
		}while( cashMachine.processMenu());

		System.out.println();
		System.out.println("GoodBye!!");
	}

}
