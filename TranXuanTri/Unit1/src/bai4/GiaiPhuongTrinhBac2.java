package bai4;

import java.util.Scanner;

public class GiaiPhuongTrinhBac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b,c;
		double x,x1,x2;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap a ");
		a = scanner.nextInt();
		System.out.print("Nhap b ");
		b = scanner.nextInt();
		System.out.print("Nhap c ");
		c = scanner.nextInt();
		scanner.close();
		
		double delta = b^2 - 4*a*c;
		
		if (delta <0) {
			System.out.println("phuong trinh vo nghiem");
		}
		if (delta == 0) {
			x = -b/2*a;
			System.out.println("phuong trinh co 1 nghiem "+x);
		}
		if (delta > 0) {
			 x1 = ((-b + Math.sqrt(delta))/2*a);
			 x2 = ((-b - Math.sqrt(delta))/2*a);
			 System.out.printf ("Phuong trinh co 2 nghiem x1 = %.2f, x2 = %.2f", x1,x2);
		}
	}

}
