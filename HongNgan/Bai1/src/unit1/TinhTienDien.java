package unit1;

import java.util.Scanner;

public class TinhTienDien {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int soDien;
		System.out.println("Nhâp so dien");
		soDien=sc.nextInt();
		
		if (soDien <= 50) {
			System.out.println("Số điên"+(soDien*1000));
		}
		else
		{
			System.out.println("Số điên"+(50*1000+(soDien-50)*1200));
		}
			
			
		
	}

}
