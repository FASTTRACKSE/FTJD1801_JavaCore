package unit4.sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienBiz extends SinhVienFPT {
	public double diemMarketing;
	public double diemSales;
	public double dtb;
	
	public SinhVienBiz() {
		super();
	}
	public SinhVienBiz(String hoTen,double diemMarketing, double diemSales) {
		super();
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	public void nhap(ArrayList<SinhVienFPT> list) {
		super.nhap(list);
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap diem maketting: ");
		this.diemMarketing=Double.parseDouble(sc.nextLine());
		
		System.out.println("Nhap diem Sales: ");
		this.diemSales=Double.parseDouble(sc.nextLine());
	}
	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
	
		
		return dtb=(2*diemMarketing+diemSales)/3 ;
	}
	
}




