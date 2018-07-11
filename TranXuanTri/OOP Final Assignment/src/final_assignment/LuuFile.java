package final_assignment;

import java.io.*;
import java.util.ArrayList;

public class LuuFile {
	
	static void luuID(ArrayList<User> idList) throws IOException {
		FileOutputStream fos1 = new FileOutputStream("ID.dat");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(idList);
		oos1.close();
		fos1.close();
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
	static void luuTheTu(ArrayList<TheTu> theTuList) throws IOException {
	FileOutputStream fos = new FileOutputStream("theTu.dat");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(theTuList);
	oos.close();
	fos.close();
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
}
