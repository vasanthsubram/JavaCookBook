package io;

import java.io.IOException;

public class WaitForUser {


	public static void main(String[] args) throws IOException {
		
		System.out.println("Hit enter or Ctrl-z to continue .....");
		System.in.read();
		System.out.println("Continuing.....");
		System.out.println("Done !!!");
	}

}
