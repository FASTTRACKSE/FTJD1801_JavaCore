package final_assignment;

import java.io.*;
import java.util.ArrayList;


public class giaoDich extends ID {
	String thoiGian;
	double tienGiaoDich;
	String tenTaiKhoan;
	ArrayList<giaoDich> bill = new ArrayList<giaoDich>();
	  public giaoDich() {
		super();
	}
	public ArrayList<giaoDich> nhapGiaoDich(double tienGiaoDich, String thoiGian, String maThe, ArrayList<giaoDich> bill) throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<ID> id = (ArrayList<ID>) ois.readObject();
			for (ID id1:id) {
				if (maThe.equals(id1.maThe)) {
					giaoDich bill1 = new giaoDich();
					bill1.tenTaiKhoan = id1.tenTaiKhoan;
					bill1.maThe = id1.maThe;
					bill1.thoiGian = thoiGian;
					bill1.tienGiaoDich = tienGiaoDich;
					bill.add(bill1);
				}
			}
			return bill;
	}
	public void giaoDich(double tienGiaoDich, String thoiGian, String maThe) throws IOException, ClassNotFoundException {
		  FileOutputStream fos1 = new FileOutputStream("giaoDich.dat");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			nhapGiaoDich(tienGiaoDich, thoiGian, maThe, bill);
			oos1.writeObject(bill);
			oos1.close();
			fos1.close();
	  }
	public void xuat() {
		System.out.println(this.tenTaiKhoan + "||" + this.maThe + "||" + this.tienGiaoDich + "||" + this.thoiGian);
	}
	public void output() throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("giaoDich.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<giaoDich> gd = (ArrayList<giaoDich>) ois.readObject();
			for (ID gd1:gd) {
				gd1.xuat();
			}
			ois.close();
			fis.close();

	}
}
