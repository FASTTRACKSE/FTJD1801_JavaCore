package javafasttrack01;

public class pTBacNhat {

	public static void main(String[] args) {
		double a, b, x;
		a = 1;
		b = 2;
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm!!!");
			}
			else {
				System.out.println("Phương trình vô nghiệm!!!");
			}
		}
		else {
			x = -b/a;
			System.out.println("Phương trình có nghiệm x = "+x);
		}

	}

}
