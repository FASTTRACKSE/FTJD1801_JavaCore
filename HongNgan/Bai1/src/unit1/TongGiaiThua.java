package unit1;

import java.util.Scanner;

public class TongGiaiThua {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int i,s=0,n,giaithua=1;
		n=sc.nextInt();
		System.out.println("Nhập n");
		for (i=1;i<=n;i++)
		{
			giaithua=giaithua*i; //giaithua*=i;
			s=s+giaithua;
		}
			
		System.out.println("Tổng là:"+s);
	}

}
