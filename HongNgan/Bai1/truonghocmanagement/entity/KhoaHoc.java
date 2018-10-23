package entity;

public class KhoaHoc {
	public String maKhoa;
	public String tenKhoa;
	public KhoaHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhoaHoc(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}

	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	
}	
