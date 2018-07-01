package MT_1_OOP;

import java.util.Scanner;
public class QuanLyTienDien {
	public static void main(String[] args) {
		int sodien;
		int sotientra;
		Scanner sc = new Scanner(System.in);
		System.out.println(" Moi ban nhap vao so dien : ");
		sodien = Integer.parseInt(sc.nextLine());
		
		if(sodien<50) {
			sotientra = sodien*1000;
		}
		else {
			sotientra = sodien*1200;
		}
		System.out.println(" so tien phai tra la : "+sotientra);
	}

}
