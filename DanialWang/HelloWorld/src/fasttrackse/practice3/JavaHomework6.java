package fasttrackse.practice3;

import java.util.Scanner;

public class JavaHomework6 {

	public static void main(String[] args) {
	
		int n;
		
		Scanner Scanner = new Scanner (System.in);
		System.out.println("Input Value for n");
		n = Scanner.nextInt();
		
		int sum = 0;
		int factorialNumber = 1;
		for (int i = 1; i <= n; i++) {
			
			
			if(i%2 == 0) {
				sum = sum + i;
			}
			
					
	}

		System.out.println(sum);
}
}