package unit4.tiendien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class QLBL  {

	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Nhap thong tin go dan");
			System.out.println("2. Hien thi thong tin");
			System.out.println("3. Bien lai co tien thu nhieu nhat");
			System.out.println("4. Sap xep bien lai tang dan");
			System.out.println("0. Ket thuc chuong trinh");
			System.out.print("Chon thao tac");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			ArrayList<BienLai> listBl = new ArrayList<BienLai>();
			switch(choice) {
				case 1: System.out.println("Nhap so gia dinh: ");
				int n=Integer.parseInt(sc.nextLine());
					for(int i = 0; i < n; i++) {
						System.out.println("Nhap thong tin cua ho dan thu " + (i + 1) + ": ");
						BienLai bl= new BienLai();
						bl.nhap();
						listBl.add(bl);	
					}
				case 2:System.out.println("Thong tin bien lai cua cac ho gia dinh: ");
					for(int i = 0; i < listBl.size(); i++) {
						System.out.println("Thong tin bien lai cua ho gia dinh thu " + (i + 1) + ": ");
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

			        System.out.println("Sap xep tang dan ");
			        for (int i = 0; i < listBl.size(); i++) {
			            System.out.println("Ten: " + listBl.get(i).hoTen + " ThanhToan: " + listBl.get(i).getThanhToan());
			        }
					
				case 0:
					break;
		}
		}
	}
	
}
