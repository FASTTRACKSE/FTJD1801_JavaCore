package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienBiz extends SinhVienFpt {
	public double diemMarketing;
	public double diemSales;

	public SinhVienBiz() {
		super();
	}

	public SinhVienBiz(double diemMarketing, double diemSales) {
		super();
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	public void nhap(ArrayList<SinhVienFpt> arr) {
		super.nhap(arr);
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap diem marketing ");
		this.diemMarketing = Double.parseDouble(sc.nextLine());
		System.out.println("nhap diem sales ");
		this.diemSales = Double.parseDouble(sc.nextLine());
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (this.diemMarketing * 2 + this.diemSales) / 3;
	}
	public void xuat() {
		System.out.println(this.hoTen + " || " + this.nganh + " || Diem trung binh: " + this.getDiem() + " || Diem Marketing: " + this.diemMarketing + " || Diem Sales: " + this.diemSales + " || " + this.getHocLuc());
	}
}
