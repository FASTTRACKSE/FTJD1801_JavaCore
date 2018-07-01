package bai8;

import java.util.Scanner;

public class TinhTienDien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int soDien,tien ;
		Scanner sc = new Scanner(System.in);
		System.out.print ("nhap so dien da su dung ");
		soDien = sc.nextInt();
		if (soDien<50) {
			tien = soDien*1000;
			System.out.println ("So tien dien la " +tien);
		}
		else {
			tien = 50*1000 + (soDien - 50)*1200;
			System.out.println ("So tien dien la " +tien);
		}
	}
}
