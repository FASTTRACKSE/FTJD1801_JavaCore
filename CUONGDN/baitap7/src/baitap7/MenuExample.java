package baitap7;
import java.util.Scanner;
public class MenuExample {

	public static void main(String[] args) {
		while (true) {
			System.out.println("-------");
			System.out.println("Menu");
			System.out.println("1. Add student");
			System.out.println("2. Delete student");
			System.out.println("3. Exit");
			System.out.println("------");
			System.out.println("Choice");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("You add a sutdent");
			} else if (choice == 2) {
				System.out.println("You delete a student");
			} else if (choice == 3) {
				System.out.println("Exit program");
				break;
	}

}
	}
}
