package giaiphuongtrinhbac2;
import java.util.Scanner;
public class giaiphuongtrinhbac2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, x, c ;
		double  x1, x2, delta ;
	    System.out.println("nhap a");
		a = sc.nextInt();
		System.out.println("nhap b");
		b= sc.nextInt();
		System.out.println("nhap c");
		c= sc.nextInt();
		delta = b*b - 4*a*c;
		if(delta<0)
		{
			System.out.println("phuong trinh vo nghiem");
		}
		else
			if(delta==0)
			{
				x=-(b/2*a);
			    System.out.println("phuong trinh co nghiem la :" +x);
			}
			else
			{
				x1= (-b + Math.sqrt(delta))/2*a;
				x2= (-b+  Math.sqrt(delta))/2*a;
				System.out.printf("phuong trinh co nghiem : %.2f %n",x1);
				System.out.printf("phuong trinh co nghiem : %.2f",x2);
	
				
			}
	}
	

}
