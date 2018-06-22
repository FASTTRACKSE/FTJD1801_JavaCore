package unit3;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	public String ten;
	public double donGia;
	public double giamGia;
	public SanPham() {}
	public SanPham(String tenSP,double donGia,double giamGia) {
		this.ten=tenSP;
		this.donGia=donGia;
		this.giamGia=giamGia;
		
	}
	public void input() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhập Tên ");
		this.ten=sc.nextLine();
	
		System.out.println("Nhập Đơn Giá ");
		this.donGia= sc.nextDouble();
		
		System.out.println("Nhập Giam Giá ");
		this.giamGia= sc.nextDouble();
	}
	public double getThue() {
		return this.donGia *10/100;
	}
	public void xuat() {
		System.out.println(this.ten+"//"+this.donGia+"//"+this.giamGia+"//"+this.getThue());
	}

	public static void main(String[] args) {
		ArrayList<SanPham> splist = new ArrayList<SanPham>();
		for( int i=0;i<3;i++) {
		SanPham sp1=new SanPham("sp1",10000,10);
		sp1.input();
		splist.add(sp1);
		}
		for (int i=0; i<splist.size();i++) {
			splist.get(i).xuat();
		}
		
		
		
	}

}
