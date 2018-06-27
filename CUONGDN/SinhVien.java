package quanlysinhvien;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
public class SinhVien{
	
	private String ten;
	private String ID;
	private double gpa;
	private int age;
	
	
	
	public SinhVien() {
		super();

	}
public SinhVien(String ten, String iD, double gpa, int age) {
	super();
	this.ten = ten;
	this.ID = iD;
	this.gpa = gpa;
	this.age = age;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public double getGpa() {
	return gpa;
}
public void setGpa(double gpa) {
	this.gpa = gpa;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

public void nhap() {
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("Moi ban nhap ten SV ");
	 this.ten = sc.nextLine();
	 System.out.println("Moi ban nhap id SV");
	 this.ID = sc.nextLine();
	 System.out.println("Moi ban nhap tuoi ");
	 this.age = Integer.parseInt(sc.nextLine());
	 System.out.println("Moi ban nhap diem GPA");
	 this.gpa = Double.parseDouble(sc.nextLine());
}
public void xuat() {
	System.out.println(this.ten + " | " + this.gpa);
}

		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> Menu = new ArrayList<>();
		while(true) {
			System.out.println("1. Them sinh vien");
			System.out.println("2. Cap nhat thong tin sinh vien theo ID");
			System.out.println("3. Xoa sinh vien theo ID");
			System.out.println("4. Sap xep sinh vien theo ten");
			System.out.println("5. Hien thi danh sach sinh vien");
			System.out.println("0. Ket thuc chuong trinh");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Nhap so luong sinh vien muon them");
				int soluong = sc.nextInt();
				SinhVien sv = new SinhVien();
				for(int i= 0; i < soluong; i++) {
					sv.nhap();
					Menu.add(sv);
				}
			} else if (choice == 2) {
			System.out.print("Nhap so ID sinh vien can cap nhat");
			String idSua = sc.nextLine();
			for (int i = 0; i < Menu.size(); i++) {
				if (Menu.get(i).getID().equals(idSua)) {
					Menu.get(i).nhap();
				}
			}
		} else if (choice == 3) {
			System.out.print("Nhap so ID sinh vien can xoa");
			String idXoa = sc.nextLine();
			for (int i = 0; i < Menu.size(); i++) {
				if (Menu.get(i).getID().equals(idXoa)) {
					Menu.remove(i);
				}
			}

		} else if (choice == 4) {
			Collections.sort(Menu,new Comparator<SinhVien>() {
			public int compare(SinhVien sv1,SinhVien sv2) {
			return sv1.getTen().compareTo(sv2.getTen());
			}
			});
		} else if (choice == 5) {
			for (int i = 0; i < Menu.size(); i++) {
				Menu.get(i).xuat();
			}
		} else if (choice == 0)
			break;
	}
}
}
	
