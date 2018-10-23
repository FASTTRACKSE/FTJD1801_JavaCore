package sinhvien;

import java.sql.*;

public class SinhVien {
	public String maSV;
	public String tenSv;
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlisinhvien", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from sinhvien");
			while (rs.next()) {
				System.out.println(rs.getString(1)+" | " +rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
