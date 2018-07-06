package final_assignment;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class MayATM implements Serializable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ID menu = new ID();
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			Scanner sc1 = new Scanner(System.in);
			int choice = Integer.parseInt(sc1.nextLine());
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
				while (true) {
					System.out.println("1. Rut tien: ");
					System.out.println("2. Xem thong tin tai khoan: ");
					System.out.println("3. Xem lich su giao dich: ");
					int choice1 = Integer.parseInt(sc1.nextLine());
					switch (choice1) {
					case 1:
						System.out.print("Nhap so tien can rut: ");
						double tienRut = Double.parseDouble(sc1.nextLine());
						menu1.rutTien(tienRut, the1.maThe);
					    Calendar c = Calendar.getInstance();
					    System.out.println("Thong tin giao dich");
					    giaoDich gd = new giaoDich();
					    gd.giaoDich(tienRut, menu1.showCalendar(c), the1.maThe);
					    gd.output();
						break;
					case 2:
						menu.output();
						break;
					case 3:
						giaoDich gd1 = new giaoDich();
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
