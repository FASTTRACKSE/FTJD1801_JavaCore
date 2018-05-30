package thuchanh1;

import java.util.Scanner;

public class GiaiPTBac2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		double a,b,c,x1,x2,delta,x;
		System.out.println("Nhập a");
		a=sc.nextDouble();
		System.out.println("Nhập b");
		b=sc.nextDouble();
		System.out.println("Nhập c");
		c=sc.nextDouble();
		delta=b*b-4*a*c;
		if (delta<0)
		{
			System.out.println("PT vô nghiệm");
		}
		else {
			if (delta==0)
		{
			System.out.println("PT có nghiêm"+(-b/2*a));
			
		}
			else {
				x1=(-b -Math.sqrt(delta))/2*a;
				System.out.println("%.2f x1="+x1);
				x2=(-b +Math.sqrt(delta))/2*a;
				System.out.println("%.2f x2="+x2);
		}  
		}

	
}
}
