package javafasttrack01;

import java.util.Scanner;

public class TinhTienDien {

	public static void main(String[] args) {
		int tienDien, soDien;
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập số điện: ");
		soDien = sc.nextInt();
		if(soDien < 50) {
			tienDien = soDien*1000;
		}
		else {
			tienDien = 50*1000 + (soDien - 50)*1200;
		}
		System.out.println("Số tiền điện là: "+tienDien);
	}

}
