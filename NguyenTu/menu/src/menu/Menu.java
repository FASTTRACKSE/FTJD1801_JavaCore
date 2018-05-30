package menu;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
		System.out.println("----------");
		System.out.println("Menu");
		System.out.println("1.Add student");
		System.out.println("2.Delete a student");
		System.out.println("3.Exit");
		System.out.println("----------");
		System.out.println("Choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if(choice==3) {
			break;
		}
		}
	}

}
