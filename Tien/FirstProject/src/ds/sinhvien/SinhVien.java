package ds.sinhvien;

import java.io.Serializable;

public class SinhVien implements Serializable{
	String MaSV;
	String hoTen;
	String namSinh;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public SinhVien() {
		super();
	}
	public SinhVien(String maSV, String hoTen, String namSinh) {
		super();
		this.MaSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	
}
