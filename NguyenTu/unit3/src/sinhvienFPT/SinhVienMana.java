package sinhvienFPT;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class SinhVienMana {
	public static void main(String[] args) {
		ArrayList<SinhVienFPT>sinhvien = new ArrayList();
		while (true) {
			System.out.println("1. Nhập danh sách sinh viên");
			System.out.println("2. Hiển thị thông tin sinh viên");
			System.out.println("3. Xuất sinh viên có học lực giỏi");
			System.out.println("4. Sắp xếp sinh viên theo điểm");
			System.out.println("5. Xuất danh sách sinh viên IT");
			System.out.println("6. Xuát dánh sách sinh viên Biz");
			System.out.println("0. Kết thúc chương trình");
			System.out.print("Chọn thao tác");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("Mời chọn sinh viên: ");
				System.out.println("IT / Biz");
				String loaiSv = sc.nextLine();
				System.out.println("Bạn muốn nhập bao nhiêu sinh viên: ");
				int soSv = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < soSv; i++) {
					if(loaiSv.equals("IT")) {
						SinhVienIT it = new SinhVienIT();
						it.nhap(sinhvien);
						sinhvien.add(it);
					}else if(loaiSv.startsWith("Biz")) {
						SinhVienBiz biz = new SinhVienBiz();
						biz.nhap(sinhvien);
						sinhvien.add(biz);
					}
				}break;
			case 2: for(SinhVienFPT st : sinhvien) {
				st.xuat();
			}break;
			case 3: for(SinhVienFPT st : sinhvien) {
				if(st.getHocLuc().equals("Giỏi")) {
					st.xuat();
				}
			}break;
			case 4: Collections.sort(sinhvien, new Comparator<SinhVienFPT>() {
				public int compare(SinhVienFPT sv1, SinhVienFPT sv2) {
					if(sv1.getDiem() > sv2.getDiem()) {
						return 1;
					}else if(sv1.getDiem() == sv2.getDiem()) {
						return 0;
					}else
						return -1;
				}
			});break;
			case 5: for(SinhVienFPT st : sinhvien) {
						if(st instanceof SinhVienIT) {
							SinhVienIT stIT = (SinhVienIT) st;
							stIT.xuat2();
						}
			}break;
			case 6: for(SinhVienFPT st : sinhvien) {
						if(st instanceof SinhVienBiz) {
							SinhVienBiz stBiz = (SinhVienBiz) st;
							stBiz.xuat3();
						}
			}break;
			}
			if(choice == 0) {
				break;
			}
			}
	}
}
