package entity;

public class QuanLiSinhVien {
private String maSv, hoTen, diaChi, Phuong, quanHuyen, tinhThanh, dienThoai, email, maLop;
	
	public QuanLiSinhVien() {
		//
	}
	
	public QuanLiSinhVien(String maSv, String hoTen, String diaChi, String Phuong, String quanHuyen, String tinhThanh, String dienThoai, String email, String maLop) {
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.Phuong = Phuong;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
		this.dienThoai = dienThoai;
		this.email = email;
		this.maLop = maLop;
		
	}
	
	public QuanLiSinhVien(String maSv, String hoTen) {
		this.maSv = maSv;
		this.hoTen = hoTen;
	}

	public String getMaSV() {
		return maSv;
	}

	public void setMaSV(String maSV) {
		this.maSv = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getPhuong() {
		return Phuong;
	}

	public void setPhuong(String Phuong) {
		this.Phuong = Phuong;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	
	

	@Override
	public String toString() {
		return this.maSv;
	}
}	