package unit_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class test implements Serializable {

	public String hoTen;
	public double heSoLuong;
	public double phuCap;
	
	public test() {
		
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" ten can bo : ");
		hoTen = sc.nextLine();
		System.out.print(" he so luong : ");
		heSoLuong = Double.parseDouble(sc.nextLine());
	}
	
	public static void main(String[] args) {
		
	try {
		FileOutputStream fos = new FileOutputStream("nhanvien.dat");  //  khoi tao luong
		ObjectOutputStream oos = new ObjectOutputStream(fos);         // dau ra doi tuong 
		test t = new test();
		t.nhap();
		oos.writeObject(t);  //  thao tac viet du lieu 
		
		oos.close();         // dong luong lai 
		fos.close();
		
	} catch (Exception e) {
		System.out.println(" da say ra loi : "+e);
		
	}
	FileInputStream fis = null;        //  khoi tao dau vao tep = rong
	ObjectInputStream ois = null;      //  khoi tao dau vao doi tuong = rong
	
	try {
		fis = new FileInputStream("nhanvien.dat");   
		ois = new ObjectInputStream(fis);
		test t1 = (test) ois.readObject();  // thao tac doc du lieu 
		System.out.println(t1.hoTen);
		System.out.println(t1.heSoLuong);
		
		ois.close();  // thao tac dong luong
		fis.close();
	}
	catch (Exception e) {
		System.out.println(" da say ra loi :" + e);
	}
	
	}
	
	
}
