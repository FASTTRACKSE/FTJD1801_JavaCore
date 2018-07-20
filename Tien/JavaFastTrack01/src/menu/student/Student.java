package menu.student;

import java.util.ArrayList;

public class Student {
	private String id;
	private String name;
	private String address;
	private int age;
	private double gpa;
	
	ArrayList<Student> students = new ArrayList<Student>();
	
	public Student() {
		super();
	}

	public Student(String id, String name, String address, int age, double gpa) {
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
		
	}
	public void updateStudent() {
		
	}
	public void removeStudent() {
		
	}
	public void sortStudent() {
		
	}
	public void output() {
		
	}
}
