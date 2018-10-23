package entity;

import java.io.Serializable;

public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maSV;
	private String hoTen;
	private int namSinh;
	
	public SinhVien() {
		super();
	}

	public SinhVien(String maSV, String hoTen, int namSinh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
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

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
}
