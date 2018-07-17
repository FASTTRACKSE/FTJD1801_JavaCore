package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GiaoDich extends Users {

		private String tgian;
		private double soTien;
		public GiaoDich() {
			super();
		}
		public GiaoDich(String tgian, double soTien) {
			super();
			this.tgian = tgian;
			this.soTien = soTien;
		}
		public String getTgian() {
			return tgian;
		}
		public void setTgian(String tgian) {
			this.tgian = tgian;
		}
		public double getSoTien() {
			return soTien;
		}
		public void setSoTien(double soTien) {
			this.soTien = soTien;
		}
		public void nhap() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Thời gian: ");
			this.tgian = sc.nextLine();
			System.out.println("Số tiền giao dịch: ");
			this.soTien = Double.parseDouble(sc.nextLine());

		}
		public void xuat() {
			super.xuat();
			System.out.println("Thời gian: "+this.tgian+"  | Số tiền: "+this.soTien);
		}
		
}
