package bai2;
import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	private String tenSanPham;
	private double donGia;
	private double giamGia;

	public double getThueThuNhap() {
		return this.donGia * 10 / 100;
	}

	public SanPham() {
	}

	public SanPham(String tenSanPham, double donGia, double giamGia) {
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public SanPham(String tenSanPham, double donGia) {
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		// this(tenSanPham, donGia, 0);
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		this.tenSanPham = sc.nextLine();

		System.out.print("Nhap don gia: ");
		this.donGia = sc.nextDouble();

		System.out.print("Nhap giam gia: ");
		this.giamGia = sc.nextDouble();
	}

	public void xuat() {
		System.out.println(
				this.tenSanPham + " || " + this.donGia + " || " + this.giamGia + " || " + this.getThueThuNhap());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> spList = new ArrayList<SanPham>();
		SanPham sp1 = new SanPham();
		sp1.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		String ten = sc.nextLine();
		System.out.print("Nhap gia san pham: ");
		double gia = Double.parseDouble(sc.nextLine());
		SanPham sp2 = new SanPham(ten, gia);
		sp1.xuat();
		sp2.xuat();

	}
}
