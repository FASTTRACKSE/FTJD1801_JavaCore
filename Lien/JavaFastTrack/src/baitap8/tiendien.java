package baitap8;

import java.util.Scanner;

public class tiendien {

	public static void main(String[] args) {
		int tDien, sDien;
		Scanner s = new Scanner(System.in);
		System.out.println("Vui lòng nhập số điện:");
		sDien = s.nextInt();
		if(sDien < 50) {
			tDien = sDien * 1000;
			
			
		}
		else{
			tDien = 50*1000 + (sDien - 50)*1200;
			
		}
		System.out.println("Kết quả: "+tDien);

	}

}
