package baitap2;

public class PTB1 {

	public static void main(String[] args) {
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

}
