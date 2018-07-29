package unit4.canbo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import unit4.sinhvien.SinhVienBiz;
import unit4.sinhvien.SinhVienFPT;

public class QuanLiCanBo {

	public static void main(String[] args) {
		ArrayList<CanBo> canBolist = new ArrayList<CanBo>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Nhap thong tin danh sach can bo trong truong");
			System.out.println("2. Xuat danh sach giang vien hoac nhan vien");
			System.out.println("3. Xuất sinh viên có học lực giỏi");
			System.out.println("4. Tong so luong truong phai tra");
			System.out.println("5. Sap xep");
			System.out.println("0. Thoátt");
			System.out.print("Mời chọn : ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch (mChon) {
			case 1:
				System.out.println("Ban muon nhap can bo nao: ");
				String canbo = sc.nextLine();
				System.out.println(" Nhap so luong can bo: ");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuong; i++) {
					if (canbo.equals("giangvien")) {
						GiangVien gv = new GiangVien();
						gv.nhap();
						canBolist.add(gv);
					} else if (canbo.equals("nhanvien")) {
						NhanVien nv = new NhanVien();
						nv.nhap();
						canBolist.add(nv);
					}
				}
				break;

			case 2:
				System.out.println("Ban muon xuat can bo nao:giangvien/nhanvien");

				String canbo2 = sc.nextLine();
				if (canbo2.equals("giangvien")) {
					System.out.println("Ban muon xuat thong tin giang vien khoa nao ?");
					String khoa = sc.nextLine();

					for (CanBo cb : canBolist) {
						GiangVien gv = (GiangVien) cb;
						if (gv.getKhoa().equals(khoa)) {
							gv.xuat();
						}
					}
				} else if (canbo2.equals("nhanvien")) {
					for (CanBo cb : canBolist) {
						NhanVien nv = (NhanVien) cb;
						nv.xuat();
					}
				}
				break;

			case 4: {
				Collections.sort(canBolist, new Comparator<CanBo>() {
					public int compare(CanBo cb1, CanBo cb2) {
						if (cb1.tinhLuong() > cb2.tinhLuong()) {
							return 1;
						} else if (cb1.tinhLuong() < cb2.tinhLuong()) {
							return -1;
						} else {
							Collections.sort(canBolist, new Comparator<CanBo>() {
								public int compare(CanBo cb1, CanBo cb2) {
									return (cb1.hoTen.compareTo(cb2.hoTen));
								}
							});
							System.out.println();
							return 0;
						}
					}
				});
				System.out.println("Sap xep la");
				System.out.println();
				for (int i = 0; i < canBolist.size(); i++) {
					canBolist.get(i).xuat();
					System.out.println("");
				}
				break;

			}
			case 0:
				break;
			}
		}
	}
}
