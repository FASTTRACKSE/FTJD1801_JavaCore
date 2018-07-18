package unit1;

import java.util.Scanner;

public class tinhtong1n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int n,s=0;
		System.out.println("Nhập n");
		n=sc.nextInt();
		
		for (i=1;i<=n;i++)
		{
			s=s+i;
		}
		System.out.println("Tổng"+s);

	}

}
