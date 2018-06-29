package unit_1;

	public class BienLai extends HoDan {
		private int chiSoCu;
		private int chiSoMoi;
		private double soTienTra;
		
		public int getChiSoCu() {
			return chiSoCu;
		}
		public void setChiSoCu(int chiSoCu) {
			this.chiSoCu = chiSoCu;
		}
		public int getChiSoMoi() {
			return chiSoMoi;
		}
		public void setChiSoMoi(int chiSoMoi) {
			this.chiSoMoi = chiSoMoi;
		}
		public double getSoTienTra() {
			return soTienTra;
		}
		public void setSoTienTra(double soTienTra) {
			this.soTienTra = soTienTra;
		}
		@Override
		public void nhap() {
			super.nhap();
			System.out.print(" nhap so cu : ");
			chiSoCu = Integer.parseInt(sc.nextLine());
			System.out.print(" nhap so moi : ");
			chiSoMoi = Integer.parseInt(sc.nextLine());
		}
		@Override
		public void xuat() {
			super.xuat();
			System.out.println(" chi so cu : "+chiSoCu);
			System.out.println(" chi so moi : "+chiSoMoi);
			System.out.println(" so tien tra : "+(chiSoMoi-chiSoCu)*750);
		}

	}

