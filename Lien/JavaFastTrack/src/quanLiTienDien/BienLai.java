package quanLiTienDien;

import java.util.Scanner;

public class BienLai extends KhachHang{
	private int chiSoCu;
	private int chiSoMoi;
	private int tienDien;
	

	public int getChiSoCu() {
		return chiSoCu;
	}


	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}


	public int getChiSoMoi() {
		return chiSoMoi;
	}


	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}


	public BienLai() {
		super();
	}


	public BienLai(int chiSoCu, int chiSoMoi) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
	}
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập chỉ số cũ:");
		this.chiSoCu = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập chỉ số mới:");
		this.chiSoMoi = Integer.parseInt(sc.nextLine());
	}
	public void output() {
		super.output();
		System.out.println("Chỉ số cũ:"+chiSoCu+  "Chỉ số mới:"+chiSoMoi);
	}
	public int tinhTienDien() {
		this.tienDien = (chiSoMoi - chiSoCu) * 750;
		return tienDien;
	}
	public int getTienDien() {
		return tienDien;
	}
	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
