package canbo;

import java.util.Scanner;

public class GiangVien extends CanBo {
	private String khoa, trinhDo;
	private int soTietDay;

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
		System.out.println("Nhập khoa: ");
		this.khoa = sc.nextLine();
		for(;;) {
		System.out.println("Trình độ: ");
		this.trinhDo = sc.nextLine();
		try {
			CanBoEx.chkTrinhDo(trinhDo);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
		}
		for(;;) {
		System.out.println("Số tiết dạy: ");
		this.soTietDay = Integer.parseInt(sc.nextLine());
		try {
			CanBoEx.chkSoNguyen(soTietDay);
			break;
		}catch(CanBoEx e) {
			System.err.println(e);
			System.out.println();
		}
	}
	}

	public void xuat() {
		super.xuat();
		System.out.println(
				"  |  Khoa:" + this.khoa + "   |  Trình độ" + this.trinhDo + "   |  Số tiết dạy: " + this.soTietDay);
	}
	public double tinhLuong() {
		return this.getHeSL()*730+this.getPhuCap()+this.soTietDay*45;
	}
	public int getPhuCap() {
		if(this.getTrinhDo().equals("Tiến sĩ")) {
			return 1000;
		}else if(this.getTrinhDo().equals("Thạc sĩ")) {
			return 500;
		}else if(this.getTrinhDo().equals("Cử nhân")) {
			return 300;
		}else
			return 0;
	}
}
