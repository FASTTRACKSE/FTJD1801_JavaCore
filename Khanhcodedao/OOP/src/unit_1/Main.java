package unit_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <BienLai> danhsach = new ArrayList<>();
		int luachon =0;
		System.out.println(" 1 : nhap vao thong tin n ho dan .");
		System.out.println(" 2 : hien thi toan bo ho dan co trong danh sach .");
		System.out.println(" 3 : sap xep bien lai tang dan theo so tien tra .");
		System.out.println(" 4 : thoat chuong trinh .");
	do {
		System.out.println("---------------------------------");
		System.out.println(" moi ban nhap lua chon : ");
		
		luachon = Integer.parseInt(sc.nextLine());
		
		
		if(luachon == 1) { 
			System.out.println(" nhap so luong ho dan : ");
			int n = Integer.parseInt(sc.nextLine());
			for(int i =0 ; i<n; i++) {
				BienLai hd = new BienLai();
				System.out.println(" thong tin ho dan thu : "+(i+1));
				hd.nhap();
				danhsach.add(hd);
			}
		}
		if( luachon == 2 ) {
			for(int i = 0 ; i<danhsach.size(); i++) {
			danhsach.get(i).xuat();
			System.out.println("----------------------");
			}
		}
		else if (luachon == 3) {
			Collections.sort(danhsach,( BienLai hd1, BienLai hd2) ->{
					
						if (hd1.getSoTienTra() > hd2.getSoTienTra()) {
							return 1;
						}
						else if ((hd1.getSoTienTra() == hd2.getSoTienTra())) {
							return 0;
						}
						else {
							return -1;
				}
			});
			for(int i = 0; i<danhsach.size() ; i++) {
				danhsach.get(i).xuat();
			}
			
		}
		if(luachon ==4 ) {
			System.out.println(" ban da thoat chuong trinh .");
		
		}
	

	}while(luachon !=4);
	}
}

