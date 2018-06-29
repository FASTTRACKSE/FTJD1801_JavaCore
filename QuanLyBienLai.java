package bienlai;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBienLai {

	public static void main(String[] args) {
		
			BienLai bl = new BienLai();
			ArrayList<BienLai> danhsach = new ArrayList<BienLai>();
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("-------");
				System.out.println("1. Nhap thong tin bien lai");
				System.out.println("2. Hien thi thong tin bien lai");
				System.out.println("3. tinh so tien phai tra cho moi bien lai");
				System.out.println("4. Hien thi bien lai co tien thu nhieu nhat");
				System.out.println("5. Hien thi khach hang tieu ton nhieu nhat");
				System.out.println("0. Exit");
				System.out.println("Choice ");
				Scanner sc1 = new Scanner(System.in);
				int choice = Integer.parseInt(sc1.nextLine());
				
				switch(choice) {
				case 1: System.out.println("so luong bien lai: ");
				int soLuong = Integer.parseInt(sc1.nextLine());
				for(int i = 0; i < soLuong; i++) {
					BienLai bl2 = new BienLai();
					bl2.nhap();
					danhsach.add(bl2);
				} break;
				case 2: if(bl.getTienDien() != 0 ) {
					for(int i = 0; i < danhsach.size(); i++) {
						bl = danhsach.get(i);
						bl.xuat();
						System.out.println("Số tiền phải trả: "+bl.getTienDien());
					}
				}
				else {
					for(int i = 0; i < danhsach.size(); i++) {
						bl = danhsach.get(i);
						bl.xuat();
					}
				} break;
				
				case 3:
				for(int i = 0; i < danhsach.size(); i++) {
					bl = danhsach.get(i);
					bl.xuat();
					bl.setTienDien(bl.tinhTienDien());
					System.out.println("Số tiền phải trả: "+bl.getTienDien());
				} break;
				
				case 4:
					BienLai bl1 = new BienLai();
				bl1.setTienDien(0);
				for(int i = 0; i < danhsach.size(); i++) {
						if(danhsach.get(i).getTienDien() > bl1.getTienDien()) {
							bl1 = danhsach.get(i);
						}						
				}
				bl1.xuat(); 
				System.out.println("Bien lai cao nhat: "+bl1.getTienDien()); 
				break;
				
				
				default: System.out.println("không có trong menu"); 
				break;
				
				case 0: 
					break;
			
}
}
	}
}