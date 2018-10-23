package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ATM_Main {
	static void saveID(ArrayList<Users> idList)  {
		try {
		FileOutputStream fos1 = new FileOutputStream("ID.dat");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(idList);
		oos1.close();
		fos1.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	static ArrayList<Users> outputID()  {
		try {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<Users> user = (ArrayList<Users>) ois.readObject();
			ois.close();
			fis.close();
			return user;
		}
		catch (Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	static void saveTheTu(ArrayList<TheTu> list) {
		try {
			FileOutputStream fos = new FileOutputStream("TheTu.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
			}
		catch (Exception e) {
			System.out.println(e);
		}
		}
	static ArrayList<TheTu> outputTheTu()  {	
		try {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("TheTu.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<TheTu> the = (ArrayList<TheTu>) ois.readObject();
			ois.close();
			fis.close();
			return the;
		}		catch (Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	static void saveGiaoDich(ArrayList<GiaoDich> list) {
		try {
			FileOutputStream fos = new FileOutputStream("GiaoDich.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static ArrayList<GiaoDich> outputGiaoDich() {
		try {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			fis = new FileInputStream("GiaoDich.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<GiaoDich> gd = (ArrayList<GiaoDich>) ois.readObject();
			ois.close();
			fis.close();
			return gd;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		ATM_Main atm = new ATM_Main();
		
		ArrayList<Users> listUser = atm.outputID();
		ArrayList<TheTu> listTheTu = atm.outputTheTu();
		ArrayList<GiaoDich> listGiaoDich = atm.outputGiaoDich();
		while (true) {
			System.out.println("1. Tạo tài khoản thẻ: ");
			System.out.println("2. Đăng nhập: ");
			System.out.println("Mời chọn: ");
			int mChon = Integer.parseInt(sc.nextLine());
			switch (mChon) {
			case 1: 				
				Users user = new Users();
				TheTu the = new TheTu();
				
				user.nhap();
				the.setMaSo(user.getMaSo());
				the.nhap();
				user.xuat();
				the.xuat();
				
				listUser.add(user);
				listTheTu.add(the);
				
				break;
			case 2: 
				
				System.out.println("Nhập số thẻ: ");
				String soThe = sc.nextLine();
				System.out.println("Mã PIN: ");
				String pin = sc.nextLine();
				for (TheTu thetu: listTheTu) {
				if (thetu.dangNhap(soThe, pin)) {
					System.out.println("Đăng nhập thành công: ");
				while (true) {
					System.out.println("1. Rút tiền: ");
					System.out.println("2. Xem thông tin tài khoản: ");
					System.out.println("3. Xem lịch sử giao dịch: ");
					System.out.println("4. Đăng xuất: ");
					int mChon2 = Integer.parseInt(sc.nextLine());
					switch (mChon2) {
					case 1:
						
						System.out.print("Nhập số tiền cần rút: ");
						double tienRut = Double.parseDouble(sc.nextLine());
						for (Users users: listUser) {
						if (soThe.equals(users.getMaSo())) {
							double soDuHienTai = users.getSoDu();
							double soDuMoi = soDuHienTai - tienRut;
							users.setSoDu(soDuMoi);
							
						    Calendar c = Calendar.getInstance();
						    System.out.println("Thông tin giao dịch: ");
						    GiaoDich gd = new GiaoDich();
						    gd.setHoTen(users.getHoTen());
						    gd.setMaSo(users.getMaSo());
						    gd.setSoTien(tienRut);
						    gd.setThoiGian(showCalendar(c));
						    listGiaoDich.add(gd);
						}		
						}
						break;
					case 2:
						for (Users users2: listUser) {
							users2.xuat();
						}
						break;
					case 3:
						for (GiaoDich gd2: listGiaoDich) {
							gd2.xuat();
						}
						break;
					case 4:  
						System.out.println("Đã đăng xuất!!!");
						atm.saveID(listUser);
						atm.saveTheTu(listTheTu);
						atm.saveGiaoDich(listGiaoDich);
						break;
					}
					if (mChon2==4) break;
				}
				
				}
				
				else {
					System.out.println("Đăng nhập lỗi!!!");
				}
				}
				break;
			case 3: 
				atm.saveID(listUser);
				atm.saveTheTu(listTheTu);
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
