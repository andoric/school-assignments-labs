package cst8284_300_lab07;

public class BadAccountInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadAccountInputException(String s) {
		super(s);
	}
	public BadAccountInputException() {
		this("Bad Input: value entered is incorrect");
	}
}
