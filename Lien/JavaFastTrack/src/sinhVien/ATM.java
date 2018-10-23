package sinhVien;

import java.util.Scanner;

import baitapStudent.QuanLiSinhVien;

public class ATM {
	public String maTK;
	public String tenTK;
	public int soDu;
	public String loaiTien;
	public String trangThai;

	public ATM() {
		super();
	}

	public ATM(String maTK, String tenTK, int soDu, String loaiTien, String trangThai) {
		super();
		this.maTK = maTK;
		this.tenTK = tenTK;
		this.soDu = soDu;
		this.loaiTien = loaiTien;
		this.trangThai = trangThai;
	}
	

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public int getSoDu() {
		return soDu;
	}

	public void setSoDu(int soDu) {
		this.soDu = soDu;
	}

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public void user() {
		Scanner sc= new Scanner(System.in);
		
			System.out.println("Vui lòng nhập mã tài khoản:");
			maTK = sc.nextLine();
			System.out.println("Vui lòng nhập tên tài khoản: ");
			tenTK = sc.nextLine();
			System.out.println("Vui lòng nhập số dư tài khoản: ");
			soDu = Integer.parseInt(sc.nextLine()) ;
			System.out.println("Vui lòng nhập loại tiền: ");
			loaiTien = sc.nextLine();
			System.out.println("trạng thái: ");
			trangThai = sc.nextLine();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
