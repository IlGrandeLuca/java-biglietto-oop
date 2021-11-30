package org.generation.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Room 1
		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Enter your age: ");
			int age = in.nextInt();
			System.out.print("Enter travel distance in km: ");
			int km = in.nextInt();
			System.out.print("This ticket is flexible? Type 'true' or 'false': ");
			boolean flexible = in.nextBoolean();

			Biglietto ticket = new Biglietto(age, km, flexible);
			System.out.println("\nPrice: " + ticket.calculatePrice() + "€");
			System.out.println("Expire date: " + ticket.calculateExpire());
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
		}
		in.close();
	}

}
