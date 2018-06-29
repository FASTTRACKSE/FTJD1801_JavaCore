package unit_2;

import java.util.Scanner;
public class GiaiPT_Bat2 {   // pt Ax2 + Bx +c = 0
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
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
}
