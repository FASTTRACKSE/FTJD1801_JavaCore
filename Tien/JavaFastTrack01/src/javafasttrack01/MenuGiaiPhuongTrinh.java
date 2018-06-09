package javafasttrack01;

import java.util.Scanner;

public class MenuGiaiPhuongTrinh {
	public static void phuongTrinhBacNhat() {
		double a, b, x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào a: ");
		a = sc.nextDouble();
		System.out.println("Nhập vào b: ");
		b = sc.nextDouble();
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm!!!");
			}
			else {
				System.out.println("Phương trình vô nghiệm!!!");
			}
		}
		else {
			x = -b/a;
			System.out.println("Phương trình có nghiệm x = "+x);
		}
	}
	public static void phuongTrinhBacHai() {		
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mucChon;
		Scanner input = new Scanner(System.in);
		System.out.println("Giải Phương Trình");
		System.out.println("---------------------------------------");
		System.out.println("1. Giải phương trình bậc nhất");
		System.out.println("2. Giải phương trình bậc hai");
		System.out.println("3. Kết thúc");
		System.out.println("---------------------------------------");
		System.out.print("Mời chọn một: ");
		mucChon = input.nextInt();
		switch(mucChon) {
		case 1: phuongTrinhBacNhat(); break;
		case 2: phuongTrinhBacHai(); break;
		case 3: break;
		default: System.out.println("Mục chọn không có trong menu!!!"); break;
		}
	}	
}
