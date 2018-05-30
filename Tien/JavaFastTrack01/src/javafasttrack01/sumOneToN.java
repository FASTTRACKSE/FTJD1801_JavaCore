package javafasttrack01;

import java.util.Scanner;

public class sumOneToN {

	public static void main(String[] args) {
		int i,n, s;
		s = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập n: ");
		n = sc.nextInt();
		for(i = 1; i<=n;i++) {
			s += i; 
		}
		System.out.println("Kết quả: Tổng từ 1 đến n là : "+s);
	}

}
