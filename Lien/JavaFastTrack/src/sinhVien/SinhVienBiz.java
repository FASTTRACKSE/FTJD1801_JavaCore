package sinhVien;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienBiz extends SinhVienFpt{
	private double diemMarketing;
	private double diemSales;
	
	public SinhVienBiz() {
		super();
	}
		
	public SinhVienBiz(double diemMarketing, double diemSales) {
		super();
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	
	public double getDiemMarketing() {
		return diemMarketing;
	}

	public void setDiemMarketing(double diemMarketing) {
		this.diemMarketing = diemMarketing;
	}

	public double getDiemSales() {
		return diemSales;
	}

	public void setDiemSales(double diemSales) {
		this.diemSales = diemSales;
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return 	(2*diemMarketing+diemSales)/3;
	}
	
	public void nhap(ArrayList<SinhVienFpt> list) {
				super.nhap(list);
				Scanner sc = new Scanner(System.in);
				System.out.println("Điểm Marketing: ");
				diemMarketing = Double.parseDouble(sc.nextLine());
				System.out.println("Điểm Sales: ");
				diemSales = Double.parseDouble(sc.nextLine());
			}
			
			public void xuat() {
				super.xuat();
			}
			
			public void xuatBiz() {
				super.xuat();
				System.out.println("Điểm Marketing: "+diemMarketing+"  |  Điểm Sales: "+diemSales);
			}
			
		 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
