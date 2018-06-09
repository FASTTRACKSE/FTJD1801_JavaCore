package MT_1_OOP;

import java.util.Scanner;

public class TT_sanpham {

	public String tensp;
	public double gia;

	Scanner sc = new Scanner(System.in);
	public void nhap() {
		System.out.println(" nhap ten san pham : ");
		tensp = sc.nextLine();
		System.out.println(" nhap gia san pham : ");
		gia = Double.parseDouble(sc.nextLine());
	}

	public void hienThi() {
		System.out.println("ten san pham : "+tensp);
		System.out.println(" gia san pham : "+gia);
		
	}
	public static void main(String[] args) {
		
		TT_sanpham sp1 = new TT_sanpham();
		sp1.nhap();
		TT_sanpham sp2 = new TT_sanpham();
		sp2.nhap();
		
		sp1.hienThi();
		sp2.hienThi();
	}
}
