package MT_1_OOP;

import java.util.Scanner;
public class GiaiPTBat_1 {
	public static void main(String[] args) {
		float a, b;
		Scanner sc = new Scanner(System.in);
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

}
