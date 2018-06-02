package tonghop;

import java.util.Scanner; 

public class BaiTongHop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			giaiPhuongTrinhBacNhat();

		} else if (choice == 2) {
			giaiPhuongTrinhBacHai();

		} else if (choice == 3) {
			System.out.println("Exit");

		}
	}
	public static void menu() {
		System.out.println("-------");
		System.out.println("Menu");
		System.out.println("1. Giai phuong trinh bac nhat");
		System.out.println("2. Giai phuong trinh bac hai");
		System.out.println("3. Exit");
		System.out.println("------");
		System.out.println("Choice ");
	}
	public static void giaiPhuongTrinhBacNhat() {
		double a, b ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("nhap so a ");
		a = scanner.nextInt(); //type a from keyboard
		
		System.out.print("nhap so b ");
		b = scanner.nextInt(); //type b from keyboard
		scanner.close();
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
	public static void giaiPhuongTrinhBacHai() {
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
		if (a==0) {
			if (b==0) {
				if (c==0) {
					System.out.println("Phuong trinh vo so nghiem");
				}
				else {
					System.out.println("Phuong trinh vo nghiem");
				}
			}
			else {
				x = -c/b;
				System.out.println("Phuong trinh co nghiem la " +x);
			}
		}
		else {
		
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
}
