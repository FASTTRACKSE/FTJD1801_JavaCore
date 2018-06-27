package unit_5;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Nguoi {

	private String hoTen;
	private Date ngaysinh;
	private String soCMND;
	
	Scanner sc = new Scanner(System.in);
	public Nguoi() {
		
	}
	public Nguoi(String hoTen,Date ngaysinh ,String soCMND) {
		
		this.hoTen = hoTen;
		this.ngaysinh = ngaysinh;
		this.soCMND = soCMND;
	}
	
	public void nhap() {
		System.out.print(" nhap vao ho ten : ");
		this.hoTen = sc.nextLine();
		System.out.print(" nhap vao nam sinh(dd-mm-yyyy): ");
		String ns = sc.nextLine();
		this.ngaysinh = ChuyenStringDate(ns);
		System.out.print(" nhap vao so CMND : ");
		this.soCMND = sc.nextLine();
	}
	public void xuat() {
		System.out.println(" ho ten khach hang : "+hoTen);
		System.out.println(" so CMND(can cuoc) : "+soCMND);
	}
	public Date ChuyenStringDate(String st) {
		Date ns = null;
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
			try {
				ns = sd.parse(st);
			}catch(Exception e) {
				System.out.println(" loi dainh dang thoi gian");
			}
		return ns;
	}
	public String getsoCMND() {
		return this.soCMND;
	}
	
}
