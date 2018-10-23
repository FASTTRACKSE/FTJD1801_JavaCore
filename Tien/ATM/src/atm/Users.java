package atm;

import java.util.Scanner;

public class Users {
	private String maSo;
	private String hoTen;
	private double soDu;
	private String loaiTienTe;
	private String trangThai;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String maSo, String hoTen, int soDu, String loaiTienTe, String trangThai) {
		super();
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDu = soDu;
		this.loaiTienTe = loaiTienTe;
		this.trangThai = trangThai;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập mã thẻ: ");
		this.maSo = sc.nextLine();
		
		System.out.println("Họ tên chủ tài khoản: ");
		this.hoTen = sc.nextLine();
		
		System.out.println("Số dư: ");
		this.soDu = Integer.parseInt(sc.nextLine());
		
		System.out.println("Loại tiền tệ: ");
		this.loaiTienTe = sc.nextLine();
		
		System.out.println("Trạng thái: ");
		this.trangThai = sc.nextLine();
		
	}
	
	public void xuat() {
		System.out.println("Tài khoản: " + this.hoTen + "|| Trạng thái: " + this.trangThai
				+ "|| Số dư: " + this.soDu + "|| Loại tiền tệ: " + this.loaiTienTe);
	}

}