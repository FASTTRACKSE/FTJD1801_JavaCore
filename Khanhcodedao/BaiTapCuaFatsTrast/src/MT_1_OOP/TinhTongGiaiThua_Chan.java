package MT_1_OOP;

import java.util.Scanner;

public class TinhTongGiaiThua_Chan {
public static void main(String[] args) {
		
		int a=1 , s=0 , n ;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n ");
		n = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=n; i++) {
			a *= i; 
			if(i%2==0) {
			s += a; 
			}
		}
		
		System.out.println(s);
	}

}
