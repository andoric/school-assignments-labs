package cst8284_lab05;

public class ExtraSavingAccount extends BankAccount {
	private static final double FEE = 5;
	private static final double INTEREST = 5;

	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public ExtraSavingAccount(String name) {
		super(name, 0, FEE, INTEREST);

	}
	/**
	 * All subclass constructors chain to the full param superclass constructor.
	 * params are (accountHolder, accountBalance, BankFee, and interestRate)
	 */
	public ExtraSavingAccount(String name, double b) {
		super(name, b, FEE, INTEREST);

	}
	
	@Override
	public String toString(){
		return ("Extra Saving Account extends " + super.toString() );
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ExtraSavingAccount) {
			return super.equals(obj);
		}return false;
	}



}
