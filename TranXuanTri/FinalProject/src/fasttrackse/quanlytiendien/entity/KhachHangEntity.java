package fasttrackse.quanlytiendien.entity;

public class KhachHangEntity {
	private String maKhachHang;
	private String hoTen;
	private String diaChi;
	private int idPhuong;
	private int idQuan;
	private String phuong;
	private String quan;
	private String dienThoai;
	private String email;
	private int maSoCongTo;

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

	public int getIdPhuong() {
		return idPhuong;
	}

	public void setIdPhuong(int phuong) {
		this.idPhuong = phuong;
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

	public int getIdQuan() {
		return idQuan;
	}

	public void setIdQuan(int quan) {
		this.idQuan = quan;
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

	public int getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}
}
