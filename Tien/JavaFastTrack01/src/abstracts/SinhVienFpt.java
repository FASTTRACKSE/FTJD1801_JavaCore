package abstracts;

public abstract class SinhVienFpt {
	private String hoTen;
	private String nganh;
	
	public SinhVienFpt() {
		super();
	}
	
	public SinhVienFpt(String hoTen, String nganh) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getNganh() {
		return nganh;
	}
	
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	
	abstract public double getDiem();
	
	public String getHocLuc() {		
		if(getDiem() < 5) {
			return "Yếu";
		}else if(getDiem() <= 6.5) {
			return "Trung Bình";
		}else if(getDiem() <= 7.5) {
			return "Khá";
		}else if(getDiem() < 9 ) {
			return "Giỏi";
		}else return "Xuất sắc";
	}
	
	public void xuat() {
		System.out.println(this.hoTen+this.nganh+this.getDiem()+this.getHocLuc());
	}
}
