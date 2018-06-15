package bai3;

import java.util.ArrayList;
import java.util.Scanner;

import bai2.SanPham;

public class SinhVien {
	private String id;
	private String name;
	private int age;
	private String address;
	private double gpa;

	public SinhVien() {
		super();
	}

	public SinhVien(String id, String name, int age, String address, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap id sinh vien ");
		this.id = sc.nextLine();

		System.out.print("Nhap ten sinh vien ");
		this.name = sc.nextLine();

		System.out.print("Nhap tuoi ");
		this.age = Integer.parseInt(sc.nextLine());

		System.out.print("Nhap dia chi sinh vien ");
		this.address = sc.nextLine();

		System.out.print("Nhap diem GPA sinh vien ");
		this.gpa = Double.parseDouble(sc.nextLine());
	}

	public void xuat() {
		System.out.println(this.name + " | " + this.gpa);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> Students = new ArrayList<SinhVien>();
		while (true) {
			System.out.println("1. Them sinh vien");
			System.out.println("2. Cap nhat thong tin sinh vien theo ID");
			System.out.println("3. Xoa sinh vien theo ID");
			System.out.println("4. Sap xep sinh vien theo ten");
			System.out.println("5. Hien thi danh sach sinh vien");
			System.out.println("0. Ket thuc chuong trinh");
			System.out.println("Chon thao tac");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.println("Nhap so luong sinh vien");
				Scanner sc1 = new Scanner(System.in);
				int soluong = Integer.parseInt(sc1.nextLine());
				for (int i = 0; i < soluong; i++) {
					SinhVien st = new SinhVien();
					st.nhap();
					Students.add(st);
				}
			} else if (choice == 2) {
				System.out.println("Nhap so ID sinh vien can cap nhat");
				Scanner sc2 = new Scanner(System.in);
				int id1 = Integer.parseInt(sc2.nextLine());
				for (int i = 0; i < Students.size(); i++) {
					if (Students.get(i).id.equals(id1)) {
						System.out.print("Nhap ten sinh vien ");
						String newName = sc.nextLine();
						Students.get(i).setName(newName);
					}
				}
			} else if (choice == 3) {
				System.out.println("Xoa sinh vien theo ID");

			} else if (choice == 4) {
				System.out.println("Sap xep sinh vien theo ten");

			} else if (choice == 5) {
				for (int i = 0; i < Students.size(); i++) {
					Students.get(i).xuat();
				}
			} else if (choice == 0)
				break;
		}
	}
}
