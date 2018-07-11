package final_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
	String id;
	String tenTaiKhoan;
	String trangThaiTaiKhoan;
	String loaiTienTe;
	double soDuTaiKhoan;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getTrangThaiTaiKhoan() {
		return trangThaiTaiKhoan;
	}

	public void setTrangThaiTaiKhoan(String trangThaiTaiKhoan) {
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public double getSoDuTaiKhoan() {
		return soDuTaiKhoan;
	}

	public void setSoDuTaiKhoan(double soDuTaiKhoan) {
		this.soDuTaiKhoan = soDuTaiKhoan;
	}
	public void nhapID() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Nhap ho ten chu tai khoan: ");
			this.tenTaiKhoan = sc.nextLine();
			try {
				MyException.chkHoTen(tenTaiKhoan);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
		System.out.println("Nhap ma so the: ");
		this.id = sc.nextLine();
		try {
			MyException.chkMaSoThe(id);
			break;
		} catch (MyException e) {
			System.err.println(e);
			System.out.println();
		}
		}
		System.out.println("Nhap trang thai tai khoan: ");
		this.trangThaiTaiKhoan = sc.nextLine();
		System.out.println("Nhap loai tien te: ");
		this.loaiTienTe = sc.nextLine();
		System.out.println("Nhap so du tai khoan: ");
		this.soDuTaiKhoan = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		System.out.println("Chu tai khoan: " + getTenTaiKhoan() + "|| Trang thai tai khoan: " 
							+ getTrangThaiTaiKhoan() + "|| So du tai khoan: " + getSoDuTaiKhoan() + "|| Loai tien te: " + getLoaiTienTe());
	}
	

}
