package lopsinhvien;
import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt {
  
	public double diemJava;
	public double diemHtml;
	public double diemCss;
	
	public SinhVienIT() {
		super();
	}

	public SinhVienIT(String hoTen, String nganh, double diemJava, double diemHtml, double diemCss) {
 super();
		this.diemJava = diemJava;
		this.diemHtml = diemHtml;
		this.diemCss = diemCss;
	}
	
	public void nhap(ArrayList<SinhVienFpt> a) {
		super.nhap(a);
		Scanner sc = new Scanner(System.in);

		System.out.println("Moi nhap diem java");
		this.diemJava = nhapDiem();
		System.out.println("Moi nhap diem html");
		this.diemHtml = nhapDiem();
		System.out.println("Moi nhap diem css");
		this.diemCss = nhapDiem();
	}

	@Override
	public double getDiem() {
		return(this.diemJava * 2 + this.diemHtml + this.diemCss)/4;

	}
 
	public void xuat() {
		System.out.println(this.hoTen + "|" + this.nganh + "|Diem trung binh" + getDiem() + "|Hoc Luc" + getHocLuc() + "|diemjava" + this.diemJava + "|Diem html" + this.diemHtml + "|diem css" + this.diemCss);
	}
	
	
	
	}
	
	
	
	

