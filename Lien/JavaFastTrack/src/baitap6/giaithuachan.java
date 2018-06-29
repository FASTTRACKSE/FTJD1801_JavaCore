package baitap6;

import java.util.Scanner;

public class giaithuachan {

	public static void main(String[] args) {
		int a ,s = 0 , i, n, gt = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số n: ");
		n = sc.nextInt();
		for (i = 1; i<=n ; i++) {
			gt = gt * i;
			if(i%2 == 0) {
				s=s+gt;
			}
			
		}
		System.out.println("Kết quả: "+s);

	}

}
