package lopsinhvien;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class SinhVienFpt {
	public String hoTen;
	public  String nganh;
	public String id;
	public int tuoi;


	public SinhVienFpt() {
		super();
	}

	public SinhVienFpt(String hoTen, String nganh, String id, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.nganh = nganh;
		this.id = id;
		this.tuoi = tuoi;
		
	}
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void nhap(ArrayList<SinhVienFpt> a) {
		Scanner sc = new Scanner(System.in);
		

		for (;;) {
			try {
				System.out.println("nhap ho va ten sinh vien ");
				this.hoTen = sc.nextLine();
				SinhVienException.chkTrinhDo(hoTen);

				break;
			} catch (SinhVienException e) {
				System.out.println(e);
				System.out.println();
			}

		}
		for (;;) {
			try {
				System.out.println("nhap id sinh vien");
				this.id = sc.nextLine();
				SinhVienException.idSinhVien(id, a);
				break;
			} catch (SinhVienException e) {
				System.out.println(e);
				System.out.println();

			}
		}
		for(;;) {
			try {
				System.out.println("nhap tuoi");
				this.tuoi = Integer.parseInt(sc.nextLine());
				SinhVienException.ktTuoi(tuoi);
				break;
			}catch (SinhVienException e) {
				System.out.println(e);
				System.out.println();

			}
		}
	}
	public double nhapDiem() {
		
	
		Scanner sc = new Scanner(System.in);
		double diem;
		for(;;) {
			try {
				diem = Double.parseDouble(sc.nextLine());
				SinhVienException.ktDiem(diem);
				return diem;
			}
			catch(SinhVienException e) {
				System.out.println(e);	
				System.out.println();
			
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
		System.out.println(this.hoTen + " || " + this.nganh + " || " + getDiem() + " || " + getHocLuc());
}
}

	