package final_assignment;

import java.sql.*;
import java.util.Scanner;

public class User {
	String userName;
	String password;
	String role;

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap user name: ");
		this.userName = sc.nextLine();
		System.out.println("Nhap password: ");
		this.password = sc.nextLine();
		System.out.println("Nhap chuc nang: ");
		this.role = sc.nextLine();
	}
	public void dangNhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----LOGIN----");
		System.out.println("nhap user name: ");
		this.userName = sc.nextLine();
		System.out.println("Nhap password: ");
		this.password = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {	
			String userName = rs.getString(2);
			String pass = rs.getString(3);
			if (this.userName.equals(userName) && this.password.equals(pass)) {
				role = rs.getString(4);
				if (role.equals("Giang Vien")) {
					System.out.println("Xin chao giang vien: " + userName );
					Students std = new Students();
					std.showStudents();
				} else if (role.equals("Can Bo")) {
					System.out.println("Xin chao can bo: " + userName);
					Students std = new Students();
					std.editStudents();
				}
			}

			}
				con.close();
		} catch (Exception e ) {
			System.out.println(e);
		}
	}

}
