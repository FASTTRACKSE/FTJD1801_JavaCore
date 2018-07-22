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
		Scanner sc = new Scanner(System.in);
		for (;;) {
			try {
		System.out.println("nhap diem java ");
		this.diemJava = Double.parseDouble(sc.nextLine());
		SinhVienException.chkDiem(diemJava);
		break;
			}
			catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
			try {
		System.out.println("nhap diem css ");
		this.diemCss = Double.parseDouble(sc.nextLine());
		SinhVienException.chkDiem(diemCss);
		break;
			}
			catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
			try {
		System.out.println("nhap diem html ");
		this.diemHtml = Double.parseDouble(sc.nextLine());
		SinhVienException.chkDiem(diemHtml);
		break;
			}
			catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
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
