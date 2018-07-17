package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
	private double  soDu;
	private String name, loaiTien, status,id;

	public Users() {
		super();
	}

	public Users(String id, double soDu, String name, String loaiTien, String status) {
		super();
		this.id = id;
		this.soDu = soDu;
		this.name = name;
		this.loaiTien = loaiTien;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
		System.out.println("Name: ");
		this.name = sc.nextLine();
		try {
			ATMExceptions.chkHoTen(name);
			break;
		} catch (ATMExceptions e) {
			System.err.println(e);
			System.out.println();
		}
		}
		System.out.println("Tài khoản hiện có: ");
		this.soDu = Double.parseDouble(sc.nextLine());

		System.out.println("Loại tiền: ");
		this.loaiTien = sc.nextLine();

		System.out.println("Trạng thái: ");
		this.status = sc.nextLine();
	}

	public void xuat() {
		System.out.println( "  |  Name: " + this.name + "  |  Tài khoản có: " + this.soDu
				+ "  |  Loại tiền: " + this.loaiTien + "  |  Trạng thái: " + this.status);
	}
	
}