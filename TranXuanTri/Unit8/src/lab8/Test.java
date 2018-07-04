package lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Test implements Serializable {
	public String hoTen;
	public double heSoLuong;
	public double phuCap;
	
	public Test() {
		super();
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
		System.out.println("Nhap ho ten can bo: ");
		this.hoTen = sc.nextLine();
		System.out.println("Nhap he so luong: ");
		this.heSoLuong = Double.parseDouble(sc.nextLine());
	}
	public static void main(String[] args) {
		//output stream
		try {
		FileOutputStream fos = new FileOutputStream("nhanvien.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Test ts = new Test();
		ts.nhap();
		oos.writeObject(ts);
		oos.close();
		}
		catch (Exception e) {
			System.out.println("Co loi " + e);
		}
		
		//input stream
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("nhanvien.dat");
			ois = new ObjectInputStream(fis);
			Test ts1 = (Test) ois.readObject();
			System.out.println(ts1.hoTen);
			ois.close();
			fis.close();
		}
		catch (Exception e) {
			System.out.println("Co loi " + e);
		}
	}
}
