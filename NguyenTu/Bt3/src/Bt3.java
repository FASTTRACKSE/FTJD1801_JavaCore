import java.util.Scanner;
public class Bt3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n,i,s=0;
		System.out.println("Mời nhập n ");
		n = sc.nextInt();
		for(i=1;i<=n;i++) {
			s=s+i;
		}
		System.out.println("Tổng S là "+s);
	}

}
