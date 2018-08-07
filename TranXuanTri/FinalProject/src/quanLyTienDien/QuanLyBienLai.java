package quanLyTienDien;

import java.util.Date;

public class QuanLyBienLai {
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
	public double tinhTien(int chiSoCu, int chiSoMoi) {
		double soDien = chiSoMoi-chiSoCu;
		if (soDien<=50) {
			return 1.549*(soDien);
		} else if (soDien<=100) {
			return 1.549*50+1.600*(soDien-50);
		} else if (soDien<=200) {
			return 1.549*50 + 1.600*50 + 1.858*(soDien-100);
		} else if (soDien<=300) {
			return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*(soDien-200);
		} else if (soDien<=400) {
			return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*100 + 2.615*(soDien-300);
		} else return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*100 + 2.615*100 + 2.701*(soDien-400);
	}
}
