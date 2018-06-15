package bai1;

import java.util.Scanner;

public class KhachHang {
	public String hoTen;
	public String soNha;
	public String maSoCongTo;
	
	public KhachHang() {
		super();
	}
	public KhachHang(String hoTen, String soNha, String maSoCongTo) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ho va ten khach hang ");
		this.hoTen = sc.nextLine();
		System.out.println("nhap so nha khach hang ");
		this.soNha = sc.nextLine();
		System.out.println("nhap ma so cong to");
		this.maSoCongTo = sc.nextLine();
	}
	public void xuat() {
		System.out.print(this.hoTen + " | " + this.soNha + " | " + this.maSoCongTo);
	}
}
