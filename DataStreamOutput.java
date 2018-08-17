package lopsinhvien;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamOutput {

	public static void main(String[] args) throws IOException{		
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream("filedata.dat");
		String str = "Hello";
		file.write(str.getBytes());
		
	}	
}