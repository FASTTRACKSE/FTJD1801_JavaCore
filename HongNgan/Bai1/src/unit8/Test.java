package unit8;

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

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten can bo: ");
		this.hoTen = sc.nextLine();
		System.out.println("Nhap he so luong: ");
		this.heSoLuong = Double.parseDouble(sc.nextLine());
	}

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("canbo.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Test ts = new Test();
			ts.nhap();
			oos.writeObject(ts);
			oos.close();
		} catch (Exception e) {
			System.out.println("Co loi " + e);
		}

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("canbo.dat");
			ois = new ObjectInputStream(fis);
			Test ts1 = (Test) ois.readObject();
			System.out.println(ts1.hoTen);
			System.out.println(ts1.heSoLuong);
			ois.close();
			fis.close();
		} catch (Exception io) {
			System.out.println("Co loi " + io);
		}
	}
}