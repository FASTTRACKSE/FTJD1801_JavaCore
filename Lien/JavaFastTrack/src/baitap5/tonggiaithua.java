package baitap5;
import java.util.Scanner;

public class tonggiaithua {

	public static void main(String[] args) {
		int a ,s = 0 , i, n, gt = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số n: ");
		n = sc.nextInt();
		for (i = 1; i<=n ; i++) {
			gt *=i;
			System.out.println("Kết quả: "+gt);
		}

	}

}
