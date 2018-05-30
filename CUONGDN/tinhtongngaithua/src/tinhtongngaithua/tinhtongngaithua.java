package tinhtongngaithua;
import java.util.Scanner; 
public class tinhtongngaithua {

	public static void main(String[] args) {
		int i, n, tong, s ;
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap n :");
	n = sc.nextInt();
	tong = 0;
	s = 1; 
	for (i=1; i<=n; i++)
	{
	 s = s *i ;
	 tong = tong + s; 
	 
	 }
	System.out.println("Tong giai thua la:" +tong);
}
}
