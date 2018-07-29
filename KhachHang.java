package bienlai;

import java.util.Scanner;

public class KhachHang {
		private String hoTen;
		private String soNha;
		private String maSoCongTo;
		
		public KhachHang() {
			super();
		}

		public KhachHang(String hoTen, String soNha, String maSoCongTo) {
			super();
			this.hoTen = hoTen;
			this.soNha = soNha;
			this.maSoCongTo = maSoCongTo;
		}

		public String getHoTen() {
			return hoTen;
		}

		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}

		public String getSoNha() {
			return soNha;
		}

		public void setSoNha(String soNha) {
			this.soNha = soNha;
		}

		public String getMaSoCongTo() {
			return maSoCongTo;
		}

		public void setMaSoCongTo(String maSoCongTo) {
			this.maSoCongTo = maSoCongTo;
		}
		
		public void nhap() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhập họ và tên chủ hộ: ");
			this.hoTen = sc.nextLine();
			System.out.println("Số nhà: ");
			this.soNha = sc.nextLine();
			System.out.println("Mã số công tơ:");
			this.maSoCongTo = sc.nextLine();
		}
		
		public void xuat() {
			System.out.print("Ten chu ho: "+this.hoTen+"  |So nha: "+this.soNha+"  |Maso: "+this.maSoCongTo);
		}
	}


}
