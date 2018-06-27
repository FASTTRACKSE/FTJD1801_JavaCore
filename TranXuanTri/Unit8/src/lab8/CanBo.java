package lab8;

import java.io.Serializable;
import java.util.Scanner;

public abstract class CanBo implements Serializable{
	public String hoTen;
	public double heSoLuong;
	public double phuCap;
	
	public CanBo() {
		super();
	}
	
	public CanBo(String hoTen, double heSoLuong, double phuCap) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten can bo: ");
		this.hoTen = sc.nextLine();
		System.out.println("Nhap he so luong: ");
		this.heSoLuong = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		System.out.print(this.hoTen + " || He so luong: " + this.heSoLuong + " || Phu cap: ");
	}
	public abstract double tinhLuong();
	public abstract double getPhuCap();
}
