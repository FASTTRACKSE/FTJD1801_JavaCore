package canbo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyCanBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CanBo> danhsach = new ArrayList<CanBo>(); 
		Scanner sc = new Scanner(System.in);
		GiangVien gv = new GiangVien();
		NhanVien nv = new NhanVien();
		while(true) {
			System.out.println("-------");
			System.out.println("1. Nhap thong tin danh sach can bo");
			System.out.println("2. Xuat danh sach giang vien hoac nhan vien");
			System.out.println("3. Tong so luong truong phai tra cho can bo");
			System.out.println("4. Sap xep can bo theo luong");
			System.out.println("0. Ket thuc");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: System.out.println("Bạn muốn nhập cán bộ loại nào: ");
					System.out.println("1. Giảng viên \n2. Nhân viên");
					String loaiSV = sc.nextLine();
					System.out.println("Bạn muốn nhập bao nhiêu cán bộ: ");
					int soLuong = Integer.parseInt(sc.nextLine());					
					for(int i = 0; i < soLuong; i++) {
						if(loaiSV.equals("1")) {							
							gv.nhap();
							danhsach.add(gv);
						}else if(loaiSV.equals("2")) {							
							nv.nhap();
							danhsach.add(nv);
						}						
					} break;
			case 2: System.out.println("Bạn muốn xuất cán bộ nào: ");
					System.out.println("1. Giảng viên \n2. Nhân viên");
					int loaiCanBo = Integer.parseInt(sc.nextLine());
					
						if(loaiCanBo == 1) {
							System.out.println("Bạn muốn xuất giảng viên theo khoa nào: ");
								String khoa = sc.nextLine();
								for(CanBo cb:danhsach) {
										GiangVien gv2 = (GiangVien) cb;
										if(gv2.getKhoa().equals(khoa)) {
											gv2.xuat();
										
									}
								}
						}
						else if(loaiCanBo == 2) {
							System.out.println("Bạn muốn xuất nhân viên theo phòng ban nào: ");
								String phongBan = sc.nextLine();
								for(CanBo cb:danhsach) {
									
										NhanVien nv2 = (NhanVien) cb;
										if(nv2.getPhongBan().equals(phongBan)) {
											nv2.xuat();
										}								
							} 
						} 
					break;
			case 3:
				
			double tongLuong = 0;
			for (CanBo cb : danhsach) {
				tongLuong += cb.tinhLuong();
			}
			System.out.println("Tong so luong truong phai tra: " + tongLuong);
			break;
			
			case 0: 
				break;
			}
		}
	}
}


		

		
			


