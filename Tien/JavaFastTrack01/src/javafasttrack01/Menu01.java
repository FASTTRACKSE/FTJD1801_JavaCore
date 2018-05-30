package javafasttrack01;

import java.util.Scanner;

public class Menu01 {

	public static void main(String[] args) {
		while(true) {
			int mChon;
			System.out.println("-----------------------------------");
			System.out.println("MENU");
			System.out.println("1. Add student");
			System.out.println("2. Delete a student");
			System.out.println("3. Exit");
			System.out.println("-----------------------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn chọn: ");
			mChon = sc.nextInt();
			switch(mChon) {
				case 1: System.out.println("You add student"); break;
				case 2: System.out.println("You delete a student"); break;
				case 3: System.out.println("Exit program"); break;
			}
			if(mChon == 3) {
				break;
			}
		}
	}

}
