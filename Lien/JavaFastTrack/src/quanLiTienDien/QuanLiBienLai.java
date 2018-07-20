package quanLiTienDien;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiBienLai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				BienLai bl = new BienLai();
				ArrayList<BienLai> list = new ArrayList<BienLai>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int mC;
			System.out.println("----------");
			System.out.println("QUẢN LÍ TIỀN ĐIỆN");
			System.out.println("1. Nhập vào các thông tin cho n hộ sử dụng điện");
			System.out.println("2. Hiển thị thông tin về các biên lai đã nhập");
			System.out.println("3. Tính số tiền điện cho mỗi hộ dân");
			System.out.println("4. Tìm biên lai có tiền thu nhiều nhất");
			System.out.println("5. Sắp xếp biên lai tăng dần theo số tiền phải trả");
			System.out.println("6. Tìm hộ sử dụng điện nhiều nhất");
			System.out.println("----------");
			System.out.println("Mời bạn chọn: ");
			mC = Integer.parseInt(sc.nextLine());
			switch(mC) {
			case 1: System.out.println("Bạn muốn nhập bao nhiêu biên lai: ");
			int soLuong = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < soLuong; i++) {
				BienLai bl2 = new BienLai();
				bl2.input();
				list.add(bl2);
			} break;
			case 2: 
				for(int i = 0; i < list.size(); i++) {
					bl = list.get(i);
					bl.output();
				} break;	
			
			case 3: 
				for(int i = 0; i < list.size(); i++) {
					bl = list.get(i);
					bl.output();
					bl.setTienDien(bl.tinhTienDien());
					System.out.println("Số tiền phải trả: "+bl.getTienDien());
				} break;
			case 4:
					BienLai bl3 = new  BienLai();
					bl3.setTienDien(0);
					for(int i = 0;i< list.size();i++) {
						if(list.get(i).getTienDien() > bl3.getTienDien()) {
							bl3 = list.get(i);
						}
					}
					bl3.output();break;
			case 5:
				BienLai bl4 = new  BienLai();
				for(int i = 0;i< list.size() - 1;i++) {
					for(int j = i+1; j<list.size(); j ++) {
						if(list.get(i).getTienDien()>list.get(j).tinhTienDien()) {
							bl4 = list.get(i);
							list.set(i, list.get(j));
							list.set(j, bl4);
						}
					}
				}break;
			
			default: System.out.println("kết thúc:");
		
				
			}
				
		

	}
	}

}
