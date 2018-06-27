package sinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLiSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<SinhVienFpt> students = new ArrayList<SinhVienFpt>(); 
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----QUẢN LÍ SINH VIÊN----");
			System.out.println("-------------------------------------------");
			System.out.println("1. Nhập danh sách sinh viên");
			System.out.println("2. Xuất thông tin danh sách sinh viên");
			System.out.println("3. Xuất sinh viên có học lực giỏi");
			System.out.println("4. Sắp xếp danh sách sinh viên theo điểm");
			System.out.println("5. Xuất danh sách sinh viên IT");
			System.out.println("6. Xuất danh sách sinh viên Biz");
			System.out.println("0. Thoát");
			System.out.println("-------------------------------------------");
			System.out.print("Mời chọn một: ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch(mChon) {
			case 1: System.out.println("Bạn muốn nhập sinh viên thuộc lĩnh vực nào: ");
					System.out.println("IT / Biz");
					String loaiSV = sc.nextLine();
					System.out.println("Bạn muốn nhập bao nhiêu sinh viên: ");
					int soLuong = Integer.parseInt(sc.nextLine());					
					for(int i = 0; i < soLuong; i++) {
						if(loaiSV.equals("IT")) {
							SinhVienIT it = new SinhVienIT();
							it.nhap(students);
							students.add(it);
						}else if(loaiSV.equals("Biz")) {
							SinhVienBiz  biz = new SinhVienBiz();
							biz.nhap(students);
							students.add(biz);
						}						
					} break;
			case 2: for(SinhVienFpt svFPT : students) {
						svFPT.xuat();
					} break;
			case 3: for(SinhVienFpt svFPT : students) {
						if(svFPT.getHocLuc().equals("Giỏi")) {
							svFPT.xuat();
						}
					} break;
			case 4: Collections.sort(students, new Comparator<SinhVienFpt>() {
						public int compare(SinhVienFpt sv1, SinhVienFpt sv2) {
							if (sv1.getDiem() > sv2.getDiem()) {
								return 1;
							} else if (sv1.getDiem() == sv2.getDiem()) {
								return 0;
							} else
								return -1;
						}
					}); break;
			case 5: for(SinhVienFpt svFpt : students) {
						if(svFpt instanceof SinhVienIT) {
							SinhVienIT svIT = (SinhVienIT) svFpt;
							svIT.xuatIT();
						}
					} break;
			case 6: for(SinhVienFpt svFpt : students) {
						if(svFpt instanceof SinhVienBiz) {
							SinhVienBiz svBiz = (SinhVienBiz) svFpt;
							svBiz.xuatBiz();
						}
					} break;	
			}			
			if(mChon == 0) {
				break;
			}			
		}
 	}

 }
