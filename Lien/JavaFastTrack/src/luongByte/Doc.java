package luongByte;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class Doc {

	public static void main(String[] args) throws IOException ,ClassNotFoundException{
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("file.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		SinhVien  sv = new SinhVien("1", "Truong Thi My Lien" ,"Quang Nam",20,7,7);
	
		oos.writeObject(sv);
		oos.close();
	}
}
