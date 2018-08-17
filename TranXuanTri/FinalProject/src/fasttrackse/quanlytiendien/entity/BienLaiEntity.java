package fasttrackse.quanlytiendien.entity;

import java.util.Date;

public class BienLaiEntity {
	private int maSoCongToDien;
	private Date ngayNhap;
	private Date chuKiNhap;
	private int chiSoCongTo;
	private int maBienLai;
	private double tienDien;

	public int getMaBienLai() {
		return maBienLai;
	}

	public void setMaBienLai(int maBienLai) {
		this.maBienLai = maBienLai;
	}

	public double getTienDien() {
		return tienDien;
	}

	public void setTienDien(double tienDien) {
		this.tienDien = tienDien;
	}

	public int getMaSoCongToDien() {
		return maSoCongToDien;
	}

	public void setMaSoCongToDien(int maSoCongToDien) {
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
}
