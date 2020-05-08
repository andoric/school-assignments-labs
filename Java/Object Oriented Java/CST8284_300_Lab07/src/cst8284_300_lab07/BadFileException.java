package cst8284_300_lab07;

public class BadFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadFileException(String s) {
		super(s);
	}
	public BadFileException() {
		this("Bad File: error accessing file");
	}
}
