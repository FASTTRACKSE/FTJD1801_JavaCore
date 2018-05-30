package fasttrackse.practice3;

import java.util.Scanner;

public class JavaHomework5 {

	public static void main(String[] args) {
		
		int n;
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Input Value for n");
		n = scanner.nextInt();
		
		int sum = 0;
		int factorialNumber = 1;
		for (int i = 1; i <= n; i++) {
		factorialNumber *= i;
		sum = sum + factorialNumber;
		
		}
		System.out.println(sum);
	}
	
}
