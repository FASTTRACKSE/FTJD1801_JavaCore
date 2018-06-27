package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienFpt {
	public String hoTen;
	public String nganh;
	public String maSinhVien;
	public SinhVienFpt() {
		super();
	}

	public SinhVienFpt(String hoTen, String nganh, String maSinhVien) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public double nhapDiem() {
		Scanner sc = new Scanner(System.in);
		double diem;
		for (;;) {
			try {
			diem = Double.parseDouble(sc.nextLine());
			SinhVienException.chkDiem(diem);
			return diem;
			}
			catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
	}
	public void nhap(ArrayList<SinhVienFpt> arr) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("nhap ho va ten sinh vien ");
			this.hoTen = sc.nextLine();
			try {
				SinhVienException.chkHoTen(hoTen);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		System.out.println("nhap nganh sinh vien ");
		this.nganh = sc.nextLine();
		for (;;) {
			System.out.println("nhap ma sinh vien");
			this.maSinhVien = sc.nextLine();
			try {
				SinhVienException.chkMaSinhVien(maSinhVien, arr);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
	}

	abstract public double getDiem();

	public String getHocLuc() {
		if (getDiem() < 5) {
			return "Yeu";
		} else if (getDiem() < 6.5) {
			return "Trung binh";
		} else if (getDiem() < 7.5) {
			return "Kha";
		} else if (getDiem() < 9) {
			return "Gioi";
		} else
			return "Xuat sac";
	}
public abstract void xuat();
	public void xuat1() {
		System.out.println(this.hoTen + "|| " +this.maSinhVien+ " || " + this.nganh + " || " + getDiem() + " || " + getHocLuc());
	}
}
