package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BangDiemDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from bangdiem");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void insert() {
		
	}
}
