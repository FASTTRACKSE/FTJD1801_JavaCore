package unit4.canbo;
import java.io.Serializable;
import java.util.Scanner;
public abstract class CanBo implements Serializable {
	public String maCanBo;
	public String hoTen;
	public double heSoLuong;
	public double phuCap;
	
	public CanBo() {
		super();
	}
	
	

	public String getMaCanBo() {
		return maCanBo;
	}



	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
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



	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}



	public CanBo(String maCanBo, String hoTen, double heSoLuong, double phuCap) {
		super();
		this.maCanBo = maCanBo;
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}



	public void nhap() {
		Scanner sc = new Scanner(System.in);
	
		for(;;) {
		System.out.println("Nhap ho ten can bo: ");
		this.hoTen = sc.nextLine();
		try {
			CanBoException.chkHoTen(hoTen);;
			break;
		}catch(Exception e) {
			System.err.println(e);
		}
		}
		
		for(;;) {
		System.out.println("Nhap he so luong: ");
		this.heSoLuong = Double.parseDouble(sc.nextLine());
		try {
			CanBoException.chkSoThuc(0);
			break;
		}catch(Exception e) {
			System.err.println(e);
		}
		}
	}

	public void xuat() {
		System.out.print(this.hoTen + " | He so luong: " + this.heSoLuong + " | Phu cap: ");
	}
	public abstract double tinhLuong();
	public abstract double getPhuCap();
}