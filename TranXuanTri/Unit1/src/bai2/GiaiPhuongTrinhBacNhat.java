package bai2;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a, b ;

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("nhap so a ");
		a = scanner.nextInt();
		
		System.out.print("nhap so b ");
		b = scanner.nextInt();
		
		if (a==0) {
			if (b==0) {
				System.out.println("Phuong trinh vo so nghiem");
			}
			else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
		else {
			System.out.println("Phuong trinh co nghiem la " +(-b/a));
		}
	}
}
