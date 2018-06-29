package sinhvienFPT;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienBiz extends SinhVienFPT {
	private double diemMarketing;
	private double diemSales;
	public SinhVienBiz() {
		super();
	}
	public SinhVienBiz(double diemMarketing, double diemSales) {
		super();
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	public double getDiemMarketing() {
		return diemMarketing;
	}
	public void setDiemMarketing(double diemMarketing) {
		this.diemMarketing = diemMarketing;
	}
	public double getDiemSales() {
		return diemSales;
	}
	public void setDiemSales(double diemSales) {
		this.diemSales = diemSales;
	}
	public void nhap(ArrayList<SinhVienFPT>list) {
		super.nhap(list);
		Scanner sc = new Scanner(System.in);
		System.out.println("Điểm marketing: ");
		this.diemMarketing = Double.parseDouble(sc.nextLine());
		System.out.println("Điểm sales: ");
		this.diemSales = Double.parseDouble(sc.nextLine());
	}
	public void xuat() {
		super.xuat();
	}
	public void xuat3() {
		super.xuat();
		System.out.println("Điểm marketing: " +this.diemMarketing+ "    |   Điểm sales: " +this.diemSales);
	}
	public double getDiem() {
		return (2*this.diemMarketing+this.diemSales)/3;
	}
}
