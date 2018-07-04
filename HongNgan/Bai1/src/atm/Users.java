package atm;

import java.util.Scanner;

public class Users {
	public String id;
	public int maPin;
	public String hoTen;
	public double soDuTK;
	public String loaiTienTe;
	public String trangthai;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, int maPin, String hoTen, double soDuTK, String loaiTienTe, String trangthai) {
		super();
		this.id = id;
		this.maPin = maPin;
		this.hoTen = hoTen;
		this.soDuTK = soDuTK;
		this.loaiTienTe = loaiTienTe;
		this.trangthai = trangthai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMaPin() {
		return maPin;
	}

	public void setMaPin(int maPin) {
		this.maPin = maPin;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getSoDuTK() {
		return soDuTK;
	}

	public void setSoDuTK(double soDuTK) {
		this.soDuTK = soDuTK;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so tai khoan");
		this.id = sc.nextLine();
		
		System.out.println("Nhap ma pin");
		this.maPin = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhap ho ten");
		this.hoTen = sc.nextLine();
		
		System.out.println("So du tai khoan");
		this.soDuTK = Double.parseDouble(sc.nextLine());
		
		System.out.println("Nhap loai tien te");
		this.loaiTienTe=sc.nextLine();
		
		System.out.println("Nhap trang thai");
		this.trangthai=sc.nextLine();
	}
	
	public void xuat() {
		System.out.println("| So tai khoan"+this.soDuTK+"| Ma pin"+this.maPin+"| Ho ten"+this.hoTen+"| So Du"+this.soDuTK+
				"| Loai tien te"+this.loaiTienTe);
	}
	
	
}
