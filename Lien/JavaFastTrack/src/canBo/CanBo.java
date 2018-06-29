package canBo;

import java.util.Scanner;

public abstract class CanBo {
	private String hoTen;
	private double heSoLuong;
	
	public CanBo(String hoTen, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
	}
	
	public CanBo() {
		super();
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

	abstract public double tinhLuong();
	abstract public int getPhuCap();
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Họ tên cán bộ: ");
		hoTen = sc.nextLine();		
		System.out.println("Hệ số lương: ");
		heSoLuong = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		System.out.print("Họ tên cán bộ: " + this.hoTen + "  -  Phụ cấp: " + this.getPhuCap() + "  -  Hệ số lương: " + this.heSoLuong + "  -  Tổng lương: "+ this.tinhLuong());
	}
	
}
