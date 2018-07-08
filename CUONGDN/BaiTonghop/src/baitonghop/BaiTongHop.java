package baitonghop;
import java.util.Scanner;
public class BaiTongHop {

	public static void main(String[] args) {
		System.out.println("Chon 1 De Giai Phuong trinh bac 1");
		System.out.println("Chon 2 De Giai Phuong trinh bac 2");
		Scanner sc = new Scanner (System.in);
		int nhapso = sc.nextInt();
		if(nhapso == 1) {
			giaiPhuongTrinhBac1();
		}
		if(nhapso == 2) {
			giaiPhuongTrinhBac2();
		}
	}

   public static void giaiPhuongTrinhBac1() {
	   Scanner sc = new Scanner (System.in);
		 int a, b, x;
		  System.out.println("nhap a :");
		  a = sc.nextInt();
		  System.out.println("nhap b :");
		  b = sc.nextInt();
		 if(a==0 && b ==0)
		 {
		  System.out.println("phuong tring vo so nghiem");
		 }
		 else
			if(a==0 && b!=0 )
			{
				System.out.println("phuong trinh vo nghiem");
			}
		  
			else
			{
				x = ((-b)/a);
				
				System.out.println("phuong tring co nghiem " +x);
				
			}
   }

	public static void giaiPhuongTrinhBac2() {
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