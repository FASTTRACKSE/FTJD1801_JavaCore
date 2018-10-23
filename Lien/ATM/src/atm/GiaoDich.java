package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GiaoDich extends Users {
	String thoiGian;
	double tienGiaoDich;
	String tenTK;

	public GiaoDich() {
		super();
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getTienGiaoDich() {
		return tienGiaoDich;
	}

	public void setTienGiaoDich(double tienGiaoDich) {
		this.tienGiaoDich = tienGiaoDich;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public void luuGiaoDich(ArrayList<GiaoDich> gdList) throws IOException, ClassNotFoundException {
		FileOutputStream fos1 = new FileOutputStream("giaoDich.dat");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(gdList);
		oos1.close();
		fos1.close();
	}

	public void xuat() {
		System.out.println(this.tenTK + " | " + this.maThe + " | " + this.tienGiaoDich + " | " + this.thoiGian);
	}

	public void output1() throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		fis = new FileInputStream("giaoDich.dat");
		ois = new ObjectInputStream(fis);
		ArrayList<GiaoDich> gd = (ArrayList<GiaoDich>) ois.readObject();
		for (Users gd1 : gd) {
			gd1.xuat();
		}
		ois.close();
		fis.close();

	}
}