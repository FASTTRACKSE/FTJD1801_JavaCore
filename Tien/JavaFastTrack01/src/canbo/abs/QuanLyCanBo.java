package canbo.abs;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyCanBo {

	public static void main(String[] args) {
		ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>(); 
		Scanner sc = new Scanner(System.in);
		GiangVien gv = new GiangVien();
		NhanVien nv = new NhanVien();
		while(true) {
			System.out.println("-----Quản Lý Cán Bộ----");
			System.out.println("-------------------------------------------");
			System.out.println("1. Nhập thông tin danh sách cán bộ trong trường");
			System.out.println("2. Xuất danh sách cán bộ theo khoa, hoặc theo phòng ban");
			System.out.println("3. Tổng số lương trường phải trả cho cán bộ");
			System.out.println("4. Sắp xếp cán bộ theo lương, nếu lương bằng thì sắp theo tên");			
			System.out.println("0. Thoát");
			System.out.println("-------------------------------------------");
			System.out.print("Mời chọn một: ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch(mChon) {
			case 1: System.out.println("Bạn muốn nhập cán bộ loại nào: ");
					System.out.println("1. Giảng viên \n2. Nhân viên");
					String loaiSV = sc.nextLine();
					System.out.println("Bạn muốn nhập bao nhiêu cán bộ: ");
					int soLuong = Integer.parseInt(sc.nextLine());					
					for(int i = 0; i < soLuong; i++) {
						if(loaiSV.equals("1")) {							
							gv.nhap();
							dsCanBo.add(gv);
						}else if(loaiSV.equals("2")) {							
							nv.nhap();
							dsCanBo.add(nv);
						}						
					} break;
			case 2: System.out.println("Bạn muốn xuất cán bộ nào: ");
					System.out.println("1. Giảng viên \n2. Nhân viên");
					int loaiCanBo = Integer.parseInt(sc.nextLine());
					switch(loaiCanBo) {
						case 1: System.out.println("Bạn muốn xuất giảng viên theo khoa nào: ");
								String khoa = sc.nextLine();
								for(CanBo list:dsCanBo) {
									if(list instanceof GiangVien) {
										GiangVien gv2 = (GiangVien) list;
										if(gv2.getKhoa().equals(khoa)) {
											gv2.xuat();
										}
									}
								} break;
						case 2: System.out.println("Bạn muốn xuất nhân viên theo phòng ban nào: ");
								String phongBan = sc.nextLine();
								for(CanBo list:dsCanBo) {
									if(list instanceof NhanVien) {
										NhanVien nv2 = (NhanVien) list;
										if(nv2.getPhongBan().equals(phongBan)) {
											nv2.xuat();
										}
									}
								} break;
						case 0: break;
						} 
					break;
			
			}
			if(mChon == 0) {
				break;
			}
		}

	}

}
