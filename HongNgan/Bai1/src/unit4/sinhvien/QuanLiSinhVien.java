package unit4.sinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLiSinhVien {

	public static void main(String[] args) {
		ArrayList<SinhVienFPT> students = new ArrayList<SinhVienFPT>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Nhập danh sách sinh viên");
			System.out.println("2. Xuất thông tin danh sách sinh viên");
			System.out.println("3. Xuất sinh viên có học lực giỏi");
			System.out.println("4. Sắp xếp danh sách sinh viên theo điểm");
			System.out.println("5. Xuất danh sách sinh viên IT");
			System.out.println("6. Xuất danh sách sinh viên Biz");
			System.out.println("0. Thoátt");
			System.out.print("Mời chọn : ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch (mChon) {
			case 1:
				System.out.println("Bạn muốn nhập sinh viên ngành nào: ");
				String nganh = sc.nextLine();
				System.out.println(" Nhập số lượng sinh viên: ");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuong; i++) {
					if (nganh.equals("It")) {
						SinhVienIT svIt = new SinhVienIT();
						svIt.nhap(students);
						students.add(svIt);
					} else if (nganh.equals("Biz")) {
						SinhVienBiz biz = new SinhVienBiz();
						biz.nhap(students);
						students.add(biz);
					}
				}
				break;
			case 2:
				for (SinhVienFPT svFPT : students) {
					svFPT.xuat();
				}
				break;
			case 3:
				for (SinhVienFPT svFPT : students) {
					if (svFPT.getHocLuc().equals(" Giỏi ")) {
						svFPT.xuat();
					}
				}
				break;
			case 4:
				Collections.sort(students, new Comparator<SinhVienFPT>() {
					public int compare(SinhVienFPT sv1, SinhVienFPT sv2) {
						if (sv1.getDiem() > sv2.getDiem()) {
							return 1;
						} else if (sv1.getDiem() == sv2.getDiem()) {
							return 0;
						} else
							return -1;
					}
				});
				break;
			case 5:
				for (SinhVienFPT svFpt : students) {
					if (svFpt instanceof SinhVienIT) {
						SinhVienIT svIT = (SinhVienIT) svFpt;
						svIT.xuatIt();
					}
				}
				break;
			case 6:
				for (SinhVienFPT svFpt : students) {
					if (svFpt instanceof SinhVienBiz) {
						SinhVienBiz svBiz = (SinhVienBiz) svFpt;
						svBiz.xuatBiz();
					}
				}
				break;
			}

		}
	}
}
