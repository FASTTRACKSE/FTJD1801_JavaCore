package fasttrackse.practice3;

import java.util.Scanner;

public class JavaHomework7 {

	public static void main(String[] args) {
		int choice;

		while (true) {
			System.out.println("Choices");
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Exit");
			System.out.println("Make your choice");
			Scanner Scanner = new Scanner(System.in);
			choice = Scanner.nextInt();
			
			if (choice == 2) {
				System.out.println("Select a student to remove");
			
			}

			else if(choice == 3) {
			System.out.println("You chose exit");
				break;

			}

		}
	}
}

