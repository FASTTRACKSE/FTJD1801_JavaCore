package baitapStudent;
import java.util.Scanner;
public class SinhVien {
	public String id, name, address;
	int age;
	double gpa;
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		this.id = sc.nextLine();
		System.out.println("Nhập name:");
		this.name = sc.nextLine();
		System.out.println("Nhập address:");
		this.address = sc.nextLine();
		System.out.println("Nhập age:");
		this.age = sc.nextInt();
		System.out.println("Nhập gpa:");
		this.gpa = sc.nextDouble();
	}
	public void output() {
		System.out.println(this.id + "/" +this.name +"/"+this.address +"/"+this.age +"/"+this.gpa);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sv = new SinhVien();
		sv.input();
		sv.output();

	}

}
