package baitap3;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		
		int n , sum , i;
		sum=0;
		 Scanner sc;
	            System.out.println("Nhập n = ");
	            sc = new Scanner(System.in);
	            n = sc.nextInt();
	         
	        for( i = 1; i <= n; i++) {
	            sum += i;
	        }
	         
	        System.out.println("Tổng từ 1 đến n  = " + sum);
	}
}
	
		

	


