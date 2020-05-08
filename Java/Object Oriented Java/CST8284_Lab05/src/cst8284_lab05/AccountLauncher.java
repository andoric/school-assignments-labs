package cst8284_lab05;

public class AccountLauncher {

	public static void main(String[] args) {

		  BankAccount account = new BankAccount("Paul", 2.0);
		  System.out.println(account.toString());
		  account.withdraw(1.0);
		  account.deposit(4.5);
		  System.out.println("Bank Account  balance:" + account.getBalance() + " totalFees=" + account.getTotalFees() );

		  
		  ChequingAccount chequing = new ChequingAccount("Roberto", 120.0);
		  System.out.println(chequing.toString());
		  for ( int i=0; i < 3; i++ ) {
			  chequing.deposit(5+i);
			  chequing.withdraw(1.0);
		  }		  
		  System.out.println("Chequing balance:" + chequing.getBalance()
		  					+ " totalFees=" + chequing.getTotalFees() 
		  					+ " Total Interest Earned=" + chequing.getEarnedInterest() );
		  
		
		  SavingAccount saving = new SavingAccount("Ajay", 12.0);
		  System.out.println(saving.toString());
		  saving.withdraw(1.0);
		  saving.deposit(4.5);
		  System.out.println("Saving balance:" + saving.getBalance() 
		  						+ " totalFees=" + saving.getTotalFees()
		  						+ " Total Interest Earned=" + saving.getEarnedInterest() );
		  

		  ExtraSavingAccount extra = new ExtraSavingAccount("Wei", 20.0);
		  System.out.println(extra.toString());
		  for ( int i=0; i < 5; i++ ) {
			  extra.deposit(25+i);
			  extra.withdraw(12-i);
		  }
		  System.out.println("Extra Saving balance:" + extra.getBalance() 
		  						+ " totalFees=" + extra.getTotalFees() 
		  						+ " Total Interest Earned=" + extra.getEarnedInterest());
		  
		  SavingAccount saving1 = new SavingAccount("Ajay", 2.0);
		  SavingAccount saving2 = new SavingAccount("Ajay", 2.0);
		 
		  ChequingAccount chequing1 = new ChequingAccount("Peter", 120.0); //this equals chequing3 as per lab instructions as written.
		  ChequingAccount chequing2 = new ChequingAccount("Paulo", 99.0);
		  ChequingAccount chequing3 = new ChequingAccount("Paulo", 120.0); //I understand that they are different names, but that is not a criteria in the instructions.
		  
		  ExtraSavingAccount extra1 = new ExtraSavingAccount("Victor", 12.0);
		  ExtraSavingAccount extra2 = new ExtraSavingAccount("Barbara", 11.0);
		  
	  
		  System.out.println("Saving Account 1 and 2 are " + (saving2.equals(saving1)?"":"NOT ") + "equal");
		  System.out.println("Chequing Account 1 and 2 are " + (chequing2.equals(chequing1)?"":"NOT ") + "equal");
		  
		  System.out.println("Chequing Account 1 and Saving Account 1 are " + (chequing1.equals(saving1)?"":"NOT ") + "equal");	
		  System.out.println("Chequing Account 1 and Chequing Account 3 are " + (chequing1.equals(chequing3)?"":"NOT ") + "equal");
		  
		  System.out.println("Extra Saving Account 1 and Extra Saving Account 2 are " + (extra1.equals(extra2)?"":"NOT ") + "equal");
	
		  System.out.println("Chequing Account 1 and Extra Saving Account 1 are " + (chequing1.equals(extra1)?"":"NOT ") + "equal");
		  System.out.println("Extra Saving Account 1 and Saving Account 1 are " + (extra1.equals(saving1)?"":"NOT ") + "equal");
		  
		  

	}
}
