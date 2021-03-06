package final_assignment;

import java.sql.*;
import java.util.Scanner;


public class Students {
	int idStudent;
	String name;
	String group;
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void showStudents() {
		System.out.println("-----Danh Sach Sinh Vien-----");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			con.close();
		} catch (Exception e ) {
			System.out.println(e);
		}
	}
	public void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap id sinh vien can them: ");
		String id = sc.nextLine();
		System.out.print("Nhap ho ten sinh vien can them: ");
		String name = sc.nextLine();
		System.out.print("Nhap group sinh vien can them: ");
		String group = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into students values (\""+id+"\",\""+name+"\",\""+group+"\")");
			con.close();
		} catch (Exception e ) {
			System.out.println(e);
		}
	}
	public void editStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap id sinh vien can sua: ");
		String idSua = sc.nextLine();
//		System.out.print("Nhap id sinh vien cap nhat: ");
//		String id = sc.nextLine();
		System.out.print("Nhap ho ten sinh vien cap nhat: ");
		String name = sc.nextLine();
		System.out.print("Nhap group sinh vien cap nhat: ");
		String group = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
//			stmt.executeUpdate("update students set name='"+name+"', group='"+group+"' where idStudents = '"+idSua+"'");
			String query = "UPDATE students SET  name='"+name+"',groups='"+group+"'  WHERE idStudents = '"+idSua+"'";
//			String query1 = "UPDATE students SET  group='"+group+"'  WHERE idStudents = '"+idSua+"'";
			System.out.println(query);
			PreparedStatement preparedStmt = con.prepareStatement(query);
//			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
//			preparedStmt1.executeUpdate();
			preparedStmt.executeUpdate();
			con.close();
		} catch (Exception e ) {
			System.out.println(e);
		}
	}
	public void deleteStudent() {
		System.out.print("Nhap ID sinh vien can xoa: ");
		Scanner sc = new Scanner(System.in);
		int idXoa = Integer.parseInt(sc.nextLine());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			String query = "delete from students WHERE idStudents = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 preparedStmt.setInt(1, idXoa);
			 preparedStmt.executeUpdate();
			con.close();
		} catch (Exception e ) {
			System.out.println(e);
		}
	}
	public void menuStudents() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("------QUAN LY SINH VIEN------");
			System.out.println("1. Xem danh sach sinh vien");
			System.out.println("2. Them moi sinh vien");
			System.out.println("3. Sua thong tin sinh vien");
			System.out.println("4. Xoa sinh vien");
			System.out.println("5. Dang xuat");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: 
				showStudents();
				break;
			case 2: 
				addStudent();
				break;
			case 3: 
				editStudent();
				break;
			case 4: 
				deleteStudent();
				break;
			case 5: 
				System.out.println("Dang xuat thanh cong");
				break;
			}
			if (choice == 5) {
				break;
			}
		}
	}
}
