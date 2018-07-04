package doc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import canbo.CanBo;

public class Doc {
	public class IOEException extends Exception{
	public void main(String[] args) throws IOEException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("fileobject.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<CanBo>listCB = new ArrayList<CanBo>();
		oos.writeObject(listCB);
		oos.close();
		}
	}
	}

