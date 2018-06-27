package unit_4;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFPT{
	public double diemjava;
	public double diemhtml;
	public double diemcss;
	public double diemtb;
	
	Scanner sc = new Scanner(System.in);
	
	
	public SinhVienIT() {
		
	}
	
	public SinhVienIT(double diemjava, double diemhtml, double diemcss, double diemtb) {
		
		this.diemjava = diemjava;
		this.diemhtml = diemhtml;
		this.diemcss = diemcss;
		this.diemtb = diemtb;
	}

	@Override            // ghi de phuong thuc
	public void nhap() {
		super.nhap();
		System.out.print(" nhap diem java : ");
		diemjava = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap diem html : ");
		diemhtml = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap diem css : ");
		diemcss = Double.parseDouble(sc.nextLine());
		
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.println(" diem trung binh : "+diemtb);
		System.out.println(" xep loai : "+gethocLuc());
	}
	@Override
	public double getDiem() {
		
		diemtb = (2*diemjava + diemhtml + diemcss)/4;
		return diemtb ;
	
	}
	
}
