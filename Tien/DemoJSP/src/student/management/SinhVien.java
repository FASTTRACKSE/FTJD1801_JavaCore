package student.management;

import java.io.Serializable;

public class SinhVien implements Serializable{
	String maSV;
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
	
	public String getmaSV() {
		return maSV;
	}
	public void setmaSV(String maSV) {
		this.maSV = maSV;
	}
	public SinhVien() {
		super();
	}
	public SinhVien(String maSV, String hoTen, String namSinh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	
}
