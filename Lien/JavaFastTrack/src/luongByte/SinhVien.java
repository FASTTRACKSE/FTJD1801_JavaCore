package luongByte;

import java.io.Serializable;
import java.util.Scanner;

public class SinhVien implements Serializable{
	public String id, name, address;
	int age;
	double java;
	double html;
	
	public SinhVien(String id, String name, String address, int age, double java, double html) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.java = java;
		this.html = html;
	}
	public SinhVien() {
		super();
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		this.id = sc.nextLine();
		System.out.println("Nhập name:");
		this.name = sc.nextLine();
		System.out.println("Nhập address:");
		this.address = sc.nextLine();
		
		System.out.println("Nhập age:");
		this.age = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhập điểm java:");
		java = Double.parseDouble(sc.nextLine());
		System.out.println("Nhập điểm html:");
		html = Double.parseDouble(sc.nextLine());
	}
	public double average() {
	 return (html + java) / 2;
	}
	
	public String rank() {
		
		if(average()>=8) {
			return "A";
		}else if(average()>=6) {
			return "B";
		}else {
			return "C";
		}
	
	}
	
	public void output() {
		System.out.println(this.id + "/" +this.name +"/"+this.address +"/"+this.age +"/"+this.java+"/"+this.html+"\nxếp hạng: " +rank());
	}
	
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", java=" + java
				+ ", html=" + html + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
