package quanlytiendien;

import java.util.Scanner;

public class BienLai extends KhachHang{
	private int chiSoCu;
	private int chiSoMoi;
	private int tienDien;
	public BienLai() {
		super();
	}

	public BienLai(String hoTen, String soNha, String maSoCongTo, int chiSoCu, int chiSoMoi) {
		super(hoTen, soNha, maSoCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
	}
	
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
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập chỉ số cũ: ");
		this.chiSoCu = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập chỉ số mới: ");
		this.chiSoMoi = Integer.parseInt(sc.nextLine());
	}
	public void xuat() {
		super.xuat();
		System.out.println("  |  Chỉ số cũ: "+this.chiSoCu+"  |  Chỉ số mới: "+this.chiSoMoi);
	}
	public int tinhTienDien() {
		this.tienDien = (chiSoMoi - chiSoCu)*750; 
		return  tienDien;
	}

	public int getTienDien() {
		return tienDien;
	}

	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}
}
