package bai2;

import java.util.Scanner;

public class SinhVienBiz extends SinhVienFpt {
	public double diemMarketing;
	public double diemSales;
	
	public SinhVienBiz() {
		super();
	}
	public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap diem marketing ");
		this.diemMarketing = Double.parseDouble(sc.nextLine());
		System.out.println("nhap diem sales ");
		this.diemSales = Double.parseDouble(sc.nextLine());
	}
	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (this.diemMarketing*2 + this.diemSales)/3;
	}

}
