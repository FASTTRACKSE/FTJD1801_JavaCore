package oop;

import java.util.Scanner;

public class Student {
	public String id, fullName, address;
	int age;
	double gpa;
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Mã sinh viên: ");
		id = input.nextLine();
		System.out.println("Tên sinh viên: ");
		fullName = input.nextLine();
		System.out.println("Tuổi: ");
		age = Integer.parseInt(input.nextLine());
		System.out.println("Địa chỉ: ");
		address = input.nextLine();
		System.out.println("Điểm trung bình: ");
		gpa = Double.parseDouble(input.nextLine());
	}
	public void output() {
		System.out.println("THÔNG TIN SINH VIÊN \nMã sinh viên: "+id+"\nTên sinh viên: "+fullName+"\nTuổi: "+age+"\nĐịa chỉ: "+address+"\nĐiểm trung bình: "+gpa);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st = new Student();
		st.input();
		st.output();
	}

}
