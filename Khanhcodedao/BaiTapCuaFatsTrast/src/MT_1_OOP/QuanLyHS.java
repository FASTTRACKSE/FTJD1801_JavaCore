package MT_1_OOP;

import java.util.Scanner;
public class QuanLyHS {
	public static void main(String[] args) { 
		
		while(true) {
			System.out.println(" =======MENU=======");
			System.out.println(" 1 : Add student");
			System.out.println(" 2 : Delete student");
			System.out.println(" 3 : Exit");
			System.out.println("--------------------");
			System.out.println(" moi ban nhap vao lua chon :");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("  display  '' add Student  ");
			
			}
			
			else if(choice == 2) {
				System.out.println("  display  '' delete student ");
				
			}
			
			else if(choice == 3) {
				System.out.println(" display  '' Exit progrram ");
				break;
			}
		}
	}

}
