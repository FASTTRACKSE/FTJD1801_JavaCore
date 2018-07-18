package atm;

import java.io.Serializable;
import java.util.Scanner;

public class Users implements Serializable {
	String maThe;
	String tenTK;
	String trangThai;
	String loaiTienTe;
	double soDuTK;

	

	public String getMaThe() {
		return maThe;
	}

	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public double getSoDuTK() {
		return soDuTK;
	}

	public void setSoDuTK(double soDuTK) {
		this.soDuTK = soDuTK;
	}

	public Users(String maThe, String tenTK, String trangThai, String loaiTienTe, double soDuTK) {
		super();
		this.maThe = maThe;
		this.tenTK = tenTK;
		this.trangThai = trangThai;
		this.loaiTienTe = loaiTienTe;
		this.soDuTK = soDuTK;
	}

	public void nhapID() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Nhap ho ten chu tai khoan: ");
			this.tenTK = sc.nextLine();
			try {
				MyException.chkHoTen(tenTK);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
			System.out.println("Nhap ma so the: ");
			this.maThe = sc.nextLine();
			try {
				MyException.chkMaSoThe(maThe);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		System.out.println("Nhap trang thai tai khoan: ");
		this.trangThai = sc.nextLine();
		System.out.println("Nhap loai tien te: ");
		this.loaiTienTe = sc.nextLine();
		System.out.println("Nhap so du tai khoan: ");
		this.soDuTK = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		System.out.println(this.maThe + " | " + this.tenTK + " | " + this.soDuTK + " | " + this.trangThai + " | " + this.loaiTienTe);
	}

	public Users() {
		super();
	}

}
