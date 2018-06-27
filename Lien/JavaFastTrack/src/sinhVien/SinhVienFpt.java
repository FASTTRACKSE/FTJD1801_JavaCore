package sinhVien;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienFpt {
	private String hoTen;
	private String nganh;
	private double diem;
	private String maSV;
	private int tuoi;
	

	

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
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

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	
	public SinhVienFpt(String hoTen, String nganh, double diem, String maSV, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
		this.diem = diem;
		this.maSV = maSV;
		this.tuoi = tuoi;
	}


	

	public SinhVienFpt() {
		super();
	}

	abstract public double getDiem();

	public String getHocLuc() {
		if (getDiem() < 5) {
			return "Yếu";
		} else if (getDiem() <= 6.5) {
			return "Trung Bình";
		} else if (getDiem() <= 7.5) {
			return "Khá";
		} else if (getDiem() < 9) {
			return "Giỏi";
		} else
			return "Xuất sắc";
	}

	public void nhap(ArrayList<SinhVienFpt> list) {

		Scanner sc = new Scanner(System.in);
		for (;;) {

			System.out.println("Mã sinh viên: ");
			maSV = sc.nextLine();
			
			try {
				SinhVienException.checkMaSV(maSV, list);
				break;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println();
			}
		}
		for (;;) {

			System.out.println("Họ tên: ");
			hoTen = sc.nextLine();

			try {
				SinhVienException.chkHoTen(hoTen);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {

			System.out.println("Tuổi: ");
			tuoi = Integer.parseInt(sc.nextLine());

			try {
				SinhVienException.checkTuoi(tuoi);;
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		System.out.println("Ngành: ");
		nganh = sc.nextLine();
	}

	public void xuat() {
		System.out.println(this.hoTen + this.nganh + this.getDiem() + this.getHocLuc() + this.tuoi);
		this.diem = this.getDiem();
	}
}