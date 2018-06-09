package MT_1_OOP;

import java.util.Scanner;
public class Unit_3_QLSV {
	public String ten;
	public int tuoi;
	public String masv;
	public double diemtb;
	public double java;
	public double html;
	
	Scanner sc = new Scanner(System.in);
	public void NhapTT() {
		System.out.print(" nhap vao ten sinh vien : ");
		ten =sc.nextLine();
		System.out.print(" nhap vao tuoi sinh vien : ");
		tuoi = Integer.parseInt(sc.nextLine());              // ban chat la ep kieu
		System.out.print(" nhap vao ma sinh vien : ");
		masv = sc.nextLine();
		System.out.print(" nhap vao diem java : ");
		java = Double.parseDouble(sc.nextLine());
		System.out.print(" nhap vao diem html : ");
		html = Double.parseDouble(sc.nextLine());    
	}
	
	
	public void hienThiTT() {
		System.out.println(" ten sinh vien : "+ten);
		System.out.println(" tuoi sinh vien : "+tuoi);
		System.out.println(" ma sinh vien : "+masv);
		System.out.println(" diem trung binh : "+diemtb);
		
	}
	public String xepLoai() {
		if(diemtb <5) {
			return " D ";      // kei ki tru phai co dau ngoac
		}
		else if(diemtb>=5 && diemtb<=6.5) {
			return " C ";
		}
		else if(diemtb>6.5 && diemtb<8) {
			return " B ";
		}
		else {
			return " A ";
		}
	}
	
	public double diemTrungBinh() {
		diemtb = (java+html)/2;
		return diemtb;
	}
	public static void main(String[] args) {  
		Unit_3_QLSV QL = new Unit_3_QLSV();
		QL.NhapTT();
		System.out.println("-------------------------------");
		QL.diemTrungBinh();
		QL.hienThiTT();
		String st = QL.xepLoai();             // phai tao cho no 1 kieu du lieu tra ve
		System.out.println(" xep loai : "+st);// xuat ra man hinh
	}
}
