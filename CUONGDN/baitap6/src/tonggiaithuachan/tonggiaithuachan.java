package tonggiaithuachan;
import java.util.Scanner;
public class tonggiaithuachan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, n, tong, s ;
		System.out.println("Nhap n");
		n = sc.nextInt();
		tong = 0 ;
		s = 1;
		for (i= 1; i <=n; i++) {
			s = s * i ;
		
			if( i%2==0)
			{
				tong = tong + s ;
			}
		}
		  System.out.println(" tong giai thua la :" +tong);
		

	}

}
