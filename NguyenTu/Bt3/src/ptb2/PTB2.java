package ptb2;
import java.util.Scanner;
public class PTB2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,b,c;
		double delta=0,x1,x2;
		System.out.println("Mời nhập a,b,c");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		delta=b*b-4*a*c;
		
		if(delta<0) {
			
		
			System.out.println("Phương trình vô nghiệm");
		}
		else {
			if(delta==0) {
				System.out.println("Phương trình có 2 nghiệm kép " +(-b/(2*a)));
				
				}
			else {
				x1=(-b+ Math.sqrt(delta))/(2*a);
				x2=(-b+ Math.sqrt(delta))/(2*a);
				 System.out.printf("Phương trình có 2 nghiệm phân biệt x1=%.3f , x2= %.3f " ,x1,x2);
			}
		}
		}
	}

