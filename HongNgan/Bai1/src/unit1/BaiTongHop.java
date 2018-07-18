package unit1;

import java.util.Scanner;

public class BaiTongHop {

	public static void main(String[] args) {
		thucDon();

	}
	public static void thucDon() {
		System.out.println("Menu");
		System.out.println("1. Phương trình bậc nhất");
		System.out.println("2. Phương trình bậc hai");
		System.out.println("3.Exit");
		System.out.println("---------------");
		System.out.println("Choice:");
		Scanner sc = new Scanner(System.in);
		int choice;
		choice =sc.nextInt();
		if(choice ==1)	{
			phuongTrinhBacNhat();thucDon();
		}
		else if (choice ==2) {
			phuongTrinhBacHai();
		}
		else if	 (choice==3) {
			System.exit(0);
		}
		
		
		
	}
	public static void phuongTrinhBacNhat() {
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
		
	
	public static void phuongTrinhBacHai() {
		Scanner sc=new Scanner (System.in);
		double a,b,c,delta, x1,x2,x;
		System.out.println("Nhập a");
		a=sc.nextDouble();
		System.out.println("Nhập b");
		b=sc.nextDouble();
		System.out.println("Nhập c");
		c=sc.nextDouble();
		delta=b*b-4*a*c;
		if (delta<0)
		{
			System.out.println("PT vô nghiệm :");
		}
		else {
			if (delta==0)
		{
			System.out.println("PT có nghiêm là :"+(-b/2*a));
			
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


