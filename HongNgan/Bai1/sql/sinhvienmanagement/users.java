package sinhvienmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class users {
	public int id;
	public String userName;
	public String password;
	public String role;

	public users() {
		super();
	
	}

	public users(int id, String userName, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap userName :");
		userName = sc.nextLine();
		System.out.println("nhap pass:");
		password = sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				String userName = rs.getString(2);
				String _pass = rs.getString(3);
				if (this.userName.equals(userName) && this.password.equals(_pass)) {
					role = rs.getString(4);
					if (role.equals("GiangVien")) {
						System.out.println("Xin chao giang vien: " + userName );
						Student std = new Student();
						std.show();
					} else if (role.equals("Can Bo")) {
						System.out.println("Xin chao can bo: " + userName);
						Student std = new Student();
						std.add();
					}
				
				}

			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}