package atm;

import java.sql.Date;

public class GiaoDich extends Users {
	private String maSo;
	private String thoiGian;
	private double soTien;
	
	public GiaoDich() {
		super();
	}
	
	public GiaoDich(String maSo, String thoiGian, int soTien) {
		super();
		this.maSo = maSo;
		this.thoiGian = thoiGian;
		this.soTien = soTien;
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	
	public void xuat() {
		System.out.println(this.maSo + " | " + this.soTien +  " | " + this.thoiGian);
	}
	
}