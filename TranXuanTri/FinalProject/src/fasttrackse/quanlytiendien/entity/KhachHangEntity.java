package fasttrackse.quanlytiendien.entity;


public class KhachHangEntity {
	private String maKhachHang;
	private String hoTen;
	private String diaChi;
	private String phuong;
	private String quan;
	private int dienThoai;
	private String email;
	private String maSoCongTo;

	public KhachHangEntity() {
		super();
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
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
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public int getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(int dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaSoCongTo() {
		return maSoCongTo;
	}
	public void setMaSoCongTo(String maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}
	
	public void nhapKH (String maKH, String hoTen, String diaChi, String phuong, String quan, int dienThoai, String email, String maSoCongTo) {

	}
	public void suaKH() {
		
	}
	public void xoaKH() {
		
	}
	
	
}
