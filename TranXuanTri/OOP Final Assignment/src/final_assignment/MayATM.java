package final_assignment;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class MayATM implements Serializable {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ID menu = new ID();
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: 
				//ma the: 00000000000000
				menu.taoTaiKhoan();
				menu.output();
				break;
			case 2: 
				DangNhap menu1 = new DangNhap();
				TheTu the1 = new TheTu();
				the1.taoTheTu();
				boolean check = menu1.dangNhap(the1.maThe,the1.maPIN);
				if (check==true) {
					System.out.println("----Dang nhap thanh cong----");
				while (true) {
					System.out.println("1. Rut tien: ");
					System.out.println("2. Xem thong tin tai khoan: ");
					System.out.println("3. Xem lich su giao dich: ");
					int choice1 = Integer.parseInt(sc.nextLine());
					switch (choice1) {
					case 1:
						System.out.print("Nhap so tien can rut: ");
						double tienRut = Double.parseDouble(sc.nextLine());
						menu1.rutTien(tienRut, the1.maThe);
					    Calendar c = Calendar.getInstance();
					    System.out.println("Thong tin giao dich");
					    GiaoDich gd = new GiaoDich();
					    gd.giaoDich(tienRut, menu1.showCalendar(c), the1.maThe);
					    gd.output();
						break;
					case 2:
						menu.output();
						break;
					case 3:
						GiaoDich gd1 = new GiaoDich();
						gd1.output();
						break;
					}
				}
				}
				else {
					System.out.println("Dang nhap that bai");
				}
				break;
			case 3: 
				break;
			}

		}

	}


}
