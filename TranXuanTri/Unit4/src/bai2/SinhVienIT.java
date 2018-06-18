package bai2;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt {
	public double diemJava;
	public double diemCss;
	public double diemHtml;
	public SinhVienIT(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
		super(hoTen, nganh);
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap diem java ");
		this.diemJava = Double.parseDouble(sc.nextLine());
		System.out.println("nhap diem css ");
		this.diemCss = Double.parseDouble(sc.nextLine());
		System.out.println("nhap diem html ");
		this.diemHtml = Double.parseDouble(sc.nextLine());
	}
	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (this.diemJava*2 + this.diemHtml + this.diemCss)/4;
	}
	
}
