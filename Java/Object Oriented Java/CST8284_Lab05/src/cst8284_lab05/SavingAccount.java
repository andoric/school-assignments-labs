package cst8284_lab05;

public class SavingAccount extends BankAccount {
	private static final double FEE = 2;
	private static final double INTEREST = 2;

	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public SavingAccount(String name) {
		super(name, 0 ,FEE, INTEREST);

	}
	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public SavingAccount(String name, double b) {
		super(name, b, FEE, INTEREST);

	}

	@Override
	public String toString(){
		return ("Saving Account extends " + super.toString() );
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SavingAccount) {			
			return super.equals(obj);
		}return false;
	}



}
