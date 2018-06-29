package javafasttrack01;

import java.util.Scanner;

public class TTGiaiThuaSoChan {

	public static void main(String[] args) {
			int i, s, n, gt;
			s = 0;
			gt = 1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn nhập n: ");
			n = sc.nextInt();
			for(i = 1; i <= n;i++) {
				gt *= i;
				if(i%2==0) {				
				s += gt;
				}
				
			}
			System.out.println("Kết quả: Tổng từ 1! đến n! là : "+s);

	}

}
