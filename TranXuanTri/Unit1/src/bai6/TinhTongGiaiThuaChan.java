package bai6;

import java.util.Scanner;

public class TinhTongGiaiThuaChan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,a = 1,s = 0 ;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap n ");
		n = scanner.nextInt();
		scanner.close();
		
		for (int i=1; i<=n; i++) {
			a *= i; // a = a*i
			if (i%2 == 0) {
			s += a; // s = s+a
			}
		}
		System.out.println(s);
	}

}
