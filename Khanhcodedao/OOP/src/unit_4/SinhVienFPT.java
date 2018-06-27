package unit_4;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

abstract public class SinhVienFPT {
	public String hoten;
	public String nghanhhoc;
	
	public SinhVienFPT() {
		
	}
	
	public SinhVienFPT(String hoten, String nghanhhoc) {
		this.hoten = hoten;
		this.nghanhhoc = nghanhhoc;
	}


	Scanner sc = new Scanner (System.in);
	
	public void nhap() {
		System.out.println(" nhap ten sinh vien : ");
		hoten = sc.nextLine();
		System.out.println(" nhap nghanh hoc : ");
		nghanhhoc = sc.nextLine();
	}
	abstract public double getDiem() ;
	
	
	public String gethocLuc() {
		
		if(getDiem() < 5) {
			return "Yeu";
		}
		else if(getDiem() < 6.5){
			return " Trung Binh ";
		}
		else if(getDiem() < 7.5){
			return "Tien Tien ";
		}
		else if (getDiem() < 9){
			return " Gioi ";
		}
		else {
			return " Xuat Sac";
		}
		
	}	
	
	public void xuat() {
		System.out.println(" ten sinh vien : "+hoten);
		System.out.println(" nghanh hoc : "+nghanhhoc);
	}
}
