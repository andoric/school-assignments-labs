package cst8284_300_lab07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.Scanner;

public class AccountFileSaver {
	private Account act;
	String fileName ;
	private static Scanner in = new Scanner(System.in);
	
	AccountFileSaver(String fn) {
		this.fileName = fn;
	}
	
	public boolean saveAccount() throws BadFileException{
		try {
			File saveFile = new File(fileName);
			if (!saveFile.exists()) {
				saveFile.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
			writer.write(act.toString());
			writer.close();
		}catch(IOException e) {
			throw new BadFileException("Error writing to file");
		}
		return true;
	}

	public boolean createAccount() {
		boolean accountLoaded = false;
		try {
			System.out.println("Input Account Details.");
			String firstName = getResponseTo("First name: ");
			String lastName = getResponseTo("Last name: ");
			String actNum = getResponseTo("Account number (using format NNN-NNNNNNN): ");
    		String actStartUpDate = getResponseTo("Account startup date as YYYY-MM-DD: ");
    		setAccount(new Account(actNum, firstName, lastName, actStartUpDate));
			accountLoaded = true;
		} catch (BadAccountInputException ex) {
			System.out.println(ex.getMessage() + ". Please re-enter account details \n");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("General exception thrown. source unknown");
		}
		return accountLoaded;
	}
	
	private String getResponseTo(String s) {
		System.out.print(s);
		return(in.nextLine());
	}

	public boolean readAccount() throws BadFileException {
		try {
			StringBuilder accountReadBack = new StringBuilder();
			String output;
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while((output=reader.readLine())!=null) {
				accountReadBack.append(output);
				accountReadBack.append(System.lineSeparator());
			}reader.close();
			System.out.println(accountReadBack.toString());
		}catch(FileNotFoundException e) {
			throw new BadFileException("File does not exist");
		}catch(IOException e) {
			throw new BadFileException("Error reading file");
		}
		
		return true;
	}
	
	public boolean cleanAccountFile()  {
		try {
			File f = new File(fileName);
			if (f.delete())  {
				return true;
			}
			else {
				return false;
			}
		}
		
		catch (Exception e ) {
			System.out.println(" Error while reading file : " + e.getMessage() );
			return false;
		}
	}
	
	public Account getAccount() {
		return act;
	}

	public void setAccount(Account act) {
		this.act = act;
	}
		
	
}
