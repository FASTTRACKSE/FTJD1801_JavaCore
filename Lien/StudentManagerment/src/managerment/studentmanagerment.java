package managerment;

import java.sql.*;
import java.util.Scanner;

public class studentmanagerment {
	public void Login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập user:");
		String user = sc.nextLine();
		System.out.println("vui lòng nhập password:");
		String password = sc.nextLine();
		users us = new users(user);
		if (password.equals(us.getPassword())) {
			System.out.println(us.getUsername() + " |Vai trò: " + us.getRole());

		} else {
			System.out.println("Lỗi Đăng nhập!!!");
		}
	}
	
	public static void main(String arg[]) {
		studentmanagerment sm = new studentmanagerment();
		sm.Login();
	}

}
