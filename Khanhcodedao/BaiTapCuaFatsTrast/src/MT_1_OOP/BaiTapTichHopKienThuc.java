package MT_1_OOP;

import java.util.Scanner;

public class BaiTapTichHopKienThuc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tinhnang;
		System.out.println("===========MAY TINH =========");
		System.out.println(" 1 : phuong trinh bat nhat .");
		System.out.println(" 2 : phuong trinh bat hai .");
		System.out.println(" 3 : thoat chuong trinh .");
		System.out.println("-----------------------------");
		System.out.println(" moi ban chon tinh nang :");
		tinhnang = Integer.parseInt(sc.nextLine());
		
		if(tinhnang==1) {
			float a,b;
				System.out.println(" GIAI PHUONG TRINH BAT NHAT ");
				System.out.println("-----------------------------");
				System.out.print(" Nhap vao a :");
				a = Float.parseFloat(sc.nextLine());
				System.out.print(" Nhap vao b :");
				b = Float.parseFloat(sc.nextLine());
		
		
				if(a==0) {
					if(b==0) {
						System.out.println(" phuong trinh vo so nghiem .");
					}
					else {
						System.out.println(" phuong trinh vo nghiem .");
					}
				}
				else {
					System.out.println(" phuong trinh co nghiem  : "+(-b/a));
				}
		}
		else if(tinhnang==2) {
			int a, b, c;
			int D;
			double X1  , X2;
			System.out.println("===== giai phuong trinh bat 2=====");
			System.out.print(" nhap A : ");
			a = Integer.parseInt(sc.nextLine());
			System.out.print(" nhap B : ");
			b = Integer.parseInt(sc.nextLine());
			System.out.print(" nhap C : ");
			c = Integer.parseInt(sc.nextLine());
			
				D=((b*b)-(4*a*c));
			if(D < 0) {
				System.out.println(" phuong trinh vo nghiem .");
			}
			else if(D==0) {
				System.out.println(" phuong trinh co nghiem kep X1 = X2 = "+((-b)/2*a));
			}
			else{
				System.out.println(" phuong trinh co 2 nghiem phan biet ");
				X1 = (-b + Math.sqrt(D))/(2*a);
				X2= (-b - Math.sqrt(D))/(2*a);
				
				System.out.printf(" %.1f ",X1);
				System.out.printf(" %.1f ",X2);
			}
		}
		else {
			System.out.println(" ban da thoat chuong trinh ");
		}
}
}
