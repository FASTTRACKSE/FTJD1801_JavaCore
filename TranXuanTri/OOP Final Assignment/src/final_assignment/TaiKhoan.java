package final_assignment;

import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class TaiKhoan implements Serializable {
	
	String tenTaiKhoan;
	String maThe;
	String maPIN;
	String trangThaiTaiKhoan;
	String loaiTienTe;
	double soDuTaiKhoan;	
	
	public TaiKhoan() {
		
	}

	public TaiKhoan(String maThe, String maPIN) {
		this.maThe = maThe;
		this.maPIN = maPIN;
	}

	public TaiKhoan(String tenTaiKhoan, String loaiTienTe, double soDuTaiKhoan, String maThe, String trangThaiTaiKhoan) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.loaiTienTe = loaiTienTe;
		this.soDuTaiKhoan = soDuTaiKhoan;
		this.maThe = maThe;
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
	}
	
	public void nhap() {
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
		taoTheTu();

	}
	public void xuat() {
		System.out.println("Ho ten chu tai khoan: " + this.tenTaiKhoan );
		System.out.println("Ma the tai khoan: " + this.maThe );
		System.out.println("So du tai khoan: " + this.soDuTaiKhoan );
		
	}
	public void taoTheTu() {
		Scanner sc = new Scanner(System.in);
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
		for (;;) {
		System.out.println("Nhap ma PIN: ");
		this.maPIN = sc.nextLine();
		try {
			MyException.chkMaPIN(maPIN);
			break;
		} catch (MyException e) {
			System.err.println(e);
			System.out.println();
		}
		}
	}
	public void taoID() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
		System.out.println("Nhap ho ten chu tai khoan: ");
		this.tenTaiKhoan = sc.nextLine();
		try {
			MyException.chkHoTen(tenTaiKhoan);
			break;
		}catch (MyException e) {
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
}
