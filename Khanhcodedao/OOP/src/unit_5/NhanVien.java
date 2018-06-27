package unit_5;

import java.util.Scanner;

public class NhanVien extends CanBo {

	public String phongBan;
	public int soNgayCong;
	public String chucVu;
	
	Scanner sc = new Scanner(System.in);
	
	public NhanVien() {
		
	}
	

	public NhanVien(String phongBan, int soNgayCong, String chucVu) {
		
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
	
	


	public String getPhongBan() {
		return phongBan;
	}


	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}


	public int getSoNgayCong() {
		return soNgayCong;
	}


	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}


	public String getChucVu() {
		return chucVu;
	}


	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}


	public void nhap() {
		super.nhap();
		System.out.print("nhap phong ban lam viec : ");
		this.phongBan = sc.nextLine();
		System.out.print("nhap chuc vu :");
		System.out.println(" 1 : Truong phong");
		System.out.println(" 2 : Pho phong ");
		System.out.println(" 3 : Nhan vien ");
		int chonChucVu = Integer.parseInt(sc.nextLine());
		
		if (chonChucVu == 1) {
			this.chucVu = "truong phong";
		} 
		else if (chonChucVu == 2) {
			this.chucVu = "pho phong";
		} 
		else if (chonChucVu == 3) {
			this.chucVu = "nhan vien";
		}
		
		System.out.print("nhap so ngay lam viec: ");
		this.soNgayCong = Integer.parseInt(sc.nextLine());
	}
	@Override
	public void xuat() {
		System.out.println(" Phong ban cong tac : "+phongBan);
		System.out.println(" Chuc vu : "+chucVu);
		System.out.println(" So ngay cong : "+soNgayCong);
	}

	@Override
	public double getTinhLuong() {
		return this.heSoLuong*730 + this.phuCap + this.soNgayCong*30;
	}

	@Override
	public double getPhuCap() {
			if(this.chucVu.equals("truong phong")) {
				return 2000;
			}
			else if (this.chucVu.equals("pho phong")) {
				return 1000;
			}
			else if (this.chucVu.equals("nhan vien")) {
				return 500;
			}
			return 0;
	}
}
