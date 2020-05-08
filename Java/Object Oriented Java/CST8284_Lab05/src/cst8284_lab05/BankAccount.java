package cst8284_lab05;


public class BankAccount {
	
	private String accountHolder;
	private double balance;    // current balance
	private double totalFees; // total fees paid
	
	private double bankFee;
	private double interestRate;
		
	/*
	 * Constructor
	 */
	public BankAccount(String name, double b) {
		
		accountHolder = name;
		balance = b;
	}
		
	/*
	 * Constructor
	 */
	public BankAccount(String name, double b, double fee, double rate) {
		
		accountHolder = name;
		balance = b;
		bankFee = fee;
		interestRate = rate;
	}

		
	public BankAccount(String name) {
		accountHolder = name;
	}

	/**
	  * Get the account balance 
	  *    
	  * @param   none
	  * @return  the account balance     
	  */
	protected double getBalance() {
		
		return balance;
	}
	
	/**
	  * Get the account holder 
	  *    
	  * @param   none
	  * @return  the account holder    
	  */
	protected String getAccountHolder() {
		
		return accountHolder;
	}
	
	
	/**
	  * Get the account fee
	  *    
	  * @param   none
	  * @return  the account fee   
	  */
	protected double getBankFee() {
		return bankFee;	
	}
	
	
	/**
	  * Get the account interest 
	  *    
	  * @param   none
	  * @return  the account interest rate  
	  */
	protected double getInterestRate() {

		return interestRate;
	}
	
	/**
	  * Get the total fees paid so far 
	  *    
	  * @param   none
	  * @return  the total of the fees    
	  */
	protected double getTotalFees() {

		return totalFees;
	}
	
	/**
	  * Increment the fees paid so far 
	  *    
	  * @param   amount to add
	  * @return  the total of the fees    
	  */
	protected void updateFees(double am) {
		
		totalFees+=am;
	}
	
	/*
	  * Decrement the balance by the amount
	  * 
	  * 
	  * 
	  *    
	  * @param   amount to decrement
	  * @return  boolean  
	  */
	private boolean decrementBalance(double amount) {

		if(amount+this.getBankFee()>this.getBalance()) {
			return false;
		}
		this.updateFees(bankFee);
		balance-=amount+this.getBankFee();
		return true;
	}

	/*
	  * Decrement the balance by the amount
	  * withdrawn if there are enough funds
	  * in the account 
	  * and return true
	  * Otherwise, return false
	  *    
	  *  The balance cannot go negative
	  *    
	  * @param   amount to withdraw
	  * @return  success or failure    
	  */
	protected boolean withdraw(double amount) {

		return decrementBalance(amount);
	}

	/**
	  * Decrement the balance by the amount
	  * withdrawn if there are enough funds
	  * in the account and apply the fee
	  * and return true
	  * Otherwise, return false
	  *    
	  * The balance cannot go negative
	  * Note:
	  * Uses decrementBalance()
	  *    
	  * @param   amount to withdraw
	  * @param   fee to apply
	  * @return  success or failure    
	  */
	protected boolean withdraw(double amount, double fee) {

		bankFee = fee;
		return decrementBalance(amount);
	}

	/**
	  * Increment the balance by the amount
	  * 
	  *    
	  * @param   amount to deposit
	  * @return  none    
	  */
	protected void deposit(double amount) {

		balance+=amount;
	}

	
	/**
	  * Get the interest earned on the balance 
	  *    
	  * @param   none
	  * @return  the interest on the balance     
	  */
	protected double getEarnedInterest() {
	
		return (this.getInterestRate()/100)*this.getBalance();	//this isn't how interest rates work??
	}
	
	protected double getTotalBalance() {
		return getBalance() + getEarnedInterest();
	}
	
	@Override
	public String toString(){
		return ("BankAccount extends " + super.toString() );
	}
	
	
	@Override
	public boolean equals(Object obj) { 	//takes an unknown obj type as a param
		if(obj instanceof BankAccount) {	//casts the unknown obj to the type of "this" for comparison of getBalance()
			BankAccount cmpObj = (BankAccount) obj;		
			return (this.getBalance()==cmpObj.getBalance());
		}
		return false;
	}
}
