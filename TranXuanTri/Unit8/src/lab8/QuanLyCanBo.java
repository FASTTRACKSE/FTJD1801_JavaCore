package lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLyCanBo implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CanBo> canBoList = new ArrayList<CanBo>();
		while (true) {
			System.out.println("-------");
			System.out.println("1. Nhap thong tin danh sach can bo trong truong");
			System.out.println("2. Xuat danh sach giang vien(nhan vien)");
			System.out.println("3. Tong so luong truong phai tra cho can bo");
			System.out.println("4. Sap xep can bo theo luong");
			System.out.println("5. Ghi du lieu vao file nhanvien.dat");
			System.out.println("6. Doc du lieu tu file nhanvien.dat");
			System.out.println("0. Ket thuc");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("nhap so luong can bo: ");
				int soLuong = Integer.parseInt(sc.nextLine());

				System.out.println("Can bo la: ");
				System.out.println("1. Giang vien");
				System.out.println("2. Nhan vien");
				String phanLoai1 = sc.nextLine();
				for (int i = 0; i < soLuong; i++) {
					if (phanLoai1.equals("1")) {
						GiangVien gv = new GiangVien();
						gv.nhap();
						canBoList.add(gv);
					} else if (phanLoai1.equals("2")) {
						NhanVien nv = new NhanVien();
						nv.nhap();
						canBoList.add(nv);
					}
				}
				break;
			case 2:
				System.out.println("Ban muon xuat can bo nao?");
				System.out.println("1. Giang vien");
				System.out.println("2. Nhan vien");
				System.out.println("3. Xuat toan bo danh sach can bo");
				int phanLoai2 = Integer.parseInt(sc.nextLine());
				if (phanLoai2 == 1) {
					System.out.println("Ban muon xuat thong tin giang vien khoa nao ?");
					String khoa = sc.nextLine();
					for (CanBo cb : canBoList) {
						GiangVien gv = (GiangVien) cb;
						if (gv.getKhoa().equals(khoa)) {
							gv.xuat();
						}
					}
				} else if (phanLoai2 == 2) {
					System.out.println("Ban muon xuat thong tin nhan vien phong ban nao ?");
					String phong = sc.nextLine();
					for (CanBo cb : canBoList) {
						NhanVien nv = (NhanVien) cb;
						if (nv.getPhongBan().equals(phong)) {
							nv.xuat();
						}
					}
				} else if (phanLoai2 == 3) {
					for (CanBo cb : canBoList) {
						cb.xuat();
					}
				}
				break;

			case 3:

				double tongLuong = 0;
				for (CanBo cb : canBoList) {
					tongLuong += cb.tinhLuong();
				}
				System.out.println("Tong so luong truong phai tra: " + tongLuong);
				break;
			case 4:
				Collections.sort(canBoList, new Comparator<CanBo>() {
					public int compare(CanBo cb1, CanBo cb2) {
						if (cb1.tinhLuong() > cb2.tinhLuong()) {
							return 1;
						} else if (cb1.tinhLuong() < cb2.tinhLuong()) {
							return -1;
						} else {
							Collections.sort(canBoList, new Comparator<CanBo>() {
								public int compare(CanBo cb1, CanBo cb2) {
									return (cb1.hoTen.compareTo(cb2.hoTen));
								}
							});
							return 0;
						}
					}
				});
				System.out.println("Danh sach sau sap xep: ");
				for (CanBo cb : canBoList) {
					if (cb instanceof GiangVien) {
						GiangVien gv = (GiangVien) cb;
						gv.xuat();
					} else if (cb instanceof NhanVien) {
						NhanVien nv = (NhanVien) cb;
						nv.xuat();
					}
				}
				break;
			case 5:
				try {
					FileOutputStream fos = new FileOutputStream("nhanvien.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
						oos.writeObject(canBoList);	
					
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
					ArrayList<CanBo> cb1 = (ArrayList<CanBo>) ois.readObject(); ;
					System.out.println("Doc tu file");
					for (CanBo cb : cb1) {
						if (cb instanceof GiangVien) {
							GiangVien gv = (GiangVien) cb;
							gv.xuat();
						} else if  (cb instanceof NhanVien) {
							NhanVien nv = (NhanVien) cb;
							nv.xuat();
						}
					}
					ois.close();
					fis.close();
				}
				catch (Exception e) {
					System.out.println("Co loi " + e);
				}
				break;
			case 0:
				break;
			}

		}
	}

}
