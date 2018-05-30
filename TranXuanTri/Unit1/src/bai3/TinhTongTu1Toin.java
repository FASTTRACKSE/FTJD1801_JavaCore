package bai3;

import java.util.Scanner;

public class TinhTongTu1Toin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int s=0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print ("Nhap n ");
		n = scanner.nextInt();
		scanner.close();
		for (int i=0;i<=n;i++) {
			s = s + i;
		}
		System.out.println("tong tu 1 toi " +n +" la " +s);
	}
}
