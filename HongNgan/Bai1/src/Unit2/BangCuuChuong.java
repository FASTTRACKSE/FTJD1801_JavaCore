package Unit2;

import java.util.Scanner;

public class BangCuuChuong {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int j;
		int i;
		for (i=1;i<=10;i++) {
			
			for(j=2;j<=9;j++){
			System.out.printf(" %d x %d = %d \t ",j,i,i*j);
			}
			System.out.println("");
		}
		
 
}
}