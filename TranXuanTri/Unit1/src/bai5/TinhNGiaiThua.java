package bai5;

import java.util.Scanner;

public class TinhNGiaiThua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,a = 1,s = 0 ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap n ");
		n = scanner.nextInt();
		scanner.close();
		for (int i=1; i<=n; i++) {
			a *= i;
			s += a;
		}
		System.out.println(s);
	}

}
