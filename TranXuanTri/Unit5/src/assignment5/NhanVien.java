package assignment5;

import java.util.Scanner;

public class NhanVien extends CanBo {
	public String phongBan;
	public int soNgayCong;
	public String chucVu;

	public NhanVien() {
		super();
	}

	public NhanVien(String phongBan, int soNgayCong, String chucVu) {
		super();
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("nhap phong ban lam viec: ");
		this.phongBan = sc.nextLine();
		for (;;) {
			System.out.print("nhap chuc vu:");
			this.chucVu = sc.nextLine();
			try {
				CanBoException.chkChucVu(chucVu);
				break;
			} catch (CanBoException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
		System.out.print("nhap so ngay lam viec: ");
		this.soNgayCong = Integer.parseInt(sc.nextLine());
		try {
			CanBoException.chkSo(soNgayCong);
			break;
		} catch (CanBoException e) {
			System.err.println(e);
			System.out.println();
		}
		}
	}

	public void xuat() {
		super.xuat();
		System.out.println(this.phuCap + " || Phong ban: " + this.phongBan + " || Chuc vu: " + this.chucVu
				+ " || So ngay lam viec: " + this.soNgayCong);
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub

		return this.heSoLuong * 730 + this.phuCap + this.soNgayCong * 30;
	}

	@Override
	public double getPhuCap() {
		// TODO Auto-generated method stub
		if (this.chucVu.equals("truong phong")) {
			return 2000;
		} else if (this.chucVu.equals("pho phong")) {
			return 1000;
		} else if (this.chucVu.equals("nhan vien")) {
			return 500;
		}
		return 0;
	}

}
