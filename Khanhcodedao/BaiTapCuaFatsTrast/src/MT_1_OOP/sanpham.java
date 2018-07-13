package MT_1_OOP;

import java.util.Scanner;

public class sanpham {
	public String tensanpham;
	public double dongia;
	public double giamgia;
	
	Scanner sc = new Scanner(System.in);
	public void nhap() {
		System.out.print(" nhap vao ten san pham : ");
		tensanpham = sc.nextLine();
		System.out.print(" nhap vao don gia : ");
		dongia = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap vao giam gia ");
		giamgia = Double.parseDouble(sc.nextLine());
		
	}
	public double getThueNhapKhau() {
		double thue = (dongia/100)*10;
		return thue;
	}
	public void hienThi() {
		System.out.println(" ten san pham : "+tensanpham);
		System.out.println(" don gia : "+dongia);
		System.out.println(" giam gia : "+giamgia);
	}
	public static void main(String[] args) {
		sanpham sp = new sanpham();
		sp.nhap();
		sp.hienThi();
		double th = sp.getThueNhapKhau();
		System.out.println(" gia thue la : "+th);
	}
	

}
