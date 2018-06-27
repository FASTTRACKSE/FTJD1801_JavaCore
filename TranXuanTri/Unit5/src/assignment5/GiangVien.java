package assignment5;

import java.util.Scanner;

public class GiangVien extends CanBo {
	public String khoa;
	public String trinhDo;
	public int soTietDay;
	
	public GiangVien() {
		super();
	}

	public GiangVien(String khoa, String trinhDo, int soTietDay) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap khoa: ");
		this.khoa = sc.nextLine();
		System.out.println("Nhap trinh do: 1. Tien si, 2. Thac si, 3. Cu nhan");
		int chonTrinhDo = Integer.parseInt(sc.nextLine());
		if (chonTrinhDo == 1) {
			this.trinhDo = "tien si";
		} else if (chonTrinhDo == 2) {
			this.trinhDo = "thac si";
		} else this.trinhDo = "cu nhan";
		
		System.out.println("Nhap so tiet day trong thang: ");
		this.soTietDay = Integer.parseInt(sc.nextLine());
	}
	public void xuat() {
		super.xuat();
		System.out.println (this.phuCap + " || khoa: " + this.khoa + " || Trinh do:" + this.trinhDo + " || So tiet day trong thang: " + this.soTietDay + " || " + this.tinhLuong());
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return this.heSoLuong * 730 + this.getPhuCap() + this.soTietDay * 45;
	}

	@Override
	public double getPhuCap() {
		// TODO Auto-generated method stub
		if (getTrinhDo().equals("cu nhan")) {
			return 300;
		} else if (getTrinhDo().equals("thac si")) {
			return 500;
		} else if (getTrinhDo().equals("tien si")) {
			return 1000;
		} else 
		return 0;
	}

}
