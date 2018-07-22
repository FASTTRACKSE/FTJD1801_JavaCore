package lopsinhvien;
import java.util.Scanner;
public abstract class SinhVienFpt {
	public String hoTen;
	public  String nganh;

	public SinhVienFpt() {
		super();
	}

	public SinhVienFpt(String hoTen, String nganh) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;

	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ho va ten sinh vien ");
		this.hoTen = sc.nextLine();
		System.out.println("nhap nganh sinh vien ");
		this.nganh = sc.nextLine();
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
		System.out.println(this.hoTen + " || " + this.nganh + " || " + getDiem() + " || " + getHocLuc());
}
}

	