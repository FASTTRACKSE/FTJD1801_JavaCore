package final_assignment;

import java.io.*;
import java.util.Scanner;

public class MayATM implements Serializable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		KhoiTaoTaiKhoan menu = new KhoiTaoTaiKhoan();
		while (true) {
			System.out.println("Nhap thao tac: ");
			Scanner sc1 = new Scanner(System.in);
			int choice = Integer.parseInt(sc1.nextLine());
			switch (choice) {
			case 1: 
				menu.theTu();
				break;
			case 2: 
				menu.ID();
				break;
			case 3: 
				menu.dangNhap();
				break;
			}
		}

	}


}
