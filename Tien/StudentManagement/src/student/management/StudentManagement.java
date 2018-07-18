//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;
//
//public class ATM_Main implements Serializable {
//
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) throws IOException {
//		ArrayList<Users> listUser = new ArrayList<Users>();
//
//		try {
//			FileInputStream fis = null;
//			ObjectInputStream ois = null;
//			fis = new FileInputStream("ID.dat");
//			ois = new ObjectInputStream(fis);
//			listUser = (ArrayList<Users>) ois.readObject();
//
//			ois.close();
//			fis.close();
//		} catch (IOException | ClassNotFoundException io) {
//			System.out.println("Co loi " + io);
//		}
//		ArrayList<TheTu> listTheTu = new ArrayList<TheTu>();
//
//		try {
//			FileInputStream fis = null;
//			ObjectInputStream ois = null;
//			fis = new FileInputStream("TheTu.dat");
//			ois = new ObjectInputStream(fis);
//			listTheTu = (ArrayList<TheTu>) ois.readObject();
//
//			ois.close();
//			fis.close();
//		} catch (IOException | ClassNotFoundException io) {
//			System.out.println("Co loi " + io);
//		}
//		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
//		// doc 3 file luu vao 3 list tren
//		try {
//			FileInputStream fis = null;
//			ObjectInputStream ois = null;
//			fis = new FileInputStream("giaoDich.dat");
//			ois = new ObjectInputStream(fis);
//			listGiaoDich = (ArrayList<GiaoDich>) ois.readObject();
//			ois.close();
//			fis.close();
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		// doc file id
//
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.println("------MENU------");
//			System.out.println("1.Dang nhap");
//			System.out.println("2.Them tk");
//			System.out.println("3.Thoat");
//			System.out.println("Chon chuc nang");
//			int choose = Integer.parseInt(sc.nextLine());
//			if (choose == 1) {
//				System.out.println("Nhap so the");
//				String the = sc.nextLine();
//
//				System.out.println("Nhap ma Pin");
//				String pin = sc.nextLine();
//
//				for (TheTu thetu : listTheTu) {
//					String maPin = thetu.getMaPin();
//					String soThe = thetu.getId();
//					if (thetu.dangNhap(the, pin)) {
//						while (true) {
//							System.out.println("1.Rut tien");
//							System.out.println("2.Xem so du");
//							System.out.println("3.Xem lich su giao dich");
//							System.out.println("4.Tro ve menu");
//							System.out.println("Chon chuc nang");
//							int subchoose = Integer.parseInt(sc.nextLine());
//							if (subchoose == 1) {
//								System.out.println("Nhap so tien rut");
//								int soTienRut = Integer.parseInt(sc.nextLine());
//
//								for (Users user : listUser) {
//									if (the.equals(user.getId())) {
//										int soDuHienTai = user.getSoDu();
//										int soDuMoi = soDuHienTai - soTienRut;
//
//										user.setSoDu(soDuMoi);
//
//										GiaoDich giaoDich = new GiaoDich();
//										giaoDich.setId(user.getId());
//										Date date = new Date();
//										giaoDich.setThoiGian(date);
//										giaoDich.setSoTienGiaoDich(soTienRut);
//
//										listGiaoDich.add(giaoDich);
//									}
//
//								}
//								
//
//								try {
//									FileOutputStream fos = new FileOutputStream("giaoDich.dat");
//									ObjectOutputStream oos = new ObjectOutputStream(fos);
//									oos.writeObject(listGiaoDich);
//									oos.close();
//									fos.close();
//								} catch (IOException e) {
//									System.out.println("Co loi " + e);
//								}
//								
//							
//								// luu giaodich.dat
//
//							} else if (subchoose == 2) {
//								for (Users user : listUser) {
//									if (the.equals(user.getId())) {
//										System.out.println("So Du la:" + user.getSoDu());
//									}
//								}
//							} else if (subchoose == 3) {
//								for (GiaoDich gd : listGiaoDich) {
//									if (the.equals(gd.getId())) {
//										System.out.println(gd.getMoTaGiaoDich() + ":" + gd.getThoiGian() + ":"
//												+ gd.getSoTienGiaoDich());
//									}
//								}
//							} else
//								break;
//						}
//					}
//				}
//			} else if (choose == 2) {
//				Users usr = new Users();
//				usr.nhap();
//				listUser.add(usr);
//
//				try {
//					FileOutputStream fos = new FileOutputStream("ID.dat");
//					ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//					oos.writeObject(listUser);
//					oos.close();
//				} catch (IOException e) {
//					System.out.println("Co loi " + e);
//				}
//
//				// luu ds user xg file ID.dat
//
//				TheTu theTu = new TheTu();
//
//				theTu.setId(usr.getId());
//				theTu.nhap();
//				listTheTu.add(theTu);
//				// luu ds the tu xg file TheTu.dat
//				try {
//					FileOutputStream fos = new FileOutputStream("TheTu.dat");
//					ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//					oos.writeObject(listTheTu);
//					oos.close();
//				} catch (IOException e) {
//					System.out.println("Co loi " + e);
//				}
//
//			} else
//				break;
//
//		}
//
//	}
//}