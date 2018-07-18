package unit1;

import java.util.Scanner;

public class giaiptbacnhat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("nhap a");
		a=sc.nextInt();
		int b;
		System.out.println("nhap b");
		b=sc.nextInt();
		{
		if (a==0) 
		if(b==0) 
			{
			  System.out.println("pt vo so nghiem");
			}
		
		else
			{
			  System.out.println("pt vo nghiem");
			}
		else
			{	
			System.out.println("nghiem cua pt la "+(-b/a));
			}

		}
	}
}