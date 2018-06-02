package tiendien;
import java.util.Scanner;
public class tienDien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int soDien;
		System.out.println("Mời nhập số điện");
		soDien=sc.nextInt();
		if(soDien<50) {
			System.out.println("số điện tiêu thụ trong tháng là: " +soDien*1000);
		}
		else System.out.println("số điện tiêu thụ trong tháng là: " +soDien*1200);
		
		
	}

}
