package unit3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanliSinhVien {
	private String id,name,address;
	private int age;
	private double gpa;
	
	public QuanliSinhVien() {
		super();
	}
	
	public QuanliSinhVien(String id, String name, String address, int age, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhâp id: ");
		this.id = sc.nextLine();
		
		System.out.println("Nhập tên: ");
		this.name = sc.nextLine();
		
		System.out.println("Nhập địa chỉ: ");
		this.address = sc.nextLine();
		
		System.out.println("Nhập tuổi: ");
		this.age = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhập điểm trung bình: ");
		this.gpa = Double.parseDouble(sc.nextLine());
		}
	
		public void output() {
		System.out.println(this.name + "|" + this.gpa );
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Cập nhật thông tin sinh viên theo ID");
			System.out.println("3. Xóa sinh viên theo ID");
			System.out.println("4. Sắp xếp sinh viên theo tên");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("0. Kết thúc chương trình");
			System.out.print("Chọn thao tác");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			ArrayList<QuanliSinhVien>listStudents = new ArrayList<QuanliSinhVien>();
			switch(choice) {
				case 1: System.out.println("Nhập số lượng sinh viên cần nhập: ");
					int so = sc.nextInt();
					for(int i = 0; i < so; i++) {
						QuanliSinhVien sinhvien = new QuanliSinhVien();
						sinhvien.input();
						listStudents.add(sinhvien);
					}
				case 2: System.out.println("Nhập ID cần cập nhật: ");
					String update = sc.nextLine();
					String name,address;
					double gpa;
					int age;
					QuanliSinhVien lst = new QuanliSinhVien();
						for(int i = 0; i < listStudents.size(); i ++) {
							if(listStudents.get(i).getId().equals(update)) {
								lst = listStudents.get(i);
								
								System.out.println("Nhập tên: ");
								name = sc.nextLine();
								lst.setName(name);		
								
								System.out.println("Nhập địa chỉ: ");
								address = sc.nextLine();
								lst.setAddress(address);
										
								System.out.println("Nhập tuổi: ");
								age = sc.nextInt();
								lst.setAge(age);
			
								System.out.println("Nhập điểm trung bình: ");
								gpa = sc.nextDouble();
								lst.setGpa(gpa);
								}
							}
				case 3: System.out.println("Nhập id cần xóa: ");
					String delete = sc.nextLine();
					QuanliSinhVien sinhvien = new QuanliSinhVien();
						for(int i = 0; i < listStudents.size(); i++) {
							if(listStudents.get(i).getId().equals(delete)) {
								sinhvien = listStudents.get(i);
								listStudents.remove(sinhvien);
								}
							}
				case 4: Collections.sort(listStudents, new Comparator<QuanliSinhVien>() {
					public int compare(QuanliSinhVien sv1, QuanliSinhVien sv2) {
						return sv1.getName().compareTo(sv2.getName());
					}
						 });
				case 5: for(int i = 0; i < listStudents.size(); i++) {
					listStudents.get(i).output();
					}
				case 0: 
					break;
					}
				}

	}

}
