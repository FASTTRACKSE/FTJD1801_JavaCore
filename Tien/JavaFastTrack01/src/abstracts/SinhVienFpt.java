package abstracts;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienFpt {
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
			return "Yáº¿u";
		} else if (getDiem() <= 6.5) {
			return "Trung BÃ¬nh";
		} else if (getDiem() <= 7.5) {
			return "KhÃ¡";
		} else if (getDiem() < 9) {
			return "Giá»�i";
		} else
			return "Xuáº¥t sáº¯c";
	}

	public void nhap(ArrayList<SinhVienFpt> list) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("MÃ£ sinh viÃªn: ");
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
			System.out.println("Há»� tÃªn: ");
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
			System.out.println("Tuá»•i: ");
			tuoi = Integer.parseInt(sc.nextLine());
			try {
				SinhVienException.checkTuoi(tuoi);
				break;
			} catch (SinhVienException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		System.out.println("NgÃ nh: ");
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
				System.out.println("Má»�i nháº­p láº¡i: ");
			}
		}
		return diem;
	}

	public void xuat() {
		this.diem = this.getDiem();
		System.out.println("MÃ£ sinh viÃªn: " + this.maSV + "  |  Há»� tÃªn: " + this.hoTen +"  |  Tuá»•i: " + this.tuoi+"  |  NgÃ nh: " + nganh
				+ "  |  Ä�iá»ƒm trung bÃ¬nh: " + this.diem + "  |  Há»�c lá»±c: " + this.getHocLuc());
	}
}
