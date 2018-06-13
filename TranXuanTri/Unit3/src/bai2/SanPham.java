package bai2;
import java.util.ArrayList;
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
		System.out.println(this.tenSanPham + " || " + this.donGia + " || " + this.giamGia + " || " + this.getThue());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <SanPham> spList = new ArrayList<SanPham>();
//		SanPham[] spList = new SanPham[5];
		for (int i = 0; i < 3; i++) {
			SanPham sp = new SanPham();
			sp.nhap();
			spList.add(sp);
//			spList[i] = sp;
		}
//		double tam;
//		SanPham spTam = new SanPham();
//		for (int a = 0; a < spList.size() - 1; a++) {
//			for (int b = spList.size() - 1; b >= 1; b--) {
//				double x = spList[b - 1].donGia;
//				double y = spList[b].donGia;
//				if (spList.get(b-1).donGia > spList.get(b).donGia) {
//					tam = spList.get(b).donGia;
//					spList.get(b).donGia = spList.get(b-1).donGia;
//					spList.get(b-1).donGia = tam;
//					spTam = spList.get(b);
//					spList.get(b) = spList.get(b-1);
//					spList.get(b-1) = spTam;
//				}
//			}
//		}
		System.out.println("Don gia tu thap den cao");
		for (int i = 0; i < spList.size(); i++) {
			spList.get(i).xuat();
		}
	}
}
