package baitap9;

import java.util.Scanner;

public class TongHop {

	
	public static void ptb1(){
	
			double a, b, x;
			a=-2;
			b=7;		
			if(a==0) {
				if(b==0) {
					System.out.println("phương trình vô số nghiệm!");
				}
				else {
					System.out.println("phương trình vô nghiệm!");
				}
				
			}
			else {
				x = -b/a;
				System.out.println("phương trình có nghiệm là x = "+x);
			}
	}

		
		public static void ptb2() {
			double a , b , c , x;
			a = 2;
			b = 6;
			c = 3;
			if (a==0) {
				if (b==0) {
					if (c==0) {
						System.out.println("phương trình vô số nghiệm!");				
					}
				
					else {
					System.out.println("Phương trình vô nghiệm!");
					
					}
				}
				else {
					System.out.println("Phương trình có một nghiệm:" +"x="+(-c/b));
							
				}
			}
			else {
			x=b*b-4*a*c;
			double x1;
			double x2;
			if(x>0) {
				 x1 = ((-b + Math.sqrt(x)) / (2*a));
				 x2 = ((-b - Math.sqrt(x)) / (2*a));
				 System.out.println("Phương trình có hai nghiệm là: x1 = "+ x1 +" và x2 = "+x2);


			}
			else if(x==0) {
				System.out.println("Phương trình có nghiệm kép là: "+(-b/2*a));
			}
			else {
				if(x<0) {
					System.out.println("Phương trình vô nghiệm!");
				}
			}

		}
	}
		public static void main(String[] args) {
		
			int mC;
			System.out.println("----------");
			System.out.println("Menu");
			System.out.println("1. PTB1");
			System.out.println("2. PTB2");
			System.out.println("3.Exit");
			System.out.println("----------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn chọn: ");
			mC = sc.nextInt();
			if (mC == 1 ) {
				ptb1();
			}
			
			if (mC == 2) {
				ptb2();
				
			}
			if (mC == 3) {
				System.out.println("Exit program");
				
				
			}

	}

	}
		

