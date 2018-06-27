package quanLiTienDien;

import java.util.Scanner;

public class KhachHang {
	public String tenHo;
	public Double soNha;
	public String maSo;
	
	public String getTenHo() {
		return tenHo;
	}

	public void setTenHo(String tenHo) {
		this.tenHo = tenHo;
	}

	public Double getSoNha() {
		return soNha;
	}

	public void setSoNha(Double soNha) {
		this.soNha = soNha;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public KhachHang() {
		super();
	}

	public KhachHang(String tenHo, Double soNha, String maSo) {
		super();
		this.tenHo = tenHo;
		this.soNha = soNha;
		this.maSo = maSo;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên hộ sử dụng điện:");
		this.tenHo = sc.nextLine();
		System.out.println("Nhập số nhà:");
		this.soNha= Double.parseDouble(sc.nextLine());
		System.out.println("Nhập Mã số:");
		this.maSo = sc.nextLine();
	}
	public void output() {
		System.out.println("Tên chủ hộ:"+tenHo+"   Số nhà:"+soNha+"   Mã số công tơ:"+maSo);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
