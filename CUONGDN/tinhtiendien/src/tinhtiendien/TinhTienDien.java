package tinhtiendien;
import java.util.Scanner;
public class TinhTienDien {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in)	;
		int sodien, sotien ;
		System.out.println("Nhap so dien");
		sodien = sc.nextInt();
		if(sodien <= 50) {
			sotien = sodien * 1000;
			System.out.println("So tien phai tra la :" +sotien);
		}
		else {
			sotien = 50 *1000 + (sodien - 50)*1200 ;
		System.out.println("So tien phai tra la :" +sotien);
		}
	}

}
