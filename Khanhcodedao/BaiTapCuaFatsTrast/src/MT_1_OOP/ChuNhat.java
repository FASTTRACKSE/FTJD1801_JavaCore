package MT_1_OOP;

import java.util.Scanner;

public class ChuNhat {
	public static int chieurong ;
	public static int chieudai ;
	public double chuvi;
	public double dientich;
	Scanner sc = new Scanner(System.in);
	
	public ChuNhat() {
		
	}
	public ChuNhat(int chieurong, int chieudai) {
		this.chieurong = chieurong;
		this.chieudai = chieudai;
	}
	
	public void nhap() {
		System.out.println(" nhap chieu dai : ");
		chieudai = Integer.parseInt(sc.nextLine());
		System.out.println(" nhap chieu rong : ");
		chieurong = Integer.parseInt(sc.nextLine());
	}
	
	public  void getchuvi() {
		 chuvi = (chieudai + chieurong)*2;
	}
	public void getdientich() {
		 dientich = chieudai * chieurong;
	}
	
	public void xuat() {
		System.out.println(" chu vi hinh chu nhat la : "+chuvi+" (dvdd)");
		System.out.println(" dien tich hinh chu nhat la : "+dientich+" (dvdt)");
	}
	
	public static void main(String[] args) {
		ChuNhat cn = new ChuNhat();
		cn.nhap();
		cn.getchuvi();
		cn.getdientich();
		cn.xuat();
	}
}
