package unit4.tiendien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class QLBL  {

	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Nhập Thông tin Hộ Dân");
			System.out.println("2. Hiển Thị Thông Tin");
			System.out.println("3. Biên Lai có tiền thi tiền thu nhiều nhất");
			System.out.println("4. Sấp xếp biên lai tăng dần");
			System.out.println("0. Kết thúc chương trình");
			System.out.print("Chọn thao tác");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			ArrayList<BienLai> listBl = new ArrayList<BienLai>();
			switch(choice) {
				case 1: System.out.println("Nhập số gia đình: ");
				int n=Integer.parseInt(sc.nextLine());
					for(int i = 0; i < n; i++) {
						System.out.println("Nhập thông tin biên lai của hộ gia đình thứ " + (i + 1) + ": ");
						BienLai bl= new BienLai();
						bl.nhap();
						listBl.add(bl);	
					}
				case 2:System.out.println("Thông tin biên lai của các hộ gia đình: ");
					for(int i = 0; i < listBl.size(); i++) {
						System.out.println("Thông tin biên lai hộ gia đình thứ " + (i + 1) + ": ");
						listBl.get(i).xuat();
					}
				case 3:
					BienLai bl3= new BienLai();
					bl3.setThanhToan(0);
					for(int i=0;i<listBl.size();i++) {
						if(listBl.get(i).getThanhToan() > bl3.getThanhToan()) {
												bl3 = listBl.get(i);
											}
						bl3.xuat();break;
					}
					
				case 4:
					Collections.sort(listBl, new Comparator<BienLai>() {
			            public int compare(BienLai bl1, BienLai bl2) {
			                if (bl1.getThanhToan() > bl2.getThanhToan()) {
			                    return 1;
			                } else {
			                    if (bl1.getThanhToan() == bl2.getThanhToan()) {
			                        return 0;
			                    } else {
			                        return -1;
			                    }
			                }
			            }

						
			        });

			        System.out.println("Danh sách sắp xếp biên lai tăng dần theo số tiền phải trả ");
			        for (int i = 0; i < listBl.size(); i++) {
			            System.out.println("Tên: " + listBl.get(i).hoTen + " ThanhToan: " + listBl.get(i).getThanhToan());
			        }
					
				case 0:
					break;
		}
		}
	}
	
}
