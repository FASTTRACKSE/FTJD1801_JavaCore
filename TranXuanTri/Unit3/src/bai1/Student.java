package bai1;

import java.util.Scanner;

public class Student {
	public String id;
	public String name;
	public int age;
	public String address;
	public double gpa;
	public int java;
	public int html;
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
		
		System.out.print("Input student java point: ");
		this.java = sc.nextInt();
		
		System.out.print("Input student html point: ");
		this.html = sc.nextInt();
	}	
	
	public void output() {
		System.out.print(this.id + "|" + this.name + "|" + this.age + "|" + this.address + "|" + calGpa());
	}
	
	public String gpa() {
		if (gpa>=8) {
			return "A";
		}
		else if (gpa>=6) {
			return "B";
		}
		else  
			return "C";
	}
	
	public double calGpa() {
		return gpa = (java + html)/2;
	}
	
	public static void main(String agr[]) {
		Student st = new Student();
		st.input();
		st.output();
		System.out.print("|" + st.gpa());
	}
}
