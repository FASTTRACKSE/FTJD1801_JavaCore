package sinhvienFPT;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienIT extends SinhVienFPT {
	private double diemJava;
	private double diemHtml;
	private double diemCss;
	public SinhVienIT() {
		super();
	}
	public SinhVienIT(double diemJava, double diemHtml, double diemCss) {
		super();
		this.diemJava = diemJava;
		this.diemHtml = diemHtml;
		this.diemCss = diemCss;
	}
	public double getDiemJava() {
		return diemJava;
	}
	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}
	public double getDiemHtml() {
		return diemHtml;
	}
	public void setDiemHtml(double diemHtml) {
		this.diemHtml = diemHtml;
	}
	public double getDiemCss() {
		return diemCss;
	}
	public void setDiemCss(double diemCss) {
		this.diemCss = diemCss;
	}
	public void nhap(ArrayList<SinhVienFPT>list) {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Điểm Java: ");
		this.diemJava = Double.parseDouble(sc.nextLine());
		System.out.println("Điểm Html: ");
		this.diemHtml = Double.parseDouble(sc.nextLine());
		System.out.println("Điểm CSS: ");
		this.diemCss = Double.parseDouble(sc.nextLine());
	}
	public void xuat() {
		super.xuat();
	}
	public void xuat2() {
		super.xuat();
		System.out.println("Điểm Java: "+this.diemJava+"  |  Điểm Html: "+this.diemHtml+"  |  Điểm CSS: "+this.diemCss);
	}
	public double getDiem() {
		return (2*this.diemJava+this.diemHtml+this.diemCss)/4;
	}
}
