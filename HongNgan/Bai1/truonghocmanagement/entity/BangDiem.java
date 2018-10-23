package entity;

public class BangDiem {
	public String maSinhVien;
	public String maLop;
	public String maMonHoc;
	public String tenMonHoc;
	public String ketQua;
	public String xepLoai;
	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BangDiem(String maSinhVien, String maLop, String maMonHoc, String tenMonHoc, String ketQua, String xepLoai) {
		super();
		this.maSinhVien = maSinhVien;
		this.maLop = maLop;
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.ketQua = ketQua;
		this.xepLoai = xepLoai;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getKetQua() {
		return ketQua;
	}
	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	public String getXepLoai() {
		return xepLoai;
	}
	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	
}
