package final_assignment;

import java.io.*;
import java.util.ArrayList;

public class LuuFile {
	
	static void luuID(ArrayList<User> idList)  {
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
	static ArrayList<User> output()  {
		try {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<User> user = (ArrayList<User>) ois.readObject();
			ois.close();
			fis.close();
			return user;
		}
		catch (Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	static void luuTheTu(ArrayList<TheTu> theTuList) {
		try {
			FileOutputStream fos = new FileOutputStream("theTu.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(theTuList);
			oos.close();
			fos.close();
			}
		catch (Exception e) {
			System.out.println(e);
		}
		}
	static ArrayList<TheTu> output1()  {	
		try {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("theTu.dat");
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
	static void luuGiaoDich(ArrayList<GiaoDich> gdList) {
		try {
			FileOutputStream fos = new FileOutputStream("giaoDich.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gdList);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static ArrayList<GiaoDich> output2()  {	
		try {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("giaoDich.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<GiaoDich> gd = (ArrayList<GiaoDich>) ois.readObject();
			ois.close();
			fis.close();
			return gd;
		}		catch (Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
