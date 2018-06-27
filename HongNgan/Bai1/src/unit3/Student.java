package unit3;

import java.util.Scanner;

public class Student extends Exception{
	public String id;
	public String name;
	public int age;
	public String address;
	public double dtb;
	public double java;
	public double html;
	
	public Student( ) {
		// TODO Auto-generated constructor stub
	}
	public Student(String errHoTen) {
		
	}
	

	public void input() {
		Scanner sc= new Scanner (System.in);
		
		System.out.println("Nhập id:");
		this.id=sc.nextLine();
		
		System.out.println("Nhập Tên:");
		this.name=sc.nextLine();
		
		System.out.println("Nhập age:");
		this.age=Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhập Địa Chỉ:");
		this.address=sc.nextLine();
		
		System.out.println("Nhập java:");
		this.java=Double.parseDouble(sc.nextLine());
		
		System.out.println("Nhập html:");
		this.html=Double.parseDouble(sc.nextLine());
	}
	
	public void output() {
		System.out.println(this.id);
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.address);
		System.out.println(this.dtb);
	}
	
	public String xeploai() {
		if (dtb>=8) {
			return "A";
		}
		else if (dtb >6 ) {
			return "B";
		}
		else {
			return "C";
		}
	}
	public double diemTB() {
		
		this.dtb=(this.java+this.html)/2;
		return dtb;
	}
	static public void chkName(String ten) throws Student{
		if (ten.equals("")) {
			throw new Student("Ho ten rong");
		}
		if (ten.length()>40) {
			throw new Student("Ho ten dai qua quy dinh");
		}
	}
	static public void chkId(String id)throws Student{
		
	}
	
	public static void main(String[] args) {
		Student sv=new Student();
		sv.input();
		sv.output();
		String xep= sv.xeploai();
		System.out.println(xep);
	
	}

}
