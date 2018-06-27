package unit_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import unit_4.SinhVienBiz;
import unit_4.SinhVienFPT;
import unit_4.SinhVienIT;

public class QuanLySinhVien {
	public static void main(String[] args) {
		ArrayList <SinhVienFPT> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println(" ===============MENU==============");
		System.out.println(" 1 : nhap thong tin sinh vien .");
		System.out.println(" 2 : xuat toan bo thong tin sinh vien .");
		System.out.println(" 3 : xuat thong tin sinh vien co hoc luc gioi .");
		System.out.println(" 4 : xuat danh sach sv theo diem . ");
		int luachon ;
		do {
		System.out.println("-----------------------------------");
		System.out.print(" moi ban nhap lua chon :");
		luachon = Integer.parseInt(sc.nextLine());
		
		switch(luachon) {
		case 1 : {
			System.out.println(" nhap vao so luong sinh vien : ");
			int soluong = Integer.parseInt(sc.nextLine());
			for(int i=0 ; i<soluong ; i++) {
				System.out.print(" sinh vien nghanh nao : ");
				String nghanh = sc.nextLine();
				if(nghanh.equals("it") || nghanh.equalsIgnoreCase("it") ) {  // tien hanh kiem tra 
					SinhVienIT sv = new SinhVienIT(); // tao doi tuong moi
					sv.nhap();       // tien hnah nhap
					list.add(sv);    // tien hanh luu 
				}
				else if(nghanh.equals("biz") || nghanh.equalsIgnoreCase("biz") ) {
					SinhVienBiz sv = new SinhVienBiz(); 
					sv.nhap();       
					list.add(sv);    
				}
				else {
					System.out.println(" trong co nghanh ban vua nhap !");
				}
			}
			
			break;
		}
		case 2 :{  
			//   xuat toan bo sinh  vien co trong danh sach
			System.out.println("== TOAN BO SINH VIEN CO TRONG DANH SACH ==");
			for(int i =0; i<list.size(); i++) {
				list.get(i).xuat();
			}
			break;
		}
		case 3 :{
			System.out.println("== DANH SACH SINH VIEN GIOI ==");
			for(int i = 0 ; i<list.size() ; i++) {
				if(list.get(i).gethocLuc().equals(" Gioi ")) {
					list.get(i).xuat();
				}
			break;
				
			}
		}
		case 4 :{
			Collections.sort(list, (SinhVienFPT sv1 , SinhVienFPT sv2 ) ->{  
				if(sv2.getDiem() < sv2.getDiem()){
					return 1;
				}
				else {
					if(sv1.getDiem()==sv2.getDiem()) {
						return 0;
					}
					else {
						return -1;
					}
				}
			});
			
			for(int i =0; i < list.size(); i++) {
				list.get(i).xuat();
				System.out.println("");
				
			}
			break;
		}
		case 5 :{
			System.out.println(" ban da toat chuong trinh !");
			break;
		}
		
		}
		
	}while(luachon !=5);
	}

	
	

}
