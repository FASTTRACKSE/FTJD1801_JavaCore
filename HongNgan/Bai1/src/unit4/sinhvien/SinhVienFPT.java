package unit4.sinhvien;

import java.util.ArrayList;
import java.util.Scanner;
  abstract public class SinhVienFPT {
	public String hoTen;
	public String nganh;
	public String Masv;
	public double diem;
	public int tuoi;
	public SinhVienFPT() {}
	
	
	
	public SinhVienFPT(String hoTen, String nganh, String masv, double diem, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
		Masv = masv;
		this.diem = diem;
		this.tuoi = tuoi;
	}



	

	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public String getNganh() {
		return nganh;
	}



	public void setNganh(String nganh) {
		this.nganh = nganh;
	}



	public String getMasv() {
		return Masv;
	}



	public void setMasv(String masv) {
		Masv = masv;
	}



	public int getTuoi() {
		return tuoi;
	}



	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}



	public void setDiem(double diem) {
		this.diem = diem;
	}



	public void nhap(ArrayList<SinhVienFPT> list) {
		Scanner sc= new Scanner(System.in);
		for(;;) {
		System.out.println("Nhap ho ten: ");
		this.hoTen=sc.nextLine();
		try {
			SinhVienException.chkName(hoTen);
			break;
		}catch(Exception e) {
			System.err.println(e);
		}
		}
		
		System.out.println("Nhap dia chi: ");
		this.nganh=sc.nextLine();
		
		for(;;) {
		System.out.println("Nhap masv: ");
		this.Masv=sc.nextLine();
		try {
			SinhVienException.chkMaSV(Masv, list);;
			break;
		}catch(Exception e) {
			System.err.println(e);
		}
		}
		for(;;) {
			System.out.println("Nhap diem: ");
			this.diem=Double.parseDouble(sc.nextLine());
			 try {
					SinhVienException.checkDiem(diem);
					break;
			}catch(Exception e) {
					System.err.println(e);
					System.out.println("Moi nhap lai");
				}
			 
		 }
		
		for(;;) {
			System.out.println("Nhap tuoi: ");
			this.tuoi=Integer.parseInt(sc.nextLine());
			 try {
					SinhVienException.checkTuoi(tuoi);
					break;
			}catch(Exception e) {
					System.err.println(e);
					System.out.println("Moi nhap lai");
				}
			 
		 }
		}
	 abstract public double getDiem();
	 
	 public String getHocLuc() {
		 if (getDiem() < 5) {
				return "Yeu";
			} else if (getDiem() < 6.5) {
				return "Trung binh";
			} else if (getDiem() < 7.5) {
				return "Kha";
			} else if (getDiem() < 9) {
				return "Gioi";
			} else
				return "Xuat sac";
		 
	 }
	
	 
	 public void xuat() {
		 System.out.println(this.hoTen+"|"+this.nganh+"|"+this.Masv+"|"+this.getHocLuc());
	 }
}

