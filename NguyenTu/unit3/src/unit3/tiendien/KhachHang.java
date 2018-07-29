package unit3.tiendien;

import java.util.Scanner;

public class KhachHang {
	private String tenKh, diaChi, maCongTo;
	

	public KhachHang() {
		super();
	}

	public KhachHang(String tenKh, String diaChi, double soTien) {
		super();
		this.tenKh = tenKh;
		this.diaChi = diaChi;
		this.maCongTo = maCongTo;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhâp tên KH: ");
		this.tenKh = sc.nextLine();

		System.out.println(" Nhập địa chỉ: ");
		this.diaChi = sc.nextLine();
		
		System.out.println(" Nhập mã số công tơ: ");
		this.maCongTo = sc.nextLine();

	}

	public void xuat() {
		System.out.print(this.tenKh + "|" + this.diaChi + "|" + this.maCongTo);
	}

	
}
