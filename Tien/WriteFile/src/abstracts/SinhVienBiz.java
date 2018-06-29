package abstracts;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienBiz extends SinhVienFpt {
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

	public void nhap(ArrayList<SinhVienFpt> list) {
		super.nhap(list);
		SinhVienBiz svb = new SinhVienBiz();
		Scanner sc = new Scanner(System.in);
		System.out.println("Điểm Marketing: ");
		diemMarketing = svb.nhapDiem();
		System.out.println("Điểm Sales: ");
		diemSales = svb.nhapDiem();
	}

	public void xuat() {
		super.xuat();
	}

	public void xuatBiz() {
		super.xuat();
		System.out.println("Điểm Marketing: " + diemMarketing + "  |  Điểm Sales: " + diemSales);
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (2 * diemMarketing + diemSales) / 3;
	}

}
