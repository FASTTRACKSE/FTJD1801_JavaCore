package atm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Users> idList = Save.output();
		ArrayList<TheTu> theTuList = Save.output1();
		ArrayList<GiaoDich> gdList = Save.output2();
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: 
				
				Users us = new Users();
				TheTu tt = new TheTu();
				
				us.nhapID();
				tt.setMaThe(us.getMaThe());
				tt.nhapTheTu();
				us.xuat();
				tt.xuat();
				
				idList.add(us);
				theTuList.add(tt);
				
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
						for (Users user1: idList) {
						if (soThe.equals(user1.getMaThe())) {
							double soDuHienTai = user1.getSoDuTK();
							double soDuMoi = soDuHienTai - tienRut;
							user1.setSoDuTK(soDuMoi);
							
						    Calendar c = Calendar.getInstance();
						    System.out.println("Thong tin giao dich");
						    GiaoDich gd = new GiaoDich();
						    gd.setTenTK(user1.getTenTK());
						    gd.setMaThe(user1.getMaThe());
						    gd.setTienGiaoDich(tienRut);
						    gd.setThoiGian(showCalendar(c));
						    gdList.add(gd);
						}		
						}
						break;
					case 2:
						for (Users id: idList) {
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
						Save.luuID(idList);
						Save.luuTheTu(theTuList);
						Save.luuGiaoDich(gdList);
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
				Save.luuID(idList);
				Save.luuTheTu(theTuList);
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
