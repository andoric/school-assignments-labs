import java.util.Scanner;

/**
 * 
 * @author Tyler Bay
 * lname:Bay
 * fname:Tyler
 * student#:040720667
 *
 */
public class PasswordTest {
	private static int doEncryption(Password p) {
		return p.second(p.first(p.getPassword()));
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a password WITHOUT spaces, tabs, breaks: ");
		Password pass = new Password(input.next());
		int x =doEncryption(pass);
		System.out.println(x);
		input.close();
	}
}
