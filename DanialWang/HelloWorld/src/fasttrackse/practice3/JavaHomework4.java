package fasttrackse.practice3;

import java.util.Scanner;

public class JavaHomework4 {

	public static void main(String[] args) {
		
		int a,b,c,x;
		
		double x1,x2,y;
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Given quadratic equation ax^2 + bx + c");
		
		System.out.println("Value of a ");
		a = scanner.nextInt();
		
		System.out.println("Value of b ");
		b = scanner.nextInt();
		
		System.out.println("Value of c ");
		c = scanner.nextInt();
		
		System.out.println("Given quadratic equation: " + a + "x^2 +" + b +" x + "+ c);
		
		y = b * b - 4 * a * c;
		
		if(y>0) {
			x1 = ( - b + Math.sqrt(y))/(2*a);
			x2 = ( b + Math.sqrt(y))/(2*a);
			System.out.printf("Answer for x1 is %.2f %n",x1);
			System.out.printf("Answer for x2 is %.2f",x2);
		}
		else if (y==0) {
		x1 = ( -b + Math.sqrt(y))/(2*a);
		System.out.println("Answer for x1 is " + x1);
	}
		else {
		System.out.println("no solution");
	}
	}
	
	}

