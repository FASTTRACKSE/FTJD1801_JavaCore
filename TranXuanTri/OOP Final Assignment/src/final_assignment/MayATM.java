package final_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MayATM  {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		ArrayList<TheTu> theTuList = new ArrayList<TheTu>();
//		ArrayList<User> idList= new ArrayList<User>();
//		ArrayList<GiaoDich> gdList = new ArrayList<GiaoDich>();
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<User> idList = LuuFile.output();
		ArrayList<TheTu> theTuList = LuuFile.output1();
		ArrayList<GiaoDich> gdList = LuuFile.output2();
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: 
				//ma the: 00000000000000
				User user = new User();
				TheTu the = new TheTu();
				
				//tao thong tin
				user.nhapID();
				the.setMaThe(user.getId());
				the.nhapTheTu();
				user.xuat();
				the.xuat();
				//luu vao list
				idList.add(user);
				theTuList.add(the);
				
				//user.output();
				break;
			case 2: 
				
				System.out.println("nhap so the");
				String soThe = sc.nextLine();
				System.out.println("nhap ma pin");
				String pin = sc.nextLine();
				for (TheTu the1: theTuList) {
				if (the1.dangNhap(soThe, pin)) {
					System.out.println("----Dang nhap thanh cong----");
				while (true) {
					System.out.println("1. Rut tien: ");
					System.out.println("2. Xem thong tin tai khoan: ");
					System.out.println("3. Xem lich su giao dich: ");
					System.out.println("4. Dang xuat: ");
					int choice1 = Integer.parseInt(sc.nextLine());
					switch (choice1) {
					case 1:
						
						System.out.print("Nhap so tien can rut: ");
						double tienRut = Double.parseDouble(sc.nextLine());
						for (User user1: idList) {
						if (soThe.equals(user1.getId())) {
							double soDuHienTai = user1.getSoDuTaiKhoan();
							double soDuMoi = soDuHienTai - tienRut;
							user1.setSoDuTaiKhoan(soDuMoi);
							
						    Calendar c = Calendar.getInstance();
						    System.out.println("Thong tin giao dich");
						    GiaoDich gd = new GiaoDich();
						    gd.setTenTaiKhoan(user1.getTenTaiKhoan());
						    gd.setId(user1.getId());
						    gd.setTienGiaoDich(tienRut);
						    gd.setThoiGian(showCalendar(c));
						    gdList.add(gd);
						}		
						}
						break;
					case 2:
						for (User id: idList) {
							id.xuat();
						}
						break;
					case 3:
						for (GiaoDich gd1: gdList) {
							gd1.xuat();
						}
						break;
					case 4:  
						System.out.println("Dang xuat thanh cong");
						LuuFile.luuID(idList);
						LuuFile.luuTheTu(theTuList);
						LuuFile.luuGiaoDich(gdList);
						break;
					}
					if (choice1==4) break;
				}
				
				}
				
				else {
					System.out.println("Dang nhap that bai");
				}
				}
				break;
			case 3: 
				break;
			}

		}

	}
	  public static String showCalendar(Calendar calendar) {
	      int year = calendar.get(Calendar.YEAR);
	      int month = calendar.get(Calendar.MONTH);
	      int day = calendar.get(Calendar.DAY_OF_MONTH);
	      int hour = calendar.get(Calendar.HOUR_OF_DAY);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      return  " " + year + "-" + (month + 1) + "-" + day + " "
	              + hour + ":" + minute + ":" + second;
	  }
}
