package test.write.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GhiFile {
	public static void main(String arg[]) throws IOException, ClassNotFoundException{
		FileOutputStream fos = new FileOutputStream("fileSinhVien.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Student st = new Student("1","Tran Tai Tien","Quang Nam",20,8,9);
		oos.writeObject(st);
		oos.close();
	}
}
