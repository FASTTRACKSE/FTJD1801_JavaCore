package canbo;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLiCanBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CanBo> listCanBo = new ArrayList<CanBo>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. Nhập danh thông tin cán bộ");
			System.out.println("2. Hiển thị thông tin cán bộ");
			System.out.println("3. Tổng số lương phải trả cho cán bộ");
			System.out.println("4. Sắp xếp cán bộ theo lương");
			System.out.println("5. Lưu xuống file");
			System.out.println("6. Hiện thị dánh sách cán bộ tứ file");
			System.out.println("0. Thoát");
			System.out.print("Chọn thao tác");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Mời chọn cán bộ:");
				System.out.println("Giảng viên | Nhân viên");
				String loaiCanBo = sc.nextLine();
				System.out.println("Bạn muốn nhập bao nhiu cán bộ: ");
				int soCB = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soCB; i++) {
					if (loaiCanBo.equals("Giảng viên")) {
						GiangVien gv = new GiangVien();
						gv.nhap();
						listCanBo.add(gv);
					} else if (loaiCanBo.equals("Nhân viên")) {
						NhanVienHC nv = new NhanVienHC();
						nv.nhap();
						listCanBo.add(nv);
					}
				}
				break;
			case 2:
				for (CanBo cb : listCanBo) {
					cb.xuat();
				}
				break;
			case 3:
				double tongLuong = 0;
				for (CanBo cb : listCanBo) {
					tongLuong += cb.tinhLuong();
				}
				System.out.println("Tổng lương phải trả cho cán bộ: " + tongLuong);
				break;
			case 4:
				Collections.sort(listCanBo, new Comparator<CanBo>() {
					public int compare(CanBo cb1, CanBo cb2) {
						if(cb1.tinhLuong() > cb2.tinhLuong()) {
							return 1;
						}else if(cb1.tinhLuong() < cb2.tinhLuong()) {
							return -1;
						}else {
							Collections.sort(listCanBo, new Comparator<CanBo>() {
								public int compare(CanBo cb1, CanBo cb2) {
									return cb1.getHoTen().compareTo(cb2.getHoTen());
								}
							}
							
							); return 0;
						}
					}
				}

				);
			case 5:
				FileOutputStream fos;
				try {
					fos = new FileOutputStream("fileobject.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(listCanBo);
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}break;
			case 6:
				try {
					FileInputStream fis = new FileInputStream("fileobject.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					@SuppressWarnings("unchecked")
					ArrayList<CanBo> list = (ArrayList<CanBo>)ois.readObject();
					for (CanBo cb : list) {
						cb.xuat();
					}
				}catch(Exception e) {
					
				}
				
			}
		}
	}
}
