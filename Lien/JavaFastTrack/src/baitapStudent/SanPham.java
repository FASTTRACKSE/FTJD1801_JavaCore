package baitapStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	public String name;
	public double donGia;
	public double giamGia;
	public double gia;
	
	public SanPham(String name, double donGia, double giamGia) {
		super();
		this.name = name;
		this.donGia = donGia;
		this.giamGia = giamGia;
	}
	

	public SanPham() {
		super();
	}


	public SanPham(String name, double donGia) {
		super();
		this.name = name;
		this.donGia = donGia;
		this.giamGia =0;
	}


	public double getThue() {
		return donGia*(1/10);
	}
	
	public void input() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Vui lòng nhập tên sản phẩm: ");
		name = sc.nextLine();
		System.out.println("Vui lòng nhập đơn giá: ");
		donGia = Double.parseDouble(sc.nextLine());
		System.out.println("Vui lòng nhập giảm giá: ");
		giamGia = Double.parseDouble(sc.nextLine());
	}
	public void output() {
		System.out.println("Tên sản phẩm: "+name+ "      Đơn giá:"+donGia+"     Giảm giá:"+giamGia+    "     Thuế:"+this.getThue());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		SanPham sp = new SanPham();
		Scanner sc= new Scanner(System.in);
		System.out.println("Vui lòng nhập tên sản phẩm: ");
		String name = sc.nextLine();
		System.out.println("Vui lòng nhập đơn giá: ");
		Double donGia = Double.parseDouble(sc.nextLine());
		System.out.println("Vui lòng nhập giảm giá: ");
		Double giamGia = Double.parseDouble(sc.nextLine());
		sp.output();
		SanPham sp1 = new SanPham(name,donGia);
		sp1.output();
		
//		for (int i = 0; i <3 ; i++) {
//		
//		sp.input();
//		sp1.input();
//		list.add(sp);
//	
//		
//	}
//		for(int i = 0;i < list.size()-1;i++) {
//			for(int j = i+1; i < list.size();j++) {
//				if(list.get(i).donGia > list.get(j).donGia) {
//					sp.gia = list.get(i).donGia;
//					
//					list.get(i).donGia = list.get(j).donGia;
//					list.get(j).donGia = sp.gia;
//				}
//			}
//			
//		}
//		for(int i = 0 ; i<list.size();i++) {
//			list.get(i).output();
//		}
	}

}
	
