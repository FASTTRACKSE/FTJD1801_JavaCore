package quanlytiendien.entity;

public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private String diaChi;
	private int idPhuong;
	private int idQuan;
	private String dienThoai;
	private String email;
	private String maSoCongTo;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String hoTen, String diaChi, int idPhuong, int idQuan, String dienThoai,
			String email, String maSoCongTo) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.idPhuong = idPhuong;
		this.idQuan = idQuan;
		this.dienThoai = dienThoai;
		this.email = email;
		this.maSoCongTo = maSoCongTo;
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

	public void setIdPhuong(int idPhuong) {
		this.idPhuong = idPhuong;
	}

	public int getIdQuan() {
		return idQuan;
	}

	public void setIdQuan(int idQuan) {
		this.idQuan = idQuan;
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

	public String getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(String maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

}
