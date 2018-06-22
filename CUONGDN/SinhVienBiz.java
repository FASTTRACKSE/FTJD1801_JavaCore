package lopsinhvien;
import java.util.Scanner;
public class SinhVienBiz extends SinhVienFpt {
	public double diemMarketing;
	public double diemSales;
	
	public SinhVienBiz() {
		super();
	}

	public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}
	
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi nhap diem marketing ");
		this.diemMarketing = Double.parseDouble(sc.nextLine());
		System.out.println("Moi nhap diem sales ");
		this.diemSales = Double.parseDouble(sc.nextLine());
	}
	
	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (this.diemMarketing * 2 + this.diemSales) / 3;
	}
	public void xuat() {
		System.out.println(this.hoTen + "|" + this.nganh + "|Diem trung binh: " + this.getDiem() + "|Diem Marketing: " + this.diemMarketing + "|Diem Sales: " + this.diemSales + "|" + this.getHocLuc());
	}

		
	

}
