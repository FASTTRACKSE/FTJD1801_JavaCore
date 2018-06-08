package oop;

import java.util.Scanner;

public class Student {
	public String id, fullName, address;
	int age;
	double javaScore, htmlScore;
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Mã sinh viên: ");
		this.id = input.nextLine();
		System.out.println("Tên sinh viên: ");
		this.fullName = input.nextLine();
		System.out.println("Tuổi: ");
		this.age = Integer.parseInt(input.nextLine());
		System.out.println("Địa chỉ: ");
		this.address = input.nextLine();
		System.out.println("Điểm java: ");
		this.javaScore = Double.parseDouble(input.nextLine());
		System.out.println("Điểm html: ");
		this.htmlScore = Double.parseDouble(input.nextLine());
	}
	public void output() {
		System.out.println("THÔNG TIN SINH VIÊN \nMã sinh viên: "+this.id+"\nTên sinh viên: "+this.fullName+"\nTuổi: "+this.age+"\nĐịa chỉ: "+this.address+"\nĐiểm trung bình: "+this.average()+"\nXếp hạng: "+this.rank());
	}
	public double average() {
		return (this.htmlScore + this.javaScore) / 2;
	}
	public String rank() {
		if(this.average() < 6) {
			return "C";
		}else if(this.average() < 8) {
			return "B";
		}else {
			return "A";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st = new Student();
		st.input();
		st.output();
	}

}
