import java.util.Scanner;
public class bt2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float a,b;
		double x;
		System.out.println("Nhập a: ");
		a = sc.nextInt();
		System.out.println("Nhập b: ");
		b = sc.nextInt();
		x=-b/a;
		if(a==0&b==0)
			System.out.println("Phương trình có vô số nghiệm");
		else if(a==0)
			System.out.println("Phương trình có vô nghiệm");
			else 
				System.out.println("Phương trình có nghiệm x= "+x);
	}

}
