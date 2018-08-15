package fasttrackse.quanlytiendien.entity;

import java.util.Date;

public class BienLaiEntity {
	private String maSoCongToDien;
	private Date ngayNhap;
	private Date chuKiNhap;
	private int chiSoCongTo;
	public String getMaSoCongToDien() {
		return maSoCongToDien;
	}
	public void setMaSoCongToDien(String maSoCongToDien) {
		this.maSoCongToDien = maSoCongToDien;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getChuKiNhap() {
		return chuKiNhap;
	}
	public void setChuKiNhap(Date chuKiNhap) {
		this.chuKiNhap = chuKiNhap;
	}
	public int getChiSoCongTo() {
		return chiSoCongTo;
	}
	public void setChiSoCongTo(int chiSoCongTo) {
		this.chiSoCongTo = chiSoCongTo;
	}
	public void nhapBienLai() {
		
	}
}
