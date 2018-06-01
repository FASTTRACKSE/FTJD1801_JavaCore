package baitonghop;
import java.util.Scanner;
public class BaiTongHop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
			System.out.println("----------");
			System.out.println("Menu");
			System.out.println("1.Phương trình bậc nhất ");
			System.out.println("2.Phương trình bậc 2 ");
			System.out.println("3.Exit");
			System.out.println("----------");
			System.out.println("Break: ");
			Scanner sc = new Scanner(System.in);
			int Break=sc.nextInt();
			switch(Break) {
				case 1:ptb1();menu(); break;
				case 2:ptb2();menu();break;
				default:System.out.println("Kết thúc");
			}
	}
	public static void ptb1() {
		float a,b;
		double x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextInt();
		System.out.println("Nhập b: ");
		b = sc.nextInt();
		x=-b/a;
		if(a==0&b==0)
			System.out.println("Phương trình có vô số nghiệm");
		else if(a==0)
			System.out.println("Phương trình vô nghiệm");
			else 
				System.out.println("Phương trình có nghiệm x= "+x);
	}
	public static void ptb2() {
		int a,b,c;
		double delta=0,x1,x2;
		Scanner sc = new Scanner(System.in);
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
