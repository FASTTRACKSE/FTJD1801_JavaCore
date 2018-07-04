package test.write.file;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable{
	public String id, fullName, address;
	int age;
	double javaScore, htmlScore;

	public Student(String id, String fullName, String address, int age, double javaScore, double htmlScore) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.age = age;
		this.javaScore = javaScore;
		this.htmlScore = htmlScore;
	}
	
	public Student() {
		super();
	}

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

	@Override
	public String toString() {
		return "Ma sinh vien: " + id + "  |  Ho ten: " + fullName + "  |  Dia chi: " + address + "  |  Tuoi: " + age + "  |  Diem Java: "
				+ javaScore + "  |  Diem html: " + htmlScore + "  |  Diem trung binh: "+this.average()+"  |  Xep hang: "+this.rank();
	}

	public double average() {
		return (this.htmlScore + this.javaScore) / 2;
	}

	public String rank() {
		if (this.average() < 6) {
			return "C";
		} else if (this.average() < 8) {
			return "B";
		} else {
			return "A";
		}
	}
}
