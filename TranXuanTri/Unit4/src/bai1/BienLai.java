package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class BienLai extends KhachHang {
	public int chiSoCu;
	public int chiSoMoi;
	public double soTien;
	
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
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap chi so cu ");
		this.chiSoCu = sc.nextInt();
		System.out.println("nhap chi so moi");
		this.chiSoMoi = sc.nextInt();
	}
	public void xuat() {
		super.xuat();
		System.out.print(" | " + this.chiSoCu+ " | " + this.chiSoMoi+ " || so tien: " + this.tinhTien());
		System.out.println("");
	}
	public double tinhTien() {
		return this.soTien = (this.chiSoMoi-this.chiSoCu)*750;
	}
	public static void main(String[] args) {
		ArrayList<BienLai> bills = new ArrayList<BienLai>();
		while (true) {
				System.out.println("-------");
				System.out.println("1.Nhap thong tin khach hang");
				System.out.println("2.Hien thi thong tin bien lai");
				System.out.println("3.Sap xep bien lai tang dan theo so tien");
				System.out.println("4.Hien thi bien lai co tien thu nhieu nhat");
				System.out.println("------");
				System.out.println("Choice");
				Scanner sc = new Scanner(System.in);
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					System.out.print("Nhap so luong khach hang");
					int soluong = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < soluong; i++) {
					BienLai bill = new BienLai();
					bill.nhap();
					bills.add(bill);
					}
				} else if (choice == 2) {
					for (int i = 0; i < bills.size();i++) {
						bills.get(i).xuat();
					}
				} else if (choice == 3) {
					Collections.sort(bills,new Comparator<BienLai>() {
						public int compare(BienLai bl1,BienLai bl2) {
						if (bl1.getSoTien() > bl2.getSoTien()) {
							return 1;
						}
						else if ((bl1.getSoTien() == bl2.getSoTien())) {
							return 0;
						}
						else return -1;
						}
						});
				} else if (choice == 4) {
					bills.get(bills.size()-1).xuat();
				} else if (choice == 5) {
					
				}
				else if (choice == 0) {
					System.out.println("Exit");
					break;
				}
		}
	}
}
