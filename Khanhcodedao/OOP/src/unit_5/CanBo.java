package unit_5;

import java.util.ArrayList;
import java.util.Scanner;
import unit_6.SuLyNgoaiLe;
import unit_5.QLCB;
public abstract class CanBo {

	public String hoTen;
	public double heSoLuong;
	public double phuCap;
	public String maCB;

	
	public CanBo() {
	}
	
	public CanBo(String hoten, double hesoluong, double phucap) {
		this.hoTen = hoten;
		this.heSoLuong = hesoluong;
		this.phuCap = phucap;
		this.maCB = maCB;
	}

	public String getHoten() {
		return hoTen;
	}

	public void setHoten(String hoten) {
		this.hoTen = hoten;
	}

	public double getHesoluong() {
		return heSoLuong;
	}

	public void setHesoluong(double hesoluong) {
		this.heSoLuong = hesoluong;
	}

	public double getPhucap() {
		return phuCap;
	}

	public void setPhucap(double phucap) {
		this.phuCap = phucap;
	}
	
	public String getMaCB() {
		return maCB;
	}

	public void setMaCB(String maCB) {
		this.maCB = maCB;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Nhap ho ten can bo: ");
			this.hoTen = sc.nextLine();
			try {
				SuLyNgoaiLe.chkHoTen(hoTen);
				SuLyNgoaiLe.chkHoTen(hoTen);
				break;
			}catch(SuLyNgoaiLe e) {
				System.err.println(e);
			
			}
		}
		while(true) {
		System.out.println("Nhap he so luong: ");
		this.heSoLuong = Double.parseDouble(sc.nextLine());
			try {
				SuLyNgoaiLe.chkso(heSoLuong);
				break;
			
			}catch(SuLyNgoaiLe e) {
				System.err.println(e);
			}
		}
		while(true) {
			System.out.print(" Nhap vao ma can bo : ");
			maCB = sc.nextLine();
			try {
				ArrayList<CanBo> list = new ArrayList<>();
				SuLyNgoaiLe.chkMCB(maCB, list );
				break;
			}catch(SuLyNgoaiLe e) {
				System.err.println(e);
			}
		
		}
	}
	
	public void xuat() {
		System.out.println(" Ten can bo : "+hoTen);
		System.out.println(" He so luong : "+heSoLuong);
	}
	
	abstract public  double getTinhLuong();
	abstract public  double getPhuCap();
}
