package fasttrackse.practice3;

import java.util.Scanner;

public class javahomework2 {

	public static void main(String[] args) {
		
		double x;
		double a = 1;
		double b = 0;
		double y;
		
System.out.println("Input value of x for ax + b");		
		
Scanner scanner = new Scanner(System.in);
		
System.out.println("Input for x");
x = scanner.nextInt();
y = a * x + b;
System.out.println(y);
if(y<0) {
	System.out.println("Error, total value less than 0");
	}
if(y>2) {
	System.out.println("Error, total value greater than 2");
}





}
}