package MT_1_OOP;

import java.util.Scanner;

public class SanPham {
	private String tensanpham;
	private double dongia;
	private double giamgia = 0;
	private double getthueThuNhap(double thue) {
		thue = (dongia/100)*10;
		return thue;
	}
	 
	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public double getGiamgia() {
		return giamgia;
	}

	public void setGiamgia(double giamgia) {
		this.giamgia = giamgia;
	}
	
	
	public SanPham() {
		
	}
	public SanPham(String tensanpham ,double dongia , double giamgia1) {   // ham tao thu nhat
		this.tensanpham = tensanpham;
		this.dongia = dongia;
		this.giamgia = giamgia;
	}
	public SanPham(String tensanpham ,double dongia) {   // ham tao thu 2
		this.tensanpham = tensanpham;
		this.dongia = dongia;
		this.giamgia = 0;
	}
	
	
	Scanner sc = new Scanner(System.in);
	public void nhap() {
		System.out.print(" nhap vao ten san pham : ");
		tensanpham = sc.nextLine();
		System.out.print(" nhap vao don gia : ");
		dongia = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap vao giam gia : ");
		giamgia = Double.parseDouble(sc.nextLine());
	}
	public void xuat() {
		System.out.println(" ten san pham : "+tensanpham);
		System.out.println(" don gia : "+dongia);
		if(giamgia != 0) {
			System.out.println(" giam gia : "+giamgia);
		}
		System.out.println(" gia thue la : "+(dongia/100)*10);
	}
	
	public static void main(String[] args) {
		
		SanPham sp1 = new SanPham();       //  o day van phai nhap vao 3 thong tin tu ban phim
	    sp1.nhap();                        // 
		
		Scanner sc = new Scanner(System.in);
		System.out.print(" nhap vao ten san pham : ");
		String tensanpham = sc.nextLine();
		
		System.out.print(" nhap vao don gia : ");
		double dongia = Double.parseDouble(sc.nextLine());
		
		SanPham sp2 = new SanPham(tensanpham , dongia);  // o day : gan truc tiep san pham vao mang
		                                                 // qua do no se nhat biet la ham tao co 2 thuoc tinh 
		sp1.xuat();
		sp2.xuat();
		
	}
}
