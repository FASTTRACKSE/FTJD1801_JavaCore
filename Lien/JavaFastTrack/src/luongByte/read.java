package luongByte;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("file.dat");
			ois = new ObjectInputStream(fis);
			SinhVien s = (SinhVien) ois.readObject();
			System.out.println("Đọc từ file");
			System.out.println(s);
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("loi :" +e);
			// TODO: handle exception
		}
	}

}
