package lab8;

import java.io.Serializable;
import java.util.Scanner;

public class GiangVien extends CanBo implements Serializable {
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
		for (;;) {
			System.out.println("Nhap trinh do: ");
			this.trinhDo = sc.nextLine();
			try {
				CanBoException.chkTrinhDo(trinhDo);
				break;
			} catch (CanBoException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
			System.out.println("Nhap so tiet day trong thang: ");
			this.soTietDay = Integer.parseInt(sc.nextLine());
			try {
				CanBoException.chkSo(soTietDay);
				break;
			} catch (CanBoException e) {
				System.err.println(e);
				System.out.println();
			}
		}
	}

	public void xuat() {
		super.xuat();
		System.out.println(getPhuCap() + " || khoa: " + this.khoa + " || Trinh do:" + this.trinhDo
				+ " || So tiet day trong thang: " + this.soTietDay + " || Luong: " + this.tinhLuong());
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
			return this.phuCap = 300;
		} else if (getTrinhDo().equals("thac si")) {
			return this.phuCap = 500;
		} else if (getTrinhDo().equals("tien si")) {
			return this.phuCap = 1000;
		} else
			return 0;
	}

}
