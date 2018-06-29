package canbo;

import java.util.Scanner;

public class NhanVienHC extends CanBo {

	private String phongBan, chucVu;
	private int soNgayCong;

	public NhanVienHC() {
		super();
	}

	public NhanVienHC(String phongBan, String chucVu, int soNgayCong) {
		super();
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Phòng ban: ");
		this.phongBan = sc.nextLine();
		for(;;) {
		System.out.println("Chức vụ: ");
		this.chucVu = sc.nextLine();
		try {
			CanBoEx.chkChucVu(chucVu);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
		}
		for(;;) {
		System.out.println("Số ngày công: ");
		this.soNgayCong = Integer.parseInt(sc.nextLine());
		try {
			CanBoEx.chkSoNguyen(soNgayCong);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
		}
	}

	public void xuat() {
		super.xuat();
		System.out.println("  |  Phòng ban: " + this.phongBan + "  |  Chức vụ:" + this.chucVu + "  |  Số ngày công:"
				+ this.soNgayCong);
	}

	public double tinhLuong() {
		return this.getHeSL() * 730 + this.getPhuCap() + this.soNgayCong * 30;
	}

	public int getPhuCap() {
		if (this.getChucVu().equals("Trưởng phòng")) {
			return 2000;
		} else if (this.getChucVu().equals("Phó phòng")) {
			return 1000;
		} else if (this.getChucVu().equals("Nhân viên")) {
			return 500;
		} else
			return 0;
	}
}
