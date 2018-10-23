package abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienFpt implements Serializable{
	private String maSV;
	private String hoTen;
	private String nganh;
	private double diem;
	private int tuoi;

	public SinhVienFpt() {
		super();
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public SinhVienFpt(String maSV, String hoTen, String nganh, double diem, int tuoi) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.nganh = nganh;
		this.diem = diem;
		this.tuoi = tuoi;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
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
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
			System.out.println("Họ tên: ");
			hoTen = sc.nextLine();
			try {
				SinhVienException.checkHoTen(hoTen);
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
				SinhVienException.checkTuoi(tuoi);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		System.out.println("Ngành: ");
		nganh = sc.nextLine();
	}

	public double nhapDiem() {
		double diem;
		Scanner sc = new Scanner(System.in);
		for (;;) {
			diem = Double.parseDouble(sc.nextLine());
			try {
				SinhVienException.checkDiem(diem);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println("Mời nhập lại: ");
			}
		}
		return diem;
	}
	
	
	
	@Override
	public String toString() {
		return "SinhVienFpt [maSV=" + maSV + ", hoTen=" + hoTen + ", nganh=" + nganh + ", diem=" + diem + ", tuoi="
				+ tuoi;
	}

	public void xuat() {
		this.diem = this.getDiem();
		System.out.println("Mã sinh viên: " + this.maSV + "  |  Họ tên: " + this.hoTen +"  |  Tuổi: " + this.tuoi+"  |  Ngành: " + nganh
				+ "  |  Điểm trung bình: " + this.diem + "  |  Học lực: " + this.getHocLuc());
	}
}
