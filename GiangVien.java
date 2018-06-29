package canbo;

import java.util.Scanner;

public class GiangVien extends CanBo {
	
	private String khoa;
	private String trinhDo;
	private int soTietDay;
	
	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, double heSoLuong, String khoa, String trinhDo, int soTietDay) {
		super(hoTen, heSoLuong);
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
		System.out.println("Khoa: ");
		khoa = sc.nextLine();
		System.out.println("Trình độ: ");
		trinhDo = sc.nextLine();
		System.out.println("Số tiết dạy: ");
		soTietDay = Integer.parseInt(sc.nextLine());
	}
	
	public void xuat() {
		super.xuat();
		System.out.println(" Khoa: " + this.khoa + " |Trinhdo: " + this.trinhDo + "  |Sotietday: " + this.soTietDay);
	}
	
	@Override
	public int getPhuCap() {
		// TODO Auto-generated method stub
		if(this.getTrinhDo().equals("Tiến sĩ")) {
			return 1000;
		}else if(this.getTrinhDo().equals("Thạc sĩ")) {
			return 500;
		}else if(this.getTrinhDo().equals("Cử nhân")) {
			return 300;
		}else {
			return 0;
		}
	}
	
	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return this.getHeSoLuong()*730+this.getPhuCap()+this.soTietDay*45;
	}
	}

	
	


