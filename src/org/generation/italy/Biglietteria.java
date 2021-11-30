package org.generation.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int age, km;
		
		try {
			System.out.print("Enter your age: ");
			age = in.nextInt();
			System.out.print("Enter travel distance in km: ");
			km = in.nextInt();
			
			Biglietto ticket = new Biglietto(age, km);	
			System.out.println(ticket.calculatePrice() + "€");
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
		} 
		in.close();
	}

}
