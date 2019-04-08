package edu.monash.fit2099.engine;

import java.util.Scanner;

/**
 * Class that manages I/O for the system
 */
public class Display  {

	private Scanner keyboard = new Scanner(System.in);

	/**
	 * Display a displayable object.
	 *
	 * @param printable the object to display
	 */
	public void print(Printable printable) {
		System.out.print(printable.getDisplayChar());
	}

	public void println(String s) {
		System.out.println(s);
	}

	public void endLine() {
		System.out.println("");
	}

	public char readChar() {
		String s = keyboard.next();
		return s.charAt(0);
	}
}
