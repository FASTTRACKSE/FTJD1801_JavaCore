package final_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ID extends TheTu {
	String tenTaiKhoan;
	String trangThaiTaiKhoan;
	String loaiTienTe;
	double soDuTaiKhoan;
	ArrayList<ID> idList = new ArrayList<ID>();

	public ID() {
		super();
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getTrangThaiTaiKhoan() {
		return trangThaiTaiKhoan;
	}

	public void setTrangThaiTaiKhoan(String trangThaiTaiKhoan) {
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public double getSoDuTaiKhoan() {
		return soDuTaiKhoan;
	}

	public void setSoDuTaiKhoan(double soDuTaiKhoan) {
		this.soDuTaiKhoan = soDuTaiKhoan;
	}
	public void taoTaiKhoan() throws IOException {
		super.theTu();
		taoID();
	}
	public void nhapID() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Nhap ho ten chu tai khoan: ");
			this.tenTaiKhoan = sc.nextLine();
			try {
				MyException.chkHoTen(tenTaiKhoan);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		for (;;) {
		System.out.println("Nhap ma so the: ");
		this.maThe = sc.nextLine();
		try {
			MyException.chkMaSoThe(maThe);
			break;
		} catch (MyException e) {
			System.err.println(e);
			System.out.println();
		}
		}
		System.out.println("Nhap trang thai tai khoan: ");
		this.trangThaiTaiKhoan = sc.nextLine();
		System.out.println("Nhap loai tien te: ");
		this.loaiTienTe = sc.nextLine();
		System.out.println("Nhap so du tai khoan: ");
		this.soDuTaiKhoan = Double.parseDouble(sc.nextLine());
	}
	public void taoID() throws IOException {
		FileOutputStream fos1 = new FileOutputStream("ID.dat");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		ID id = new ID();
		id.nhapID();
		idList.add(id);
		oos1.writeObject(idList);
		oos1.close();
		fos1.close();
	}
	public void xuat() {
		System.out.println("Chu tai khoan: " + this.tenTaiKhoan + "|| Trang thai tai khoan: " + this.trangThaiTaiKhoan + "|| So du tai khoan: " + this.soDuTaiKhoan + "|| Loai tien te: " + this.loaiTienTe);
	}
	public void output() throws IOException, ClassNotFoundException {	
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<ID> id = (ArrayList<ID>) ois.readObject();
			for (ID id1:id) {
				id1.xuat();
			}
			ois.close();
			fis.close();

	}
}
