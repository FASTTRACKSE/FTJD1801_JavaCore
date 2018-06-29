package test.write.file;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.imageio.stream.FileImageInputStream;

public class DocFile {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("fileSinhVien.txt");
			ois = new ObjectInputStream(fis);
			Student sv = (Student) ois.readObject();
			System.out.println("Doc tu file: ");
			System.out.println(sv);
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
