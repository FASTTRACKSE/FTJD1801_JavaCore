package MT_1_OOP;

import java.util.Scanner;
public class TinhGiaiThua {
	public static void main(String[] args) {
		
		int n,a = 1,s = 0 ;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n ");
		n = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=n; i++) {
			a *= i; // a = a*i
			s += a; // s = s+a
		}
		
		System.out.println(s);
	}
}
