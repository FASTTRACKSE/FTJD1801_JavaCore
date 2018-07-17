package atm;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
public class CayATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TheTu> listtheTu = new ArrayList<TheTu>();
		ArrayList<Users> listid = new ArrayList<Users>();
		ArrayList<GiaoDich> listgd = new ArrayList<GiaoDich>();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Tao tai khoan moi: ");
			System.out.println("2. Dang nhap tai khoan: ");
			System.out.println("Nhap thao tac: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: 
				//ma the: 00000000000000
				Users user = new Users();
				TheTu the = new TheTu();
				
				//tao thong tin
				user.nhap();
				the.setMaTK(user.getId());
				the.nhap();
				user.xuat();
				the.xuat();
				//luu vao list
				listid.add(user);
				listtheTu.add(the);
				
				//user.output();
				break;
			case 2: 
				
				System.out.println("nhap so the");
				String soThe = sc.nextLine();
				System.out.println("nhap ma pin");
				String pin = sc.nextLine();
				for (TheTu the1: listtheTu) {
				if (the1.login(soThe, pin)) {
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
						for (Users user1: listid) {
						if (soThe.equals(user1.getId())) {
							double soDuHienTai = user1.getSoDu();
							double soDuMoi = soDuHienTai - tienRut;
							user1.setSoDu(soDuMoi);
							
						    Calendar c = Calendar.getInstance();
						    System.out.println("Thong tin giao dich");
						    GiaoDich gd = new GiaoDich();
						    gd.setId(user1.getId());
						    gd.setSoTien(tienRut);
						    gd.setTgian(showCalendar(c));
						    listgd.add(gd);
						}		
						}
						break;
					case 2:
						for (Users id: listid) {
							id.xuat();
						}
						break;
					case 3:
						for (GiaoDich gd1: listgd) {
							gd1.xuat();
						}
						break;
					case 4:  
						System.out.println("Dang xuat thanh cong");
						try {
							LuuFile.luuID(listid);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							LuuFile.luuTheTu(listtheTu);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							LuuFile.saveGiaoDich(listgd);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
				try {
					LuuFile.luuID(listid);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					LuuFile.luuTheTu(listtheTu);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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


