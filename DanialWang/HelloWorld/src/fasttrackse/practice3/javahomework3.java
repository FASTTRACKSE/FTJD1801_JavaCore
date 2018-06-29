package fasttrackse.practice3;

import java.util.Scanner;

public class javahomework3 {

	public static void main(String[] args) {
	
		
		int n;
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Input value for n");
		n = scanner.nextInt();
		
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum = sum +i; //i++ means the value of i increases by 1, i <= n
		}
		System.out.println("Sum of value is " + sum);
	}

}
