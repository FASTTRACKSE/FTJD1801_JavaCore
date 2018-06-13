package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	String tenSp;
	double donGia, giamGia, giaTG;
	ArrayList<SanPham> data = new ArrayList<SanPham>();
	public double getThueNhapKhau() {
		return this.donGia*(1/10);
	}
	public void input() {
		int sl;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên sản phẩm: ");
		tenSp = input.nextLine();
		System.out.println("Nhập đơn giá: ");
		donGia = Double.parseDouble(input.nextLine());
		System.out.println("Nhập giảm giá: ");
		giamGia = Double.parseDouble(input.nextLine());
	}
	public void output() {
		System.out.println("Tên sản phẩm: "+tenSp+" | Đơn giá: "+donGia+" | Giảm giá: "+giamGia+" Thuế nhập khẩu: "+this.getThueNhapKhau());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> spList = new ArrayList<SanPham>();
		// khởi tạo 1 danh sách mảng với kiểu SanPham có tên là spList
		SanPham sp = new SanPham();
		// khởi tạo đối tượng SanPham với tên sp
		for(int i = 0; i < 2; i++) {			
			// vòng lặp nhập các thuộc tính của sản phẩm sau đó add(thêm) vào danh sách mảng spList
			sp.input();
			spList.add(sp);
		}
		for(int i = 0; i < spList.size()-1; i++) {
			for(int j = i + 1; j < spList.size(); j++) {
				if(spList.get(i).donGia > spList.get(j).donGia) {
					// sắp xếp theo đơn giá bằng cách tạo biến trung gian và hoán vị
					sp.giaTG = spList.get(i).donGia;
					spList.get(i).donGia = spList.get(j).donGia;
					spList.get(j).donGia = sp.giaTG;
				}
			}
		}
		for(int i = 0; i < spList.size(); i++) {
			spList.get(i).output();
			// in từng sản phẩm
		}
	}

}
