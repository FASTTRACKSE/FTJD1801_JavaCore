package unit4.tiendien;

import java.util.Scanner;

public class BienLai extends KhachHang {
	public int chiSoCu;
	public int chiSoMoi;
	public int thanhToan;
	
	public BienLai(String hoTen, String diaChi, int maSoCongTo, int chiSoCu, int chiSoMoi, int thanhToan) {
		super(hoTen, diaChi, maSoCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thanhToan = thanhToan;
	}
	
	public BienLai() {}
	
	public int getChiSoCu() {
		return chiSoCu;
	}
	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}
	public int getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}
	public int getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(int thanhToan) {
		this.thanhToan = thanhToan;
	}
	
	public void nhap() {
		super.nhap();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap chi so cu: ");
		this.chiSoCu=Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhap chi so moi: ");
		this.chiSoMoi=Integer.parseInt(sc.nextLine());
		
	}
	
	public double thanhtoan() {
		return this.thanhToan=(this.chiSoMoi-this.chiSoCu)*750;
	}
	
	 public void xuat() {
		 super.xuat();
		 System.out.println(this.chiSoCu+"|"+this.chiSoMoi+"|"+this.thanhtoan());
	 }

}
