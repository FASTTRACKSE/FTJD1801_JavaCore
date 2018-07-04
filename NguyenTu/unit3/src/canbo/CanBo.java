package canbo;

import java.io.Serializable;
import java.util.Scanner;

public abstract class CanBo implements Serializable {
	private String hoTen;
	private double heSL;

	public CanBo() {
		super();
	}

	public CanBo(String hoTen, double heSL) {
		super();
		this.hoTen = hoTen;
		this.heSL = heSL;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSL() {
		return heSL;
	}

	public void setHeSL(double heSL) {
		this.heSL = heSL;
	}

	abstract public double tinhLuong();

	abstract public int getPhuCap();

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		for(;;) {
		System.out.println("Họ tên cán bộ: ");
		this.hoTen = sc.nextLine();
		try {
			CanBoEx.chkhoTen(hoTen);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
		}
		
		for(;;) {
		System.out.println("Hệ số lương: ");
		this.heSL = Double.parseDouble(sc.nextLine());
		try {
			CanBoEx.chkSoThuc(this.heSL);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
	}
	}

	public void xuat() {
		System.out.println("Họ tên: " + this.hoTen + "   |   Phụ cấp:  " + this.getPhuCap() + "  |  Hệ số lương:  "
				+ this.heSL + "   |   Tiền lương: " + this.tinhLuong());
	}
}
