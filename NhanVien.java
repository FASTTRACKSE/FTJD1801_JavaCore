package canbo;
import java.util.Scanner;
public class NhanVien extends CanBo {
	
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, double heSoLuong, String phongBan, String chucVu, int soNgayCong) {
		super(hoTen, heSoLuong);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}	

	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Phòng ban: ");
		phongBan = sc.nextLine();
		System.out.println("Chức vụ: ");
		chucVu = sc.nextLine();
		System.out.println("Số ngày công: ");
		soNgayCong = Integer.parseInt(sc.nextLine());
		
	}
	
	@Override
	public int getPhuCap() {
		// TODO Auto-generated method stub
		if(this.getChucVu().equals("Trưởng phòng")) {
			return 2000;
		}else if(this.getChucVu().equals("Phó phòng")) {
			return 1000;
		}else if(this.getChucVu().equals("Nhân viên")) {
			return 500;
		}else {
			return 0;
		}		
	}
	
	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return this.getHeSoLuong()*730+this.getPhuCap()+this.soNgayCong*30;
	}
	
	public void xuat() {
		super.xuat();
		System.out.println("Phongban: " + this.phongBan + " |Chucvu: " + this.chucVu + "  |Songaycong: " + soNgayCong);
	}
	
}
