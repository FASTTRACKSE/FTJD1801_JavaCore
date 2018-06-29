package unit_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLCB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<CanBo> list = new ArrayList<CanBo>();
		System.out.println(" 1 : nhap thong tin danh sach can bo trong truong");
		System.out.println(" 2 : tim kiem (giang vien / can bo) theo bo phan");
		System.out.println(" 3 : tong luong phai tra cho can bo");
		System.out.println(" 4 : sap xep can bo theo luong ");
		System.out.println(" 5 : sap xep can bo theo ten ");
		System.out.println(" 6 : thoat chuong trinh ");
		int luachon;
		do {
		System.out.println("");
		System.out.print(" moi nhap lua chon : ");
		luachon = Integer.parseInt(sc.nextLine());
		
		switch(luachon) {
		case 1 :{
			System.out.println(" chuc vu cua can bo  : ");
			System.out.println(" 1 : Giang Vien ");
			System.out.println(" 2 : Nhan Vien ");
			String phanloai = sc.nextLine();
			System.out.print(" nhap vao so luong can bo : ");
			int n = Integer.parseInt(sc.nextLine());
			
			for(int i = 0 ; i<n ; i++) {
				if(phanloai.equals("1")) {
					GiangVien gv = new GiangVien();
					System.out.println(" thong tin giang vien thu : "+(i+1));
					gv.nhap();
					list.add(gv);
				}
				else if(phanloai.equals("2")) {
					NhanVien nv = new NhanVien();
					System.out.println(" thong tin nhan vien thu : "+(i+1));
					nv.nhap();
					list.add(nv);
				}
			}
			break;
		}
		
		case 2 :{
			System.out.println(" Ban muon xuat can bo nao ?");
			System.out.println(" 1 : Giang Vien ");
			System.out.println(" 2 : Nhan Vien ");
			int phanloai = Integer.parseInt(sc.nextLine());
			
			if (phanloai == 1) {
				System.out.println(" Xuat giang vien thuoc khoa : ");
				String khoa = sc.nextLine();
				for (CanBo cb : list) {
					GiangVien gv = (GiangVien) cb;
					if (gv.getKhoa().equalsIgnoreCase(khoa)) {
						gv.xuat();
					}
				}
			}
			
			if (phanloai == 2) {
				System.out.println(" Xuat nhan vien thuoc phong : ");
				String phong = sc.nextLine();
				for (CanBo cb : list) {
					NhanVien nv = (NhanVien) cb;
					if (nv.getPhongBan().equalsIgnoreCase(phong)) {
						nv.xuat();
					}
				}
			}
			
			break;
		}
		
		case 3 :{
			// chua lam duoc
		}
		
		case 4 :{
			Collections.sort(list, new Comparator<CanBo>() {
				public int compare(CanBo cb1, CanBo cb2) {
					if (cb1.getTinhLuong() > cb2.getTinhLuong()) {
						return 1;
					}
					else if (cb1.getTinhLuong() < cb2.getTinhLuong()) {
						return -1;
					} 
					else {
						Collections.sort(list, new Comparator<CanBo>() {
							public int compare(CanBo cb1, CanBo cb2) {
								return (cb1.hoTen.compareTo(cb2.hoTen));
							}
						});
						System.out.println();
						return 0;
					}
				}
			}); 
			System.out.println("== DANH SACH SAU KHI SAP XEP== ");
			System.out.println();
			for(int i =0; i < list.size(); i++) {
				list.get(i).xuat();
				System.out.println("");
			}
			break;
		}
		
		case 5 :{
			break;
		}
		
		case 6 :{
			System.out.println(" ban da thoat chuong trinh !");
			break;
		}
		}
	}while(luachon !=6);
	}
}
