// creat a class student
// id name age address gpa + input output + main
package baitapmau;
import java.util.Scanner;
public class Student {
	 
		public int id;
		public String name;
		public String age;
		public String address;
		public double java;
		public double html;
		

		public void input() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap id");
			this.id = Integer.parseInt(sc.nextLine());
			
	 	    System.out.println("Nhap ten");
			this.name = sc.nextLine();
			
			System.out.println("Nhap tuoi");
			this.age = sc.nextLine();
			
			System.out.println("Nhap dia chi");
			this.address = sc.nextLine();
			
			System.out.println("Nhap diem java");
			this.java = sc.nextDouble();
			
			System.out.println("Nhap diem html");
			this.html = sc.nextDouble();
			
		   		
		}
		public void output() {
			System.out.println(this.id);
			System.out.println(this.name);
			System.out.println(this.age);
			System.out.println(this.address);
			System.out.println(this.java);
			System.out.println(this.html);
		}
	
	public double gpa() {
		double gpa = (this.java + this.html)/2;
		return gpa;
	}
	
	public static void main(String[] args) {
		Student st = new Student();
		st.input();
		st.output();
		System.out.println("Diem trung binh GPA : "+ st.gpa());
	}
}

		


