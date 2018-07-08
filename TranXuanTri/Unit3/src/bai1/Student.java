package bai1;

import java.util.Scanner;

public class Student {
	public String id;
	public String name;
	public int age;
	public String address;
	public double gpa;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input student id: ");
		this.id = sc.nextLine();
		
		System.out.print("Input student name: ");
		this.name = sc.nextLine();
		
		System.out.print("Input student age: ");
		this.age = Integer.parseInt(sc.nextLine());
		
		System.out.print("Input student address: ");
		this.address = sc.nextLine();
		
		System.out.print("Input student gpa: ");
		this.gpa = sc.nextDouble();
	}
	public void output() {
		System.out.println(this.id + "|" + this.name + "|" + this.age + "|" + this.address + "|" + this.gpa);
	}
	public static void main(String agr[]) {
		Student st = new Student();
		st.input();
		st.output();
	}
}
