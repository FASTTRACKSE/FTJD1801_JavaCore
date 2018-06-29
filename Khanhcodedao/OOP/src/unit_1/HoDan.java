package unit_1;

import java.util.Scanner;

	public class HoDan {
	

		 private String tenChuHo;
		 private String soNha;
		 private String msCongTo;
		 
		 Scanner sc = new Scanner(System.in);
		 
		public String getTenChuHo() {
			return tenChuHo;
		}
		public void setTenChuHo(String tenChuHo) {
			this.tenChuHo = tenChuHo;
		}
		public String getSoNha() {
			return soNha;
		}
		public void setSoNha(String soNha) {
			this.soNha = soNha;
		}
		public String getMsCongTo() {
			return msCongTo;
		}
		public void setMsCongTo(String msCongTo) {
			this.msCongTo = msCongTo;
		}
		 
		 public void nhap() {
			 System.out.print(" nhap ten chu ho : ");
			 tenChuHo = sc.nextLine();
			 System.out.print(" so nha : ");
			 soNha = sc.nextLine();
			 System.out.print(" ma so cong to : ");
			 msCongTo = sc.nextLine();
		 }
		 
		 public void xuat() {
			 System.out.println(" ten chu ho : "+tenChuHo);
			 System.out.println(" so nha : "+soNha);
			 System.out.println(" ma so cong to : "+msCongTo);
		 }
	}


