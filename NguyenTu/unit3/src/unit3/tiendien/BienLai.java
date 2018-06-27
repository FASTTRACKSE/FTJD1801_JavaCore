package unit3.tiendien;

import java.util.Scanner;

public class BienLai extends KhachHang {
	private double soCu, soMoi, soTien;

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	public double getSoCu() {
		return soCu;
	}

	public void setSoCu(double soCu) {
		this.soCu = soCu;
	}

	public double getSoMoi() {
		return soMoi;
	}

	public void setSoMoi(double soMoi) {
		this.soMoi = soMoi;
	}

	public BienLai() {
		super();
	}

	public BienLai(double soCu, double soMoi, double soTien) {
		super();
		this.soCu = soCu;
		this.soMoi = soMoi;
		this.soTien = soTien;
	}

	public double tinhTien() {
		soTien = (this.soMoi - this.soCu) * 750;
		return soTien;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);

		System.out.println("Mời nhập chỉ số cũ: ");
		this.soCu = Double.parseDouble(sc.nextLine());

		System.out.println("Mời nhập chỉ số mới: ");
		this.soMoi = Double.parseDouble(sc.nextLine());


	}
	public void xuat() {
		super.xuat();
		System.out.print(this.soCu + "--" + this.soMoi + "--" + this.soTien );
	}

}
