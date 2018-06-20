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
		System.out.print("nhap chi so cu ");
		this.chiSoCu = sc.nextInt();
		System.out.print("nhap chi so moi ");
		this.chiSoMoi = sc.nextInt();
		this.tinhTien();
	}
	public void xuat() {
		super.xuat();
		System.out.print(" | " + this.chiSoCu+ " | " + this.chiSoMoi+ " || so tien: " + this.soTien);
		System.out.println("");
	}
	public void tinhTien() {

this.soTien = (this.chiSoMoi-this.chiSoCu)*750;

	}

	public static void main(String[] args) {
		ArrayList<BienLai> bills = new ArrayList<BienLai>();
		ArrayList<BienLai> tam = new ArrayList<BienLai>();

		while (true) {
			System.out.println("-------");
			System.out.println("1. Nhap thong tin bien lai");
			System.out.println("2. Hien thi thong tin bien lai");
			System.out.println("3. Sap xep bien lai tang dan theo so tien");
			System.out.println("4. Hien thi bien lai co tien thu nhieu nhat");
			System.out.println("5. Hien thi khach hang tieu ton nhieu nhat");
			System.out.println("0. Exit");
			System.out.println("Choice ");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.print("Nhap so luong khach hang ");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuong; i++) {
					BienLai bill = new BienLai();
					bill.nhap();
					bills.add(bill);
				}
			} else if (choice == 2) {
				for (int i = 0; i < bills.size(); i++) {
					bills.get(i).xuat();
				}
			} else if (choice == 3) {
				Collections.sort(bills, new Comparator<BienLai>() {
					public int compare(BienLai bl1, BienLai bl2) {
						if (bl1.getSoTien() > bl2.getSoTien()) {
							return 1;
						} else if ((bl1.getSoTien() == bl2.getSoTien())) {
							return 0;
						} else
							return -1;
					}
				});
			} else if (choice == 4) {
				double max = bills.get(0).soTien;
				int maxIndex = 0;
				for (int i = 0; i < bills.size(); i++) {
					if (max <= bills.get(i).soTien) {
						max = bills.get(i).soTien;
						maxIndex = i;
						// System.out.println(maxIndex);
					}
				}
				// System.out.println(maxIndex);
				bills.get(maxIndex).xuat();

			} else if (choice == 5) {

				tam.add(bills.get(0));
				for (int j = 0;j<tam.size();j++) {
				for (int i = 1; i < bills.size(); i++) {
					BienLai bl = bills.get(i);
					
						if (bl.hoTen.equals(tam.get(j).hoTen)) {
							System.out.println("Cong tien");
							BienLai bll = new BienLai();
							bll = tam.get(j);
							bll.soTien = bl.soTien + tam.get(j).soTien;
							System.out.println(bll.soTien);
							//tam.get(j).setSoTien(bll.soTien);
							bll.xuat();
							tam.set(j, bll);
							//tam.get(j).soTien = ;
						} else {
							// System.out.println(tam.get(j).soTien);
							// System.out.println(bills.get(i).soTien);
							// tam.get(j).soTien+=bills.get(i).soTien;
							tam.add(bl);
						}
					}
				}
//				double max = tam.get(0).soTien;
//				int maxIndex = 0;
//				for (int i = 0; i < tam.size(); i++) {
//					if (max <= tam.get(i).soTien) {
//						max = tam.get(i).soTien;
//						maxIndex = i;
//					}
//				}
//				tam.get(maxIndex).xuat();
				for (int i = 0; i < tam.size(); i++) {
					tam.get(i).xuat();
				}
			} else if (choice == 0) {
				System.out.println("Exit");
				break;
			}
		}
	}
}
