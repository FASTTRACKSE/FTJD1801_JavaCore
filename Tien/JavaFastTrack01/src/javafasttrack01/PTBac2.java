package javafasttrack01;

import java.util.Scanner;

public class PTBac2 {

	public static void main(String[] args) {
		double a, b, c, x1, x2, d;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào a: ");
		a = sc.nextDouble();
		System.out.println("Nhập vào b: ");
		b = sc.nextDouble();
		System.out.println("Nhập vào c: ");
		c = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phương trình có vô số nghiệm!");
				}
				else {
					System.out.println("Phương trình vô nghiệm!");
				}
			}
			else {
				System.out.println("Phương trình có nghiệm duy nhất là: "+(-c/b));
			}
		}
		else {
			d = b*b-4*a*c;
			if(d<0) {
				System.out.println("Phương trình vô nghiệm!");
			}
			else if(d==0){
				System.out.println("Phương trình có nghiệm kép là: "+(-b/(2*a)));
			}
			else {
				x1 = (-b+Math.sqrt(d))/(2*a);
				x2 = (-b-Math.sqrt(d))/(2*a);
				System.out.println("Phương trình có 2 nghiệm phân biệt là: "+x1+" và "+x2);
			}
		}
	}

}
