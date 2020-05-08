package cst8284_300_lab07;

import java.io.IOException;
import java.util.Scanner;

public class AccountLauncher {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args)  {

		System.out.println("Start");
		
		System.out.println("Enter a filename to read/write account details: ");
		String fn  = in.nextLine();
		
		AccountFileSaver afs = new AccountFileSaver (fn);
		
		//Try to open the file if it exists and read the contents
		//Then delete it
		try {
			if ( afs.readAccount() ) {
				System.out.println("Deleting the file " + fn );
				afs.cleanAccountFile();
			}
		} 
		catch (BadFileException e) {
			
			System.out.println( e.getMessage());
		} 
	
		//Enter the account details
		do 
		{
			
		} while (!afs.createAccount()) ;
		
		// Save the account details in a file
		try {
			if ( afs.saveAccount() ) {
				System.out.println("Account Details Saved.");
			}
		} catch (BadFileException e) {
			
			System.out.println( e.getMessage());
		}
		
		//Read back the saved file
		try {
			System.out.println("Reading Account Details.");
			if ( !afs.readAccount() ) {
				System.out.println("Error Reading Account Details.");
			}
		}
		catch (BadFileException e) {
			
			System.out.println(e.getMessage());
		} 
		
		
		System.out.println("Done");
		
	}
	
}