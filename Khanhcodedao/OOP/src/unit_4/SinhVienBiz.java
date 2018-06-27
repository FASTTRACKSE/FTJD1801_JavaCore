package unit_4;

import java.util.Scanner;

public  class SinhVienBiz extends SinhVienFPT {
	public double diemmarketing;
	public double diemsales;
	public double diemtb;
	
	public SinhVienBiz() {
		
	}
	
	public SinhVienBiz(double diemmarketing, double diemsales, double diemtb) {
		this.diemmarketing = diemmarketing;
		this.diemsales = diemsales;
		this.diemtb = diemtb;
	}

	Scanner sc = new Scanner(System.in);
	
	
	public void nhap() {
		super.nhap();
		System.out.print(" nhap diem marketing : ");
		diemmarketing = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap diem sales : ");
		diemsales = Double.parseDouble(sc.nextLine());
	
	}
	
	@Override
	public double getDiem() {
			
		diemtb = ((2*diemmarketing) + diemsales)/3;
		return diemtb;
		
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.println(" diem trung binh : "+diemtb);
		System.out.println(" xep loai : "+gethocLuc());
	}
	
}
