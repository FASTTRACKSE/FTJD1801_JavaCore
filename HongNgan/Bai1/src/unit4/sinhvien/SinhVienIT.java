package unit4.sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienIT extends SinhVienFPT {
	public double diemJava;
	public double diemCss;
	public double diemHtml;

	public SinhVienIT() {
		super();
	}

	public SinhVienIT(String hoTen, double diemJava, double diemCss, double diemHtml) {
		super();
		this.diemJava = diemJava;
		this.diemCss = diemCss;
		this.diemHtml = diemHtml;
	}

	public void nhap(ArrayList<SinhVienFPT> list) {
		super.nhap(list);
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap diem Java: ");
		this.diemJava = Double.parseDouble(sc.nextLine());

		System.out.println("Nhap diem Css: ");
		this.diemCss = Double.parseDouble(sc.nextLine());

		System.out.println("Nhap diem Html: ");
		this.diemHtml = Double.parseDouble(sc.nextLine());
	}

	@Override
	public double getDiem() {
		return (2 * diemJava + diemHtml + diemCss) / 4;
	}
}