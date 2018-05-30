package baitap4;

public class ptb2 {

	public static void main(String[] args) {
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
}