package sinhvienmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	public int id;
	public String name;
	public String group;

	public Student() {
		super();

		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public void show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void add() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap id sinh vien can them: ");
		String id = sc.nextLine();
		System.out.print("Nhap ho ten sinh vien can them: ");
		String name = sc.nextLine();
		System.out.print("Nhap group sinh vien can them: ");
		String group = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into students values (\"" + id + "\",\"" + name + "\",\"" + group + "\")");
			System.out.println("THÊM THÀNH CÔNG!");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void edit() {
		String newname;String newgroup;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap id sinh vien can sua: ");
		String idSua = sc.nextLine();
		
		System.out.print("Nhap id sinh vien cap nhat: ");
		String id = sc.nextLine();
		
		System.out.print("Input new name :");
		newname = sc.nextLine();
		
		System.out.print("Input new group :");
		newgroup = sc.nextLine();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
		Statement stmt = con.createStatement();

		stmt.executeUpdate("update students set id= \""+id+"\",name =\""+newname+"\",group=\""+newgroup+"\" where id = \""+idSua+"\" ");
		 System.out.println("Cap nhap thanh cong");
		

		} catch(Exception e) {
		System.out.println(e);
		} 
	}
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap id can xoa ");
		String idXoa = sc.nextLine();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
		Statement stmt = con.createStatement();

		stmt.executeUpdate("delete from students WHERE id = \""+idXoa+"\" ");
		 System.out.println("Da xoa thanh cong");
		

		} catch(Exception e) {
		System.out.println(e);
		} 
	}
}