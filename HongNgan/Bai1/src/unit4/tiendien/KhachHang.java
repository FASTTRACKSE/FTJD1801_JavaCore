package unit4.tiendien;

import java.util.Scanner;

public class KhachHang {
	public String hoTen;
	public String diaChi;
	public int maSoCongTo;
	public KhachHang(String hoTen, String diaChi, int maSoCongTo) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.maSoCongTo = maSoCongTo;
	}
	public KhachHang() {
	
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
	public int getMaSoCongTo() {
		return maSoCongTo;
	}
	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap ho ten: ");
		this.hoTen=sc.nextLine();
		
		System.out.println("Nhap dia chi: ");
		this.diaChi=sc.nextLine();
		
		System.out.println("Nhap ma so cong to: ");
		this.maSoCongTo=Integer.parseInt(sc.nextLine());

	}
	public void xuat() {
		System.out.println(this.hoTen+"|"+this.diaChi+"|"+this.maSoCongTo);
	}
	
	
	
}
