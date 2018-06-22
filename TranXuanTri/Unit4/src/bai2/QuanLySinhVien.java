package bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class QuanLySinhVien {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SinhVienFpt> sinhVienList = new ArrayList<SinhVienFpt>();
		while (true) {
			System.out.println("-------");
			System.out.println("1. Nhap danh sach sinh vien");
			System.out.println("2. Xuat thong tin danh sach sinh vien");
			System.out.println("3. Xuat danh sach sinh vien co hoc luc gioi");
			System.out.println("4. Sap xep danh sach sinh vien theo diem ");
			System.out.println("5. Xuat ra sinh vien theo nganh ");
			System.out.println("0. Ket thuc");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.println("nhap so luong sinh vien");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuong; i++) {
					System.out.println("sinh vien thuoc nganh nao");
					String nganh = sc.nextLine();
					if (nganh.equals("IT") || nganh.equalsIgnoreCase("IT")) {
						SinhVienIT sv = new SinhVienIT();
						sv.nhap();
						sinhVienList.add(sv);
					} else if (nganh.equals("Biz") || nganh.equalsIgnoreCase("Biz")) {
						SinhVienBiz sv = new SinhVienBiz();
						sv.nhap();
						sinhVienList.add(sv);
					} else
						System.out.println("Sai");
				}
			}
			if (choice == 2) {
				for (int i = 0; i < sinhVienList.size(); i++) {
					sinhVienList.get(i).xuat();
				}
			} else if (choice == 3) {
				System.out.println("Danh sach sinh vien co hoc luc gioi: ");
				for (int i = 0; i < sinhVienList.size(); i++) {
					if (sinhVienList.get(i).getHocLuc().equals("Gioi")) {
						sinhVienList.get(i).xuat();
					}
				}
			} else if (choice == 4) {
				Collections.sort(sinhVienList, new Comparator<SinhVienFpt>() {
					public int compare(SinhVienFpt sv1, SinhVienFpt sv2) {
						if (sv1.getDiem() > sv2.getDiem()) {
							return -1;
						} else if (sv1.getDiem() == sv2.getDiem()) {
							return 0;
						} else
							return 1;
					}
				});
				System.out.println("Danh sach sinh vien sap xep theo diem: ");
				for (int i = 0; i < sinhVienList.size(); i++) {
					sinhVienList.get(i).xuat();
				}
			} else if (choice == 5) {
				System.out.println("Sinh vien thuoc nganh IT ");
				for (SinhVienFpt svFPT : sinhVienList) {
					if (svFPT instanceof SinhVienIT) {
						SinhVienIT svIT = (SinhVienIT) svFPT;
						svIT.xuat();
					}
				}
				System.out.println("Sinh vien thuoc nganh Biz ");
				for (SinhVienFpt svFPT : sinhVienList) {
					if (svFPT instanceof SinhVienBiz) {
						SinhVienBiz svBiz = (SinhVienBiz) svFPT;
						svBiz.xuat();
					}
				}
			} else if (choice == 0) {
				System.out.println("Exit");
				break;
			}
		}
	}

}
