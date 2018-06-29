package abstracts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import test.write.file.Student;

public class QuanLySinhVien {
	static public void writeFile(ArrayList<SinhVienFpt> list) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("fileObject.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
		oos.close();
	}

	static public void readFile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("fileObject.txt");
			ois = new ObjectInputStream(fis);
			System.out.println("Doc tu file: ");
			ArrayList<SinhVienFpt> list = (ArrayList<SinhVienFpt>) ois.readObject();
			for(SinhVienFpt sv:list) {
				System.out.println(sv);
			}
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SinhVienFpt> students = new ArrayList<SinhVienFpt>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-----Quản Lý Tiền Điện----");
			System.out.println("-------------------------------------------");
			System.out.println("1. Nhập danh sách sinh viên");
			System.out.println("2. Xuất thông tin danh sách sinh viên");
			System.out.println("3. Xuất sinh viên có học lực giỏi");
			System.out.println("4. Sắp xếp danh sách sinh viên theo điểm");
			System.out.println("5. Xuất danh sách sinh viên IT");
			System.out.println("6. Xuất danh sách sinh viên Biz");
			System.out.println("7. Lưu danh sách sinh viên");
			System.out.println("8. Xuất danh sách sinh viên");
			System.out.println("0. Thoát");
			System.out.println("-------------------------------------------");
			System.out.print("Mời chọn một: ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch (mChon) {
			case 1:
				System.out.println("Bạn muốn nhập sinh viên thuộc lĩnh vực nào: ");
				System.out.println("IT / Biz");
				String loaiSV = sc.nextLine();
				System.out.println("Bạn muốn nhập bao nhiêu sinh viên: ");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < soLuong; i++) {
					if (loaiSV.equals("IT")) {
						SinhVienIT it = new SinhVienIT();
						it.nhap(students);
						students.add(it);
					} else if (loaiSV.equals("Biz")) {
						SinhVienBiz biz = new SinhVienBiz();
						biz.nhap(students);
						students.add(biz);
					}
				}
				break;
			case 2:
				for (SinhVienFpt svFPT : students) {
					svFPT.xuat();
				}
				break;
			case 3:
				for (SinhVienFpt svFPT : students) {
					if (svFPT.getHocLuc().equals("Giỏi")) {
						svFPT.xuat();
					}
				}
				break;
			case 4:
				Collections.sort(students, new Comparator<SinhVienFpt>() {
					public int compare(SinhVienFpt sv1, SinhVienFpt sv2) {
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
				for (SinhVienFpt svFpt : students) {
					if (svFpt instanceof SinhVienIT) {
						SinhVienIT svIT = (SinhVienIT) svFpt;
						svIT.xuatIT();
					}
				}
				break;
			case 6:
				for (SinhVienFpt svFpt : students) {
					if (svFpt instanceof SinhVienBiz) {
						SinhVienBiz svBiz = (SinhVienBiz) svFpt;
						svBiz.xuatBiz();
					}
				}
				break;
			case 7:
				try {
					QuanLySinhVien.writeFile(students);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				QuanLySinhVien.readFile();
				break;
			}

			if (mChon == 0) {
				break;
			}
		}
	}
}
