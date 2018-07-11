package final_assignment;

import java.io.*;
import java.util.ArrayList;


public class GiaoDich extends ID {
	String thoiGian;
	double tienGiaoDich;
	String tenTaiKhoan;
	ArrayList<GiaoDich> bill = new ArrayList<GiaoDich>();
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

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public ArrayList<GiaoDich> nhapGiaoDich(double tienGiaoDich, String thoiGian, String maThe, ArrayList<GiaoDich> bill) throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<ID> id = (ArrayList<ID>) ois.readObject();
			for (ID id1:id) {
				if (maThe.equals(id1.maThe)) {
					GiaoDich bill1 = new GiaoDich();
					bill1.tenTaiKhoan = id1.tenTaiKhoan;
					bill1.maThe = id1.maThe;
					bill1.thoiGian=thoiGian;
					bill1.setTienGiaoDich(tienGiaoDich);
					bill.add(bill1);
				}
			}
			ois.close();
			return bill;
	}
	public void giaoDich(double tienGiaoDich, String thoiGian, String maThe) throws IOException, ClassNotFoundException {
		  FileOutputStream fos1 = new FileOutputStream("giaoDich.dat");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			nhapGiaoDich(tienGiaoDich, thoiGian, maThe, bill);
//			for (GiaoDich gd: bill) {
//				gd.xuat();
//			}
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
			ArrayList<GiaoDich> gd = (ArrayList<GiaoDich>) ois.readObject();
			for (ID gd1:gd) {
				gd1.xuat();
			}
			ois.close();
			fis.close();

	}
}
