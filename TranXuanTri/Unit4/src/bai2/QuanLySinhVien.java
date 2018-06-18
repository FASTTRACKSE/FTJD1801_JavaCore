package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien extends SinhVienIT {
	public void nhapt() {
		super.nhap();
		
	}
	public QuanLySinhVien(String hoTen, String nganh) {
		super(hoTen, nganh);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<QuanLySinhVien> sinhVienList = new ArrayList<QuanLySinhVien>();
		while (true) {
			System.out.println("-------");
			System.out.println("1. Nhap danh sach sinh vien");
			System.out.println("2. Xuat thong tin danh sach sinh vien");
			System.out.println("3. Xuat danh sach sinh vien co hoc luc gioi");
			System.out.println("4. Sap xep danh sach sinh vien theo diem");
			System.out.println("5. Ket thuc");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("nhap so luong sinh vien");
				int soLuong = Integer.parseInt(sc.nextLine());
				for (int i=0;i<soLuong;i++) {
					
				}
			}
			case 2: {
				System.out.println("You delete a student");
			} case 3: {
				System.out.println("Exit");
				break;
			}
			}
		}
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
