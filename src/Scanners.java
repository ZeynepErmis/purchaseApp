/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Scanners {

	// method to get integer value from the user
	public static int nextInt() {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		boolean isNumber;

		// input validation
		do {
			if (scanner.hasNextInt()) {
				x = scanner.nextInt();
				isNumber = true;
			} else {
				System.out.println("You entered wrong value, please re-enter an integer value : ");
				isNumber = false;
				scanner.next();
			}
		} while (!(isNumber));

		return x;
	}

	// method to get double value from the user
	public static double nextDouble() {
		Scanner scanner = new Scanner(System.in);
		double y = 0.0;
		boolean isDouble;

		// input validation
		do {
			if (scanner.hasNextDouble()) {
				y = scanner.nextDouble();
				isDouble = true;
			} else {
				System.out.println("You entered wrong value, please re-enter a double value : ");
				isDouble = false;
				scanner.next();
			}
		} while (!(isDouble));

		return y;
	}

	// method to get String value from the user
	public static String nextString() {
		Scanner scanner = new Scanner(System.in);
		String z = null;
		boolean isString;

		// input validation
		do {
			if (scanner.hasNextLine()) {
				z = scanner.nextLine();
				isString = true;
			} else {
				System.out.println("You entered wrong value, please re-enter string value : ");
				isString = false;
				scanner.next();
			}
		} while (!(isString));
		return z;
	}

	// method to get char value from the user
	public static char nextChar() {
		Scanner scanner = new Scanner(System.in);
		char d = 0;
		boolean isChar;

		// input validation
		do {
			if (scanner.hasNextLine()) {
				d = scanner.next().charAt(0);
				isChar = true;
			} else {
				System.out.println("You entered wrong value, please re-enter a double value : ");
				isChar = false;
				scanner.next();
			}
		} while (!(isChar));

		return d;
	}

	// input validation for date
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean isValid(final String date) {

		boolean valid = false;

		try {
			sdf.parse(date);
			sdf.setLenient(false);
			valid = true;

		} catch (ParseException e) {
			valid = false;
		}
		return valid;
	}

}
