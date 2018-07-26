package baitapatm;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable{
	private String id;
	private String hoTen;
	private int soDu;
	private String loaiTienTe;
	private String trangThai;
	
	public User() {
		super();
	}

	public User(String id, String hoTen, int soDu, String loaiTienTe, String trangThai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.soDu = soDu;
		this.loaiTienTe = loaiTienTe;
		this.trangThai = trangThai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoDu() {
		return soDu;
	}

	public void setSoDu(int soDu) {
		this.soDu = soDu;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void nhap() {
		//nhap use
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap id");
		this.id = sc.nextLine();
		System.out.println("Nhap ho ten");
		this.hoTen = sc.nextLine();
		System.out.println(" Nhap so du");
		this.soDu = Integer.parseInt(sc.nextLine());
		System.out.println(" Nhap loai tien te");
		this.loaiTienTe = sc.nextLine();
		
	}
}
