package final_assignment;

import java.util.Scanner;

public class TaiKhoan {
	
	String tenTaiKhoan;
	String maThe;
	int maPIN;
	String trangThaiTaiKhoan;
	String loaiTienTe;
	double soDuTaiKhoan;	
	
	public TaiKhoan() {
		
	}

	public TaiKhoan(String maThe, int maPIN) {
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
		System.out.println("Nhap ho ten chu tai khoan: ");
		this.tenTaiKhoan = sc.nextLine();
		System.out.println("Nhap ma so the: ");
		this.maThe = sc.nextLine();	
		System.out.println("Nhap ma PIN: ");
		this.maPIN = Integer.parseInt(sc.nextLine());
		sc.close();
	}
	
	public void taoTheTu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma so the: ");
		this.maThe = sc.nextLine();	
		System.out.println("Nhap ma PIN: ");
		this.maPIN = Integer.parseInt(sc.nextLine());
		sc.close();
	}
	public void taoID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten chu tai khoan: ");
		this.tenTaiKhoan = sc.nextLine();
		System.out.println("Nhap trang thai tai khoan: ");
		this.trangThaiTaiKhoan = sc.nextLine();
		System.out.println("Nhap loai tien te: ");
		this.loaiTienTe = sc.nextLine();
		System.out.println("Nhap so du tai khoan: ");
		this.soDuTaiKhoan = Double.parseDouble(sc.nextLine());
		sc.close();
	}
}
