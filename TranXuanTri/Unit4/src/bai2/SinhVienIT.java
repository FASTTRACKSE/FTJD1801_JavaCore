package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt {
	public double diemJava;
	public double diemCss;
	public double diemHtml;



	public SinhVienIT(double diemJava, double diemCss, double diemHtml) {
		super();
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}

	public SinhVienIT() {
		super();
	}

	public void nhap(ArrayList<SinhVienFpt> arr) {
		super.nhap(arr);
		System.out.println("nhap diem java ");
		this.diemJava = super.nhapDiem();
		System.out.println("nhap diem css ");
		this.diemCss = super.nhapDiem();
		System.out.println("nhap diem html ");
		this.diemHtml = super.nhapDiem();
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (this.diemJava * 2 + this.diemHtml + this.diemCss) / 4;
	}

	public void xuat() {
		System.out.println(this.hoTen + " || " + this.nganh + " || Diem trung binh " + getDiem() + " || Diem HTML " + this.diemHtml + " || Diem Java " + this.diemJava + " || Diem css" + this.diemCss + " || "  + getHocLuc());
	}
}
