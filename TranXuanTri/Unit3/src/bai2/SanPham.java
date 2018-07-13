package bai2;

import java.util.Scanner;

public class SanPham {
	public String tenSanPham;
	public double donGia;
	public double giamGia;
	public double getThue() {
		return this.donGia*10/100;
	}
	public SanPham(String tenSanPham,double donGia, double giamGia) {
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}
	public SanPham() {
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
		System.out.println(this.tenSanPham + "||" + this.donGia + "||" + this.giamGia + "||" + this.getThue());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SanPham[] spList = new SanPham[5];
		for (int i = 0; i < spList.length; i++) {
			SanPham sp = new SanPham();
			sp.nhap();
			spList[i] = sp;
		}
		double tam;
		SanPham spTam = new SanPham();
		for (int a = 0; a < spList.length - 1; a++) {
			for (int b = spList.length - 1; b >= 1; b--) {
				double x = spList[b - 1].donGia;
				double y = spList[b].donGia;
				if (x > y) {
					tam = y;
					y = x;
					x = tam;
					spTam = spList[b];
					spList[b] = spList[b - 1];
					spList[b - 1] = spTam;
				}
			}
		}
		System.out.println("Don gia tu thap den cao");
		for (int i = 0; i < spList.length; i++) {
			spList[i].xuat();
		}
	}
}
