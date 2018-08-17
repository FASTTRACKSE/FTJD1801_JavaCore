package baitapatm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class ATMManager {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<User> listUser = new ArrayList<User>();
		ArrayList<TheTu> listTheTu = new ArrayList<TheTu>();
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----Menu----");
			System.out.println("1.Them thong tin tai khoan");
			System.out.println("2.Dang nhap");
			System.out.println("3.Luu file");
			System.out.println("4.Doc file");
			System.out.println("");
			int choose = Integer.parseInt(sc.nextLine());
			if(choose == 1) {
				User usr = new User();
				usr.nhap();
				listUser.add(usr);
				
				TheTu theTu = new TheTu();
				theTu.setId(usr.getId());
				theTu.nhap();
				listTheTu.add(theTu);
				
			}else if(choose == 2) {
				System.out.println("nhap tai khoan");
				String maThe = sc.nextLine();
				System.out.println("nhap ma pin");
				String pin = sc.nextLine();
				for(TheTu thetu : listTheTu) {
					String maPin = thetu.getPIN();
					String soThe = thetu.getId();
					if(thetu.dangNhap(maThe,pin)) {
						while(true) {
							System.out.println("1. rut tien");
							System.out.println("2. xem sp du");
							System.out.println("3. xem lich su giao dich");
							System.out.println("4. tro ve menu chinh");
							int subchoose = Integer.parseInt(sc.nextLine());
							if(subchoose == 1) {
								System.out.println("so tien rut");
								int soTienrut = Integer.parseInt(sc.nextLine());
								
								for(User user : listUser) {
									if(maThe.equals(user.getId())) {
								
								int soduhientai =  user.getSoDu();
								int sodumoi = soduhientai - soTienrut;
								user.setSoDu(sodumoi);
								
								GiaoDich giaoDich = new GiaoDich();
								giaoDich.setId(user.getId());
								Date date = new Date();
								giaoDich.setThoiGian(date);
								giaoDich.setSoTienGiaoDich(soTienrut);
								
								listGiaoDich.add(giaoDich);
								}	
								}	
							}else if(subchoose == 2) {
								for(User user : listUser) {
									if(maThe.equals(user.getId())) {
										System.out.println("So du la "+ user.getSoDu());	
									}
									
							
								}
							}else if(subchoose == 3) {
								for(GiaoDich gd : listGiaoDich) {
									if(maThe.equals(gd.getId())){
										System.out.println(gd.getMoTaGiaoDich() + gd.getThoiGian() + gd.getSoTienGiaoDich());
									}
								}
								
							}else if(subchoose == 4) {
								break;
							}
						}
					}
					else System.out.println("Nhap sai tai khoan hoac mat khau");
					
				}
			}else if(choose ==3) {
				FileOutputStream aa1 = new FileOutputStream("file1.txt");
				ObjectOutputStream aa2 = new ObjectOutputStream(aa1);				
				aa2.writeObject(listUser);
				aa2.close();
				
				FileOutputStream bb1 = new FileOutputStream("file2.txt");
				ObjectOutputStream bb2 = new ObjectOutputStream(bb1);				
				bb2.writeObject(listTheTu);
				bb2.close();
				
			}else if(choose == 4) {
				FileInputStream aa3 = null;
				ObjectInputStream aa4 = null;
				aa3 = new FileInputStream("file1.txt");
				aa4 = new ObjectInputStream(aa3);
				ArrayList<User> danhsach2 = (ArrayList<User>) aa4.readObject();
				System.out.println("Doc tu file User");
				for(User s : danhsach2) {
					System.out.println(s.getId());
				}
				aa4.close();
				aa3.close();
				
				FileInputStream bb3 = null;
				ObjectInputStream bb4 = null;
				bb3 = new FileInputStream("file2.txt");
				bb4 = new ObjectInputStream(bb3);
				ArrayList<TheTu> danhsach3 = (ArrayList<TheTu>) bb4.readObject();
				System.out.println("Doc tu file The Từ");
				for(TheTu c : danhsach3) {
					System.out.println(c.getPIN());
				}
				bb4.close();
				bb3.close();
			}

		}
	}

}
