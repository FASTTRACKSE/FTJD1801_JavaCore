package baitap7;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		while(true) {
			int mC;
			System.out.println("----------");
			System.out.println("Menu");
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Exit");
			System.out.println("----------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn chọn: ");
			mC = sc.nextInt();
			if (mC == 1 ) {
				System.out.println("You add Student");
			}
			if (mC == 2) {
				System.out.println("You delete a Student");
				
			}
			if (mC == 3) {
				System.out.println("Exit program");
				break;
				
			}
				
		
		}
	}

}
