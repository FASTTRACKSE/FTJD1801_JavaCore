package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LuuFile {
	public static void luuID(ArrayList<Users> idList) throws IOException {
		FileOutputStream fos = new FileOutputStream("ID.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(idList);
		oos.close();
		fos.close();
	}
	static ArrayList<Users> output()  {
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
	public static void luuTheTu(ArrayList<TheTu> listtheTu) throws IOException {
		FileOutputStream fos = new FileOutputStream("theTu.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(listtheTu);
		oos.close();
		fos.close();
		}
		static ArrayList<TheTu> output1()  {	
			try {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
				fis = new FileInputStream("theTu.dat");
				ois = new ObjectInputStream(fis);
				ArrayList<TheTu> theTu = (ArrayList<TheTu>) ois.readObject();
				ois.close();
				fis.close();
				return theTu;
			}		catch (Exception e ) {
				System.out.println(e);
			}
			return null;
			
		}
		public static void saveGiaoDich(ArrayList<GiaoDich> listgd) throws IOException, ClassNotFoundException {
			  FileOutputStream fos = new FileOutputStream("giaoDich.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(listgd );
				oos.close();
				fos.close();
		  }
		public void outputgd() throws IOException, ClassNotFoundException {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
				fis = new FileInputStream("giaoDich.dat");
				ois = new ObjectInputStream(fis);
				ArrayList<GiaoDich> listgd = (ArrayList<GiaoDich>) ois.readObject();
				for (Users gd:listgd) {
					gd.xuat();
				}
				ois.close();
				fis.close();

		}
}
