package final_assignment;

import java.io.*;
import java.util.Scanner;

public class MayATM implements Serializable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		KhoiTaoTaiKhoan menu = new KhoiTaoTaiKhoan();
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			Scanner sc1 = new Scanner(System.in);
			int choice = Integer.parseInt(sc1.nextLine());
			switch (choice) {
			case 1: 
				//ma the: 00000000000000
		//		menu.theTu();
				menu.ID();
				menu.xuat();
				break;
			case 2: 
	//			menu.dangNhap();
				while (true) {
					
					System.out.println("1. Rut tien: ");
					System.out.println("2. Xem thong tin tai khoan: ");
					int choice1 = Integer.parseInt(sc1.nextLine());
					switch (choice1) {
					case 1:
						System.out.print("Nhap so tien can rut: ");
						//double tienRut = Double.parseDouble(sc1.nextLine());
						
					}
				}
			case 3: 
		//		menu.dangNhap();
				break;
			}
		}

	}


}
