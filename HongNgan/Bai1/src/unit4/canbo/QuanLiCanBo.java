package unit4.canbo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import unit4.sinhvien.SinhVienBiz;
import unit4.sinhvien.SinhVienFPT;

public class QuanLiCanBo implements Serializable {

	public static void main(String[] args) {
		ArrayList<CanBo> canBolist = new ArrayList<CanBo>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Nhap thong tin danh sach can bo trong truong");
			System.out.println("2. Xuat danh sach giang vien hoac nhan vien");
			System.out.println("3. Tong so luong truong phai tra");
			System.out.println("4. Sap xep");
			System.out.println("5. Ghi du lieu vao file nhanvien.dat");
			System.out.println("6. Doc du lieu tu file nhanvien.dat");
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

			case 3:

				double tongLuong = 0;
				for (CanBo cb : canBolist) {
					tongLuong += cb.tinhLuong();
				}
				System.out.println("Tong so luong truong phai tra: " + tongLuong);
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
							return 0;
						}
					}
				});
				System.out.println("Danh sach sau sap xep: ");
				for (CanBo cb : canBolist) {
					if (cb instanceof GiangVien) {
						GiangVien gv = (GiangVien) cb;
						gv.xuat();
					} else if (cb instanceof NhanVien) {
						NhanVien nv = (NhanVien) cb;
						nv.xuat();
					}
				}

				break;

			}
			case 5:
				try {
					FileOutputStream fos = new FileOutputStream("nhanvien.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(canBolist);
					System.out.println("Da doc ");

					oos.close();
				} catch (Exception e) {
					System.out.println("Co loi " + e);
				}
				break;
			case 6:
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream("nhanvien.dat");
					ois = new ObjectInputStream(fis);
					ArrayList<CanBo> cb1 = (ArrayList<CanBo>) ois.readObject();
					;
					System.out.println("Doc tu file ");
					for (CanBo cb : cb1) {
						if (cb instanceof GiangVien) {
							GiangVien gv = (GiangVien) cb;
							gv.xuat();
						} else if (cb instanceof NhanVien) {
							NhanVien nv = (NhanVien) cb;
							nv.xuat();
						}
					}
					ois.close();
					fis.close();
				} catch (Exception e) {
					System.out.println("Co loi " + e);
				}
				break;
			case 0:
				break;
			}
		}
	}
}
