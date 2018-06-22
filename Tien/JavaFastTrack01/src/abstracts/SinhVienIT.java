package abstracts;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt{
	
	private double diemJava;
	private double diemHtml;
	private double diemCss;
	
	
	public SinhVienIT() {
		super();
	}

	
	public SinhVienIT(double diemJava, double diemHtml, double diemCss) {
		super();
		this.diemJava = diemJava;
		this.diemHtml = diemHtml;
		this.diemCss = diemCss;
	}

	
	public double getDiemJava() {
		return diemJava;
	}


	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}


	public double getDiemHtml() {
		return diemHtml;
	}


	public void setDiemHtml(double diemHtml) {
		this.diemHtml = diemHtml;
	}


	public double getDiemCss() {
		return diemCss;
	}


	public void setDiemCss(double diemCss) {
		this.diemCss = diemCss;
	}
	
	public void nhap(ArrayList<SinhVienFpt> list) {
		super.nhap(list);
		Scanner sc = new Scanner(System.in);
		System.out.println("Điểm Java: ");
		diemJava = Double.parseDouble(sc.nextLine());
		System.out.println("Điểm Html: ");
		diemHtml = Double.parseDouble(sc.nextLine());
		System.out.println("Điểm CSS: ");
		diemCss = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		super.xuat();		
	}
	public void xuatIT() {
		super.xuat();
		System.out.println("Điểm Java: "+diemJava+"  |  Điểm Html: "+diemHtml+"  |  Điểm CSS: "+diemCss);
	}
	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (2*diemJava+diemHtml+diemCss)/4;
	}
	
}
