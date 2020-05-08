package cst8284_300_lab07;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Account {
	private Integer transitNumber;
	private String accountNumber = "0000000";  // customer account number
	private String firstName, lastName;  
	private static final Calendar ACCOUNTSTARTDATE = Calendar.getInstance();
	private DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

	public Account(String accountNumber, String firstName, String lastName, String startDate) {
		dateFormat.setLenient(false);
		setAccountNumber(accountNumber);
		setFirstName(firstName);
		setLastName(lastName);
		setAccountStartDate(startDate);
	}
	
	private void setAccountNumber(String accountNumber) throws BadAccountInputException {	
		if(isDigitFormatCorrect(accountNumber)) {
			this.accountNumber = accountNumber;
		}else throw new BadAccountInputException("Bad Account Number: Incorrect Digits");
	}
	
	private static boolean isDigitFormatCorrect(String accountNumber ) {
		
		if(accountNumber.matches("^[12][4-9]{2}[ -]?[1-9]{7}$")) {
			//regex pattern to match format YZZ-XXXXXXX
			// Y : digit between 1 and 2
			// Z : digit between 4 and 9 
			// X : digit between 1 and 9
			// - : optional. if present, can be either a dash (-) or a space
			return true;
		}return false;
	}
	
	private static boolean isInputNameCorrect(String name) throws BadAccountInputException {
		if (name.matches("^[^-.' ][-a-zA-Z.' ]+[^-.' ]$")) {
			//regex pattern to ensure no dash, period, apostrophe, or space at beginning or end of name
			//these characters are allowed in the middle of the name, however.
			//note: dash characters must be first in character blocks when comparing against, as they are reserved in regex
			//format for range indication.
			return true;
		}else throw new BadAccountInputException("Bad Name Format");	
	}
	
	public void setAccountStartDate(String startDate) throws BadAccountInputException{		
		try {	
		Date date = dateFormat.parse(startDate);
		Date lowerBound = dateFormat.parse("1900-01-01");
		Date upperBound = new Date();
		if(date.compareTo(lowerBound)<0) {
			throw new BadAccountInputException("Date cannot be that old");
		}else if(date.compareTo(upperBound)>0) {
			throw new BadAccountInputException("Date cannot be in the future");
		}
		ACCOUNTSTARTDATE.setTime(date);
		
	
		}catch(RuntimeException e) {
			throw new BadAccountInputException(e.getMessage()+"\nGeneral runtime exception thrown setting start date");
		}catch(ParseException e) {
			throw new BadAccountInputException("Parse Exception: Format is YYYY-MM-DD");
		}
		
	}
	private void setFirstName(String firstName) {
		if (isInputNameCorrect(firstName)) 
			this.firstName = firstName;
	}
	
	private void setLastName(String lastName) {
		if (isInputNameCorrect(lastName)) 
			this.lastName = lastName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}	
	
	public Calendar getAccountStartDate() {
		return ACCOUNTSTARTDATE;
	}
	
	public String toString() {
		return "Customer name: " + getFirstName() + " " + getLastName() 
			+ "\nCustomer Account number: " + getAccountNumber()
			+ "\nAccount Created: " + getAccountStartDate().getTime().toString();
	}
	
}
