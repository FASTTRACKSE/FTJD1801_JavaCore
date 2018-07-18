package unit8.atm;

import java.io.Serializable;
import java.util.Scanner;

public class Users implements Serializable {
	private String id;
	private String hoTen;
	private int soDu;
	private String loaiTienTe;
	private String trangThai;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Users(String id, String hoTen, int soDu, String loaiTienTe, String trangThai) {
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
		Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.println("Nhap ma so the: ");
			this.id = sc.nextLine();
			try {
				MyException.chkMaSoThe(id);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		
		
		for (;;) {
			System.out.println("Nhap ho ten chu tai khoan: ");
			this.hoTen = sc.nextLine();
			try {
				MyException.chkHoTen(hoTen);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
		}
		
		System.out.println("So du tai khoan");
		this.soDu = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhap loai tien te");
		this.loaiTienTe=sc.nextLine();
		
		System.out.println("Nhap trang thai");
		this.trangThai=sc.nextLine();
	}
	
	
	
}
