package unit1;

import java.util.Scanner;

public class MeNu {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Menu");
			System.out.println("1.Add Student");
			System.out.println("2.Delete Student");
			System.out.println("3.Exit");
			System.out.println("---------------");
			System.out.println("Choice:");
			int choice = sc.nextInt();
			if (choice == 3) {
				System.out.println("Exit progam");
				break;
			} else if (choice == 2) {
				System.out.println("You delete a student");
			} else if (choice == 1) {
				System.out.println("you add student");
			}

		}
	}

}
