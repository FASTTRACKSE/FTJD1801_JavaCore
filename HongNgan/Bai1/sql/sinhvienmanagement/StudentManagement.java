package sinhvienmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagement extends Student {

	public static void main(String[] args) {
		Student st = new Student();
		users usr = new users();
		usr.login();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("------QUAN LY SINH VIEN------");
			System.out.println("Xin vui long chon phim chuc nang");
			System.out.println("Phim 1. Xem danh sach sinh vien");
			System.out.println("Phim 2. Them  sinh vien");
			System.out.println("Phim 3. Sua  sinh vien");
			System.out.println("Phim 4. Xoa sinh vien");
			System.out.println("Phim 5. Dang xuat");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				st.show();
				break;
			case 2:
				st.add();
				break;
			case 3:
				st.edit();
				break;
			case 4:
				st.delete();
				break;
			case 5:
				System.out.println("----DANG XUAT THANH CONG ----");
				break;
			}
			if (choice == 5) {
				break;
			}

		}

	}
}
