package BT2;
import java.util.Scanner; 
public class BT2 
    {

  public static void main(String[] args)
    {
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

}
