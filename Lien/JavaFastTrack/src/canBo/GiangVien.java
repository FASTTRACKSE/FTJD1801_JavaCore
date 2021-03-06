package canBo;

import java.util.Scanner;

public class GiangVien extends CanBo{
	
	private String khoa;
	private String trinhdo;
	private int soTietDay;
	
	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, double heSoLuong, String khoa, String trinhdo, int soTietDay) {
		super(hoTen, heSoLuong);
		this.khoa = khoa;
		this.trinhdo = trinhdo;
		this.soTietDay = soTietDay;
	}
	
	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
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
		System.out.println("khoa: ");
		khoa = sc.nextLine();
		System.out.println("trình độ: ");
		trinhdo = sc.nextLine();
		System.out.println("số tiết dạy: ");
		soTietDay = Integer.parseInt(sc.nextLine());
	}
	
	public void xuat() {
		super.xuat();
		System.out.println("  -  Khoa: " + khoa + "  -  Trình độ chuyên môn: " + trinhdo + "  -  Số tiết dạy: " + soTietDay);
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return this.getHeSoLuong()*730+this.getPhuCap()+this.soTietDay*45;
	}

	@Override
	public int getPhuCap() {
		// TODO Auto-generated method stub
		if(this.getTrinhdo().equals("tiến sĩ")) {
			return 1000;
		}else if(this.getTrinhdo().equals("thạc sĩ")) {
			return 500;
		}else if(this.getTrinhdo().equals("cử nhân")) {
			return 300;
		}else {
			return 0;
		}
	}

}