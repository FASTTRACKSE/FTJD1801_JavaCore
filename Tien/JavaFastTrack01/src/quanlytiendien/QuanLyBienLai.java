package quanlytiendien;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBienLai {
	
	public static void main(String args[]) {
		BienLai bl = new BienLai();
		ArrayList<BienLai> listBienLai = new ArrayList<BienLai>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----Quản Lý Tiền Điện----");
			System.out.println("-------------------------------------------");
			System.out.println("1. Nhập vào thông tin cho các hộ sử dụng điện");
			System.out.println("2. Hiển thị thông tin biên lai");
			System.out.println("3. Tính số tiền điện phải trả cho mỗi biên lai");
			System.out.println("4. Xuất biên lai có số tiền thu nhiều nhất");
			System.out.println("5. Sắp xếp biên lai tăng dần theo số tiền phải trả");
			System.out.println("6. Tìm hộ sử dụng điện nhiều nhất");
			System.out.println("-------------------------------------------");
			System.out.print("Mời chọn một: ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch(mChon) {
			case 1: System.out.println("Bạn muốn nhập bao nhiêu biên lai: ");
					int soLuong = Integer.parseInt(sc.nextLine());
					for(int i = 0; i < soLuong; i++) {
						BienLai bl2 = new BienLai();
						bl2.nhap();
						listBienLai.add(bl2);
					} break;
			case 2: if(bl.getTienDien() != 0 ) {
						for(int i = 0; i < listBienLai.size(); i++) {
							bl = listBienLai.get(i);
							bl.xuat();
							System.out.println("Số tiền phải trả: "+bl.getTienDien());
						}
					}
					else {
						for(int i = 0; i < listBienLai.size(); i++) {
							bl = listBienLai.get(i);
							bl.xuat();
						}
					} break;
			case 3: for(int i = 0; i < listBienLai.size(); i++) {
						bl = listBienLai.get(i);
						bl.xuat();
						bl.setTienDien(bl.tinhTienDien());
						System.out.println("Số tiền phải trả: "+bl.getTienDien());
					} break;
			case 4: BienLai bl3 = new BienLai();
					bl3.setTienDien(0);
					for(int i = 0; i < listBienLai.size(); i++) {
							if(listBienLai.get(i).getTienDien() > bl3.getTienDien()) {
								bl3 = listBienLai.get(i);
							}						
					}
					bl3.xuat(); 
					System.out.println("Số tiền phải trả: "+bl3.getTienDien()); break;
			case 5: BienLai bl4 = new BienLai();
					for(int i = 0; i < listBienLai.size()-1; i++) {
						for(int j = i + 1; j < listBienLai.size(); j++){
							if(listBienLai.get(i).getTienDien()>listBienLai.get(j).getTienDien()) {
								bl4 = listBienLai.get(i);
								listBienLai.set(i, listBienLai.get(j));
								listBienLai.set(j, bl4);
							}
						}
					} break;
			case 6: BienLai bln = new BienLai();
					ArrayList<BienLai> dsBienLai = new ArrayList<BienLai>();
					boolean boo = false;
					dsBienLai.add(listBienLai.get(0));
					for(int i = 1; i < listBienLai.size(); i++) {
						for(int j = 0; j < dsBienLai.size(); j++) {
							if(listBienLai.get(i).getHoTen().equals(dsBienLai.get(j).getHoTen())) {
								BienLai bl5 = new BienLai();
								bl5.setHoTen(dsBienLai.get(j).getHoTen());
								bl5.setSoNha(dsBienLai.get(j).getSoNha());
								bl5.setMaSoCongTo(dsBienLai.get(j).getMaSoCongTo());
								bl5.setChiSoCu(dsBienLai.get(j).getChiSoCu());
								bl5.setChiSoMoi(dsBienLai.get(j).getChiSoMoi());
								bl5.setTienDien(dsBienLai.get(j).getTienDien()+listBienLai.get(i).getTienDien());
								dsBienLai.set(j, bl5);
								boo = true;
							}							
						}
						if(boo == false) {
							dsBienLai.add(listBienLai.get(i));
						}						
					}
					for(int i = 0; i < dsBienLai.size(); i++) {
						System.out.println("Tên chủ hộ: "+dsBienLai.get(i).getHoTen()+"  |  Tổng tiền điện: "+dsBienLai.get(i).getTienDien());						
					}
					for(int i = 0; i < dsBienLai.size() - 1; i++) {
						for(int j = i + 1; j < dsBienLai.size(); j++) {
							if(dsBienLai.get(i).getTienDien() > dsBienLai.get(j).getTienDien()) {
								bln = dsBienLai.get(i);
							}
							else {
								bln = dsBienLai.get(j);
							}
						}
					}
					System.out.println("Hộ sử dụng nhiều điện nhất: \nTên chủ hộ: "+bln.getHoTen()+"  |  Tổng tiền điện: "+bln.getTienDien());
					break;
			default: System.out.println("Mục chọn không có trong menu!!!"); break;
			}
			if(mChon == 0) {
				break;
			}
		}		
		
		
		
	}
}
