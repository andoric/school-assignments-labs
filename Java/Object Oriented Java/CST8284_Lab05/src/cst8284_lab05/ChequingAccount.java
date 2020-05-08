package cst8284_lab05;

public class ChequingAccount extends BankAccount {
	private static final double FEE = 1;
	private static final double INTEREST = 0;

	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public ChequingAccount(String name) {
		super(name,0,FEE,INTEREST);
		
	}
	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public ChequingAccount(String name, double b) {
		super(name, b,FEE,INTEREST);
		
	}

	
	@Override
	public String toString(){
		return ("Chequing Account extends " + super.toString() );
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ChequingAccount) {
			return super.equals(obj);
		}return false;
		
	}

}
