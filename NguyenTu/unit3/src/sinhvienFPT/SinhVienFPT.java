package sinhvienFPT;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienFPT {
	private String maSv;
	private String hoTen;
	private String nganh;
	private double diem;

	public SinhVienFPT() {
		super();
	}

	public SinhVienFPT(String maSv, String hoTen, String nganh, double diem) {
		super();
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.nganh = nganh;
		this.diem = diem;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
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

	public void setDiem(double diem) {
		this.diem = diem;
	}

	abstract public double getDiem();

	public String getHocLuc() {
		if (getDiem() < 5) {
			return "Yếu";
		} else if (getDiem() <= 6) {
			return "Trung Bình";
		} else if (getDiem() <= 7.5) {
			return "Khá";
		} else if (getDiem() < 9) {
			return "Giỏi";
		} else
			return "Xuất Sắc";
	}

	public void nhap() {
		ArrayList<SinhVienFPT> list = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập mã sinh viên: ");
		this.maSv = sc.nextLine();
		
		System.out.println("Nhập họ tên: ");
		this.hoTen = sc.nextLine();
		
		System.out.println("Nhập ngành: ");
		this.nganh = sc.nextLine();
		
		System.out.println("Nhập điểm: ");
		this.diem = Double.parseDouble(sc.nextLine());
	}
	public void xuat() {
		this.diem = getDiem();
		System.out.println("Mã sinh viên: "+this.maSv+"  |  Họ tên: " + this.hoTen + "  |  Ngành: " + nganh + "  |  Điểm trung bình: " + this.diem
				+ "  |  Học lực: " + this.getHocLuc());
	}
}
