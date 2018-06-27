package unit_5;

import java.util.Scanner;

public class GiangVien extends CanBo{

	public String khoa;
	public String trinhDo;
	public int soTietDay;
	public String maCB;
	
	Scanner sc = new Scanner(System.in);
	public GiangVien() {
	
	}

	
	public GiangVien(String khoa, String trinhdo, int sotietday) {
	
		this.khoa = khoa;
		this.trinhDo = trinhdo;
		this.soTietDay = sotietday;
	}
	
	


	public String getKhoa() {
		return khoa;
	}


	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}


	public String getTrinhdo() {
		return trinhDo;
	}


	public void setTrinhdo(String trinhdo) {
		this.trinhDo = trinhdo;
	}


	public int getSotietday() {
		return soTietDay;
	}


	public void setSotietday(int sotietday) {
		this.soTietDay = sotietday;
	}

	@Override
	public void nhap() {
		super.nhap();
		System.out.println(" Nhap khoa cong tac :");
		this.khoa = sc.nextLine();
		System.out.println(" Nhap trinh do :");
		System.out.println(" 1 : tien si ");
		System.out.println(" 2 : thac si ");
		System.out.println(" 3 : cu nhan ");
		int chon = Integer.parseInt(sc.nextLine());
		if(chon == 1) {
			this.trinhDo = "tien si";
		}
		else if(chon == 2) {
			this.trinhDo = "thac si";
		}
		else {
			this.trinhDo = "cu nhan";
		}
		
		System.out.println(" so tiet day trong thang : ");
		this.soTietDay = Integer.parseInt(sc.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println(" khoa cong tac : "+khoa);
		System.out.println(" trinh do : "+trinhDo);
		System.out.println(" so tiet day : "+soTietDay);
	}

	@Override
	public double getTinhLuong() {
		return this.heSoLuong*730+this.getPhuCap()+this.soTietDay*45;
	}

	@Override
	public double getPhuCap() {
		if (getTrinhdo().equals("cu nhan")) {
			return 300;
		} 
		else if (getTrinhdo().equals("thac si")) {
			return 500;
		} 
		else if (getTrinhdo().equals("tien si")) {
			return 1000;
		} 
		else 
		return 0;
	
	}
	

	
}
