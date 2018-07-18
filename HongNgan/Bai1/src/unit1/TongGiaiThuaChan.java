package unit1;

import java.util.Scanner;

public class TongGiaiThuaChan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, s = 0, n, giaithua = 1;
		System.out.println("Nhập n");
		n = sc.nextInt();

		for (i = 1; i <= n; i++) {
			giaithua = giaithua * i;

			if (i % 2 == 0)
				s = s + giaithua;
		}

		System.out.println("Tổng là:" + s);

	}

}
