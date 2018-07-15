package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	
	String tenSp;
	double donGia, giamGia, giaTG;

	public SanPham() {
	}

	public SanPham(String tenSp, double donGia) {
		super();
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.giamGia = 0;
		// = this(tenSp,donGia,0);
	}

	public SanPham(String tenSp, double donGia, double giamGia) {
		super();
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}

	public double getThueNhapKhau() {
		return this.donGia*(1.0*10/100);
	}
	
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên sản phẩm: ");
		tenSp = input.nextLine();
		System.out.println("Nhập đơn giá: ");
		donGia = Double.parseDouble(input.nextLine());
		System.out.println("Nhập giảm giá: ");
		giamGia = Double.parseDouble(input.nextLine());
	}
	
	public void output() {
		if(giamGia == 0) {
			System.out.println("Tên sản phẩm: "+tenSp+" | Đơn giá: "+donGia+"  | Thuế nhập khẩu: "+this.getThueNhapKhau());
		}else {
			System.out.println("Tên sản phẩm: "+tenSp+" | Đơn giá: "+donGia+" | Giảm giá: "+giamGia+"  | Thuế nhập khẩu: "+this.getThueNhapKhau());
		}		
	}
	
	public static void main(String[] args) {
		String name;
		double price, saleOff;
		ArrayList<SanPham> spList = new ArrayList<SanPham>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập tên sản phẩm: ");
		name = sc.nextLine();
		System.out.println("Mời nhập giá: ");		
		price = Double.parseDouble(sc.nextLine());
		System.out.println("Mời nhập giảm giá: ");
		saleOff = Double.parseDouble(sc.nextLine());
		SanPham sp = new SanPham();
		SanPham sp1 = new SanPham(name,price,saleOff);
		sp1.output();
		SanPham sp2 = new SanPham(name, price);
		sp2.output();
//		for(int i = 0; i < 2; i++) {						
//			sp.input();
//			spList.add(sp);
//		}
//		
//		for(int i = 0; i < spList.size()-1; i++) {
//			for(int j = i + 1; j < spList.size(); j++) {
//				if(spList.get(i).donGia > spList.get(j).donGia) {
//					sp.giaTG = spList.get(i).donGia;
//					spList.get(i).donGia = spList.get(j).donGia;
//					spList.get(j).donGia = sp.giaTG;
//				}
//			}
//		}
//		
//		for(int i = 0; i < spList.size(); i++) {
//			spList.get(i).output();
//		}
		
	}

}
